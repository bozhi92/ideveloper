package com.hubbleadvance.utils.ideveloper.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.hubbleadvance.utils.ideveloper.common.filter.LoginFilter;
import com.hubbleadvance.utils.ideveloper.common.interceptor.PermissionInterceptor;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private PermissionInterceptor permissionInterceptor;
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
    
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilterRegistration() {
      FilterRegistrationBean<LoginFilter> registration = new FilterRegistrationBean<LoginFilter>();
      registration.setFilter(new LoginFilter());
      registration.addUrlPatterns("/*");
      registration.setName("loginFilter");
      registration.setOrder(1);
      return registration;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
        .addInterceptor(permissionInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/login","/error","/static/**")
        .order(1);
    }

}
