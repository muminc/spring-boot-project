package com.choudhury.framework.starter.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.choudhury.request.filter")
@Data
public class RequestLoggerFilterProperties {
  private String requestIdHeaderName="X-Correlation-ID";
  private String mdcContextName="X-Correlation-ID";
}
