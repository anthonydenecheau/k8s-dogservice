package com.scc.dog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scc.dog.model.Dog;
import com.scc.dog.services.DogService;

import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DogController {

    @Autowired
    private DogService dogService;
    
    @Autowired
    private io.opentracing.Tracer tracer;

    @RequestMapping(value="/v1/dogs/{id}",method = RequestMethod.GET)
    public Dog getDogById( @PathVariable("id") int id) {
        
        Optional.ofNullable(tracer.activeSpan()).ifPresent(as -> as.setBaggageItem("action", "search dog by id"));
        return dogService.getDogById(id);

    }  

}
