package com.scc.dog.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scc.dog.model.Dog;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class DogController {
   
    @RequestMapping(value="/v1/dogs/{id}",method = RequestMethod.GET)
    public Dog getDogById( @PathVariable("id") int id) {
        return new Dog()
        	.withId(id)
        	.withNom("SNOOPY")
        ;
    }  
 
}
