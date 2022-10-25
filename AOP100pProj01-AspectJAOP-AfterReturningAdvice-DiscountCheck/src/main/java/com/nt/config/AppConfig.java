package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.nt.service", "com.nt.aspect"})
public class AppConfig {
	
}
