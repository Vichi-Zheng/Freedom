package com.yilang.commons.utils.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 获取ApplicationContext中对象的工具类<br/>
 * Created with MyElipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2013-12-14<br/>
 * Time: 上午1:17:00<br/>
 *
 */
public class SpringBeanFactoryUtils implements BeanFactoryPostProcessor
{
	private static BeanFactory beanFactory = null;
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
	{
		SpringBeanFactoryUtils.beanFactory = beanFactory;
	}


	public static Object getBean(String name)
	{
		return beanFactory.getBean(name);
	}
}
	 


