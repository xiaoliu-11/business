package com.example.business.aop;

import com.alibaba.fastjson.JSON;
import com.example.business.annotation.LogAnnotation;
import com.example.business.entity.OperationLogPO;
import com.example.business.service.OperationLogService;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author: 刘树国
 * @create: 2022-02-17
 * 系统日志：切面处理类
 */


@Component
@Aspect
public class LogAopAspect {

    @Autowired
    private OperationLogService operationLogService;

    /**
     * 定义切入点
     * 在注解的位置切入代码
     */
    @Pointcut("@annotation(com.example.business.annotation.LogAnnotation)")
    public void logPointCut() {
    }

    //切面，配置通知
    @AfterReturning("logPointCut()")
    public void saveOperationLog(JoinPoint joinPoint) {
        System.out.println("切面开始捕获------------");
        //保存日志
        OperationLogPO operationLogPO = new OperationLogPO();
        //从织入点通过反射机制来获得方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获得方法
        Method method = signature.getMethod();

        //获得操作
        LogAnnotation logannotation = method.getAnnotation(LogAnnotation.class);
        if (logannotation != null) {
            String value = logannotation.value();
            operationLogPO.setOperation(value); //保存获得的操作

        }
        //获得请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        // //获取请求的方法名
        String methodName = method.getName();
        operationLogPO.setOperateMethod(className + "." + methodName);

        //获得请求的参数
        Object[] args = joinPoint.getArgs();
        //将参数所在的数组转换成json
        String s = JSON.toJSONString(args);
        operationLogPO.setParams(s);
        //获得用户名
        operationLogPO.setOperator(SecurityUtils.getSubject().getPrincipal().toString());
        //获得ip
        operationLogPO.setOperateIp(SecurityUtils.getSubject().getSession().getHost());

        //调用service保存SysLog实体类到数据库
        operationLogService.save(operationLogPO);
    }
}
































