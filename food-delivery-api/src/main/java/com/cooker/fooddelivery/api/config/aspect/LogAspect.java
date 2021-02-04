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
    public Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();

        String className = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        String arguments = getArgumentsToJsonFormat(joinPoint.getArgs(), signature);

        log.info(">>> Request : {}({}), RequestUrl : {}, {}", className, methodName, getRequestUrl(), arguments);

        Object result = joinPoint.proceed();

        log.info("<<< Response : {}({}), {}", className, methodName, objectMapper.writeValueAsString(result));

        return result;
    }

    private String getArgumentsToJsonFormat(Object[] arguments, CodeSignature signature) {
        StringBuffer stringBuffer = new StringBuffer().append("{");
        int parameterCount = signature.getParameterNames().length;
        String[] parameterNames = signature.getParameterNames();

        for (int i = 0; i < parameterCount; i++) {
            try {
                stringBuffer.append(objectMapper.writeValueAsString(parameterNames[i])).append(":");
                stringBuffer.append(objectMapper.writeValueAsString(arguments[i]));

                if (i != parameterCount - 1) {
                    stringBuffer.append(",");
                }
            } catch (JsonProcessingException e) {
                log.error("JsonProcessingException : " + e.getMessage(), e);
            } catch (Exception e) {
                log.error("Exception : " + e.getMessage(), e);
            }
        }
        return stringBuffer.append("}").toString();
    }

    private String getRequestUrl() {
        String requestUrl = "";
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        if (requestAttributes == null) {
            log.debug("not found requestAttributes");
        }
        if (requestAttributes != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                    .getRequest();

            requestUrl = request.getRequestURI();
        }
        return requestUrl;
    }

}
