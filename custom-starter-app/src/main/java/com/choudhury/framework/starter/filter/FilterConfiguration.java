package com.choudhury.framework.starter.filter;

import com.choudhury.framework.starter.filter.RequestLoggerFilterProperties;
import com.choudhury.framework.starter.filter.RequestLoggingFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConditionalOnClass(Greeter.class)
@EnableConfigurationProperties(RequestLoggerFilterProperties.class)
public class FilterConfiguration {

  private RequestLoggerFilterProperties greeterProperties;

  @Autowired
  public FilterConfiguration(RequestLoggerFilterProperties greeterProperties) {
    this.greeterProperties = greeterProperties;
  }

  @Bean
  public RequestLoggingFilter requestLoggingFilter(RequestLoggerFilterProperties requestLoggerFilterProperties) {
    return new RequestLoggingFilter(requestLoggerFilterProperties);
  }

}
