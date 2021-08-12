package com.asg;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class ValidationMessageConfiguration {
	@Bean("messageSource")
	public MessageSource getMessage()
	{
		ReloadableResourceBundleMessageSource ms = 
			new ReloadableResourceBundleMessageSource();
		
		ms.setBasename("classpath:messages/user");
		ms.setDefaultEncoding("UTF-8");
		
		return ms;
	}
}
