package com.scc.dog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scc.dog.model.Dog;

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
            String owner = retrieveOwner(id);
            _dog = new Dog()
                    .withId(id)
                    .withNom("SNOOPY")
             ;

        }finally{
        }
    
        return _dog;
    }
    
    private String retrieveOwner(int dogId) {
        
        try (Scope scope = tracer.buildSpan("DogService.retrieveOwner").startActive(true)) {
            scope.span().setTag("work", "retrieve");
            
            scope.span().setTag("work", "format");
            
        }finally {
        }
        
        return null;
        
    }
}
