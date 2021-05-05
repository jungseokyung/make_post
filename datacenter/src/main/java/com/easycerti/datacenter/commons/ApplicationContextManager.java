package com.easycerti.datacenter.commons;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.Locale;

    public class ApplicationContextManager implements ApplicationContextAware {

	private static final ApplicationContextManager instance = new ApplicationContextManager();
	private ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        instance.applicationContext = arg0;
	}
	
	public static ApplicationContextManager getInstance(){
		return instance;
	}
	
	public <T> T getBean(Class<T> clazz) {
		return (T)applicationContext.getBean(clazz);
	}
	
	public Object getBean(String className){
		return applicationContext.getBean(className);
	}

	private ResourceBundleMessageSource messageSource = null;

	public void setMessageSource(ResourceBundleMessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	/**
	 * property에 지정된 메세지 가져오기
	 * @param key
	 * @return String
	 */
	public String getMessage(String key){
		String returnMessage = null;
		try{
			returnMessage = messageSource.getMessage(key, null, Locale.KOREA);
		}catch(NoSuchMessageException e){
			e.printStackTrace();
		}
		return returnMessage;
	}
	
	/**
	 * property에 지정된 메세지 가져오기
	 * @param key
	 * @return String
	 */
	public String getMessage(String key, String expMessage){
		String returnMessage = null;
		
		try{
			returnMessage = messageSource.getMessage(key, null, Locale.KOREA);
		}catch(NoSuchMessageException e){
			if(expMessage != null)
				returnMessage = expMessage;
			else
				returnMessage = "";
		}
		
		return returnMessage;
	}
}
