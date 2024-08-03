package com.eshopping.bmw.bootstrap.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.eshopping.bmw.framework.entity")
@ComponentScan(basePackages = { "com.eshopping.bmw.framework", "com.eshopping.bmw.core.application" })
@EnableJpaRepositories(basePackages = { "com.eshopping.bmw.framework.repository" })
public class BeanConfiguration {

}
