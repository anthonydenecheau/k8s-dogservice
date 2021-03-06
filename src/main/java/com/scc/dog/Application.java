package com.scc.dog;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.scc.dog.utils.UserContextFilter;

import io.jaegertracing.samplers.ConstSampler;
import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;
import io.opentracing.Tracer;

@SpringBootApplication
@EnableResourceServer
public class Application {

	@Bean
	public Tracer jaegerTracer() {
        final Tracer tracer = new Configuration("dog-service")
        	    .withSampler(
        	        new SamplerConfiguration()
        	            .withType(ConstSampler.TYPE)
        	            .withParam(new Float(1.0f)))
        	    .withReporter(
        	        new ReporterConfiguration())
        	    .getTracer();
        return tracer;
	}

    @Bean
    public Filter userContextFilter() {
        UserContextFilter userContextFilter = new UserContextFilter();
        return userContextFilter;
    }
    
    @Bean
    public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext oauth2ClientContext, OAuth2ProtectedResourceDetails details) {
        return new OAuth2RestTemplate(details, oauth2ClientContext);
    }
    
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }

}
