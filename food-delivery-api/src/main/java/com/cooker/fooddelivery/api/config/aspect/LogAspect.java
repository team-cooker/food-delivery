package com.cooker.fooddelivery.api.config.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * RestController 의 Request,Response Logging
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    private final ObjectMapper objectMapper;

    public LogAspect(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Around("execution(* com.cooker.fooddelivery.api..*Controller.*(..))")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget()
                .getClass()
                .getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String arguments = getRequestArguments(joinPoint);

        log.info(">>> Request : {}, method({}) {}", className, methodName, arguments);

        Object result = joinPoint.proceed();

        log.info("<<< Response : {}, RequestUrl -> {}", objectMapper.writeValueAsString(result), getRequestUrl());

        return result;
    }

    private String getRequestArguments(ProceedingJoinPoint joinPoint) {
        Object[] arguments = joinPoint.getArgs();
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        return parseParametersToJsonFormat(arguments, signature);
    }

    private String parseParametersToJsonFormat(Object[] arguments, CodeSignature signature) {
        StringBuffer stringBuffer = new StringBuffer().append("{");
        int parameterCount = signature.getParameterNames().length;

        for (int i = 0; i < parameterCount; i++) {
            String name = signature.getName();
            try {
                stringBuffer.append(objectMapper.writeValueAsString(name)).append(":");
                stringBuffer.append(objectMapper.writeValueAsString(arguments[i]));

                if (i != parameterCount - 1) {
                    stringBuffer.append(",");
                }
            } catch (JsonProcessingException e) {
                log.error(e.getMessage(), e);
            }
        }
        return stringBuffer.append("}").toString();
    }

    private String getRequestUrl() {
        String requestUrl = "";
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();

            requestUrl = request.getRequestURI();
        }
        return requestUrl;
    }

}
