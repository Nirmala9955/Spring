package com.nt.config;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import(value = {AopConfig.class, PersistenceConfig.class, ServiceConfig.class})
public class AppConfig {

}
