package com.xpd.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

@Aspect
public class CalcLogAspect {
    //    @Pointcut("execution(public * com.xpd.spring.aop..*(..))")
    @Pointcut("execution(public * com.xpd.spring.aop..*(..)) && @annotation(LogAnnotation)")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Class<?> aClass = joinPoint.getTarget().getClass();
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        Type type = genericParameterTypes[0];

        String[] parameterNames = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();


        System.out.println("genericParameterTypes " + Arrays.toString(genericParameterTypes));
        System.out.println("parameterNames " + Arrays.toString(parameterNames));
        System.out.println("args" + Arrays.toString(args));


        System.out.println(String.format(">>>>>>>> before %s method %s", aClass.getSimpleName(), method.getName()));

    }

    /**
     *
     * @param joinPoint 作为参数必须放在参数列表第一位
     * @param result
     */
    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        Class<?> aClass = joinPoint.getTarget().getClass();
        String simpleName = aClass.getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(String.format(">>>>>>>> afterReturning  %s : %s result is %s", simpleName, methodName, result));
    }

    @AfterThrowing(value = "pointcut()", throwing = "exception")
    public void afterThrowing(Exception exception) {
        System.out.println(">>>>>>>> afterThrowing" + exception);
    }
}
