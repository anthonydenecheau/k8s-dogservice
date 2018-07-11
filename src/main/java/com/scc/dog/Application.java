package com.scc.dog;

import java.util.regex.Pattern;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.scc.dog.utils.UserContextFilter;

import io.opentracing.Tracer;
import io.opentracing.contrib.spring.web.autoconfig.WebTracingConfiguration;

@SpringBootApplication
@EnableResourceServer
public class Application {

    @Autowired
    public Tracer tracer;

	@Bean
    public Filter userContextFilter() {
        UserContextFilter userContextFilter = new UserContextFilter();
        return userContextFilter;
    }
    
    @Bean
    public WebTracingConfiguration webTracingConfiguration() {
        return WebTracingConfiguration.builder()
                .withSkipPattern(Pattern.compile("/health"))
                .build();
    }
    
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext,
                                                 OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oauth2ClientContext);
    }
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
