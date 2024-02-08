package com.emc.cm.configuration;

import com.emc.cm.filter.ApmApiProxyFilter;
import com.emc.cm.filter.MessagesFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<ApmApiProxyFilter> registrationBean() {
        FilterRegistrationBean<ApmApiProxyFilter> registrationBean = new FilterRegistrationBean<ApmApiProxyFilter>();
        registrationBean.setFilter(new ApmApiProxyFilter());
        registrationBean.addUrlPatterns("/apm/*");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<MessagesFilter> messagesBean() {
        FilterRegistrationBean<MessagesFilter> messagesBean = new FilterRegistrationBean<MessagesFilter>();
        messagesBean.setFilter(new MessagesFilter());
        messagesBean.addUrlPatterns("/messages/*");
        return messagesBean;
    }
}