package com.GreatLearning.SurabiAssignment3.AOPadvice;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class Loggerinfo {
	
Logger log = LoggerFactory.getLogger(Loggerinfo.class);
	
	@Pointcut(value="execution(* com.GreatLearning.SurabiAssignment3.*.*.*(..) )")
	public void myPointcut() {
		
	}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] arr = pjp.getArgs();
		
		
		log.info("method invoked is "+ className+ " : "+methodName+ "()"
				+ ""+ "arguments : "+ mapper.writeValueAsString(arr));
		
		
		Object obj = pjp.proceed();
		
		//This is the response which we got from service layer
		log.info(className + " : "+methodName+ " () " + "Response : "
				+ ""+ mapper.writeValueAsString(obj));
		return obj;
		
		
		
	}

}
