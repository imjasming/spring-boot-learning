package com.xiaoming.springbootlearning.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xiaoming.springbootlearning.common.AuthorityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author Xiaoming.
 * Created on 2019/02/03 22:29.
 * Description :
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        //FastJsonConfig config = new FastJsonConfig();
        //config.set ...
        //converter.setFastJsonConfig(config);
        converters.add(0, converter);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorityInterceptor()).addPathPatterns("/**");
    }
}
