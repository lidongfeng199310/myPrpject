package com.ldf.java.aop.cglib;
//代理类  
import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;  
  
  
public class CGLibProxy implements MethodInterceptor  
{  
    private Object targetObject;  
      
    public Object createProxyObject(Object targetObject)  
    {  
        this.targetObject = targetObject;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.targetObject.getClass());  
        enhancer.setCallback(this);  
        return enhancer.create();  
    }  
      
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable  
    {  
        ClientBean clientBean = (ClientBean)targetObject;  
        String userName = clientBean.getClientName();  
        Object result = null;  
          
        if(userName != null && !"".equals(userName))  
        {  
            result = method.invoke(targetObject, args);  
        }  
        return result;  
    }  
}  