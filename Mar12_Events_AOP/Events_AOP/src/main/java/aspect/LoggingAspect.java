package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import java.io.IOException;
import java.util.Arrays;

//Exercise4
@Aspect
public class LoggingAspect {
    //Exercise5
    @Around(value = "execution(* *Service*(..))")
    void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("============================Aspect Before Service============================");
        proceedingJoinPoint.proceed();
        System.out.println("============================Aspect After Service============================");
    }

    //Exercise6
    @AfterThrowing(pointcut = "execution(* *(..))", throwing = "e")
    void afterReturningAdvice(IOException e) {
        System.out.println("Running AfterThrowing " + e);
    }

    //Exercise7
    @Before(value = "bean(database)")
    void beforeUsingDatabaseBeanAdvice(JoinPoint joinPoint) {
        //Exercise9
        System.out.println("Before Using Database Bean : " + joinPoint.getThis().getClass().getSimpleName() +
                " having signature : " + joinPoint.getSignature() + " and Arguments : " +
                Arrays.toString(joinPoint.getArgs()));
    }

    //Exercise7
    @After(value = "bean(database)")
    void afterUsingDatabaseBeanAdvice(JoinPoint joinPoint) {
        System.out.println("After Using Database Bean : " + joinPoint.getThis().getClass().getSimpleName());
    }

    //Exercise7
    @Before(value = "within(entity.*)")
    void withinBeforeEntityPackageAdvice() {
        System.out.println("============================Before Anything within Entity Package============================");
    }

    //Exercise7
    @After(value = "within(entity.*)")
    void withinAfterEntityPackageAdvice() {
        System.out.println("============================After Anything within Entity Package============================");
    }

    //Exercise7
    @Before(value = "args(Integer)")
    void beforeIntegerArgumentAdvice() {
        System.out.println("============================Before Method with Integer Argument============================");
    }

    //Exercise7
    @After(value = "args(Integer)")
    void afterIntegerArgumentAdvice() {
        System.out.println("============================After Method with Integer Argument============================");
    }

    //Exercise7
    @Before(value = "this(entity.Database)")
    void beforeDatabaseObjectAdvice() {
        System.out.println("============================Before Method with Database Object============================");
    }

    //Exercise7
    @After(value = "this(entity.Database)")
    void afterDatabaseObjectAdvice() {
        System.out.println("============================After Method with Database Object============================");
    }

    //Exercise8
    @Pointcut("execution(* getPort())")
    void afterBeforeGetPortMethod() {
    }

    //Exercise8
    @Pointcut("execution(* setPort(..))")
    void afterBeforeSetPortMethod() {
    }

    //Exercise8
    @After("afterBeforeGetPortMethod() || afterBeforeSetPortMethod()")
    void afterPortGetterSetter() {
        System.out.println("============================After after Port's Getter Setter============================");
    }
}
