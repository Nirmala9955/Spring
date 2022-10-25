package com.nt.bpp;

import java.time.LocalDateTime;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.nt.bo.BaseBean;

public class BeanDojPostProcessor implements BeanPostProcessor {
	
	public BeanDojPostProcessor() {
		System.out.println("BeanDojPostProcessor : BeanDojPostProcessor()");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanDojPostProcessor : postProcessBeforeInitialization()");
		if (bean instanceof BaseBean) {
			((BaseBean) bean).setDoj(LocalDateTime.now());
		}
		return bean;
	}
	
}
