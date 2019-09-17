package com.xhirexperiments.backend.service;


import com.xhirexperiments.backend.model.Pod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PodJpaResource {

    @Autowired
    private PodService podService;

    @GetMapping("/jpa/users/{podName]/pods")
    public List<Pod> getAllPods(@PathVariable String username){
        return podService.findAll();
    }

    @GetMapping("/jpa/users/{podName}/pods/{id}")
    public Pod getPod(@PathVariable String username, @PathVariable Long id){
        return podService.findById(id);
    }


}
