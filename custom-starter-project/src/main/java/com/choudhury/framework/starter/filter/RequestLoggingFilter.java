package com.choudhury.framework.starter.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class RequestLoggingFilter implements Filter {

  private Logger logger = LoggerFactory.getLogger(RequestLoggingFilter.class);
  private RequestLoggerFilterProperties requestLoggerFilterProperties;

  public RequestLoggingFilter(RequestLoggerFilterProperties requestLoggerFilterProperties) {
    this.requestLoggerFilterProperties = requestLoggerFilterProperties;
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;
    String correlationID = req.getHeader(requestLoggerFilterProperties.getRequestIdHeaderName());
    logger.info("Logging Request  {} : {}", req.getMethod(), req.getRequestURI());
    MDC.put(requestLoggerFilterProperties.getMdcContextName(), Objects.toString(correlationID, UUID.randomUUID().toString()));
    filterChain.doFilter(servletRequest, servletResponse);
    logger.info("Logging Response :{}", res.getContentType());
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void destroy() {

  }
}
