package com.winterchen.aspectj;

import com.winterchen.model.Log;
import com.winterchen.service.user.LogService;
import com.winterchen.util.JsonMapper;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

/**
 * aop 切面记录请求日志
 *
 * @package: com.winterchen.aspectj
 * @description：aop 切面记录请求日志
 * @author: Micity
 * @date: Created in 2018/09/12 上午9:43
 * @copyright: Copyright (c) 2018
 * @version: 0.0.1
 * @modified: Micity
 */
@Aspect  //作用是把当前类标识为一个切面供容器读取
@Component
@Slf4j
public class AopLog {
	private static final String START_TIME = "start-request";

	private final LogService logService;

	@Autowired
	public AopLog(LogService logService) {
		this.logService = logService;
	}

	@Pointcut("execution(public * com.winterchen.controller.*Controller.*(..))")
	public void log() {
	}

	@Before("log()") //标识一个前置增强方法，相当于BeforeAdvice的功能
	public void beforeLog(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

//		log.info("【请求 URL】：{}", request.getRequestURL());
//		log.info("【请求 IP】：{}", request.getRemoteAddr());
		log.info("【请求类名】：{}，【请求方法名】：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
		Map parameterMap = request.getParameterMap();
//		log.info("【请求参数】：{}，", JsonMapper.obj2Str(parameterMap));
		Long start = System.currentTimeMillis();
		request.setAttribute(START_TIME, start);
	}

	@Around("log()") //环绕增强，相当于MethodInterceptor
	public Object arroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Object result = proceedingJoinPoint.proceed();
//		log.info("【返回值】：{}", JsonMapper.obj2Str(result));
		return result;
	}

	@AfterReturning("log()") //后置增强，相当于AfterReturningAdvice，方法退出时执行
	public void afterReturning(JoinPoint joinPoint) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Long start = (Long) request.getAttribute(START_TIME);
		Long end = System.currentTimeMillis();
//		log.info("【请求耗时】：{}毫秒", end - start);



		Log log = new Log();
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		log.setUuid(uuid);
		log.setResUrl(request.getRequestURI());
		log.setTime(end - start);
		log.setReqUrl(joinPoint.getSignature().getName());
		logService.insertLog(log);



	}
}
