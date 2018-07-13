package com.scc.dog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scc.dog.model.Dog;
import com.scc.dog.model.Owner;

import io.jaegertracing.SpanContext;
import io.opentracing.Scope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DogService {

    private static final Logger logger = LoggerFactory.getLogger(DogService.class);
    
    @Autowired
    private io.opentracing.Tracer tracer;
    
    public Dog getDogById(int id){
        
        logger.debug("In the dogService.getDogById() call, id: {}", id);
        
        Dog _dog = null;
        
        try (Scope scope = tracer.buildSpan("DogService.getDogById").startActive(true)) {
            scope.span().setTag("jaeger-debug-id", getSpanId());

            _dog = new Dog()
                    .withId(id)
                    .withName("SNOOPY")
                    .withOwner(retrieveOwner(id))
             ;

        }finally{
        }
    
        return _dog;
    }
    
    private Owner retrieveOwner(int dogId) {
        
        Owner _owner = null;
        
        try (Scope scope = tracer.buildSpan("DogService.retrieveOwner").startActive(true)) {
            scope.span().setTag("jaeger-debug-id", getSpanId());
        
            _owner = new Owner()
                    .withId(1)
                    .withName("CHARLIE BROWN")
            ;
            
        }finally {
        }
        
        return _owner;
        
    }
    
    private String getSpanId() {
        
        SpanContext c = (SpanContext) tracer.activeSpan().context();
        return Long.toString(c.getSpanId());
        
    }
}
