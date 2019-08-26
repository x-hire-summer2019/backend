package com.xhirexperiments.backend.controller;

import com.xhirexperiments.backend.model.Pod;
import com.xhirexperiments.backend.service.PodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PodResource {

    //--- FIELDS ---
    @Autowired
    private PodService podService;

    // --- METHODS ---

    // GET
    @GetMapping("/pods/{podName}")
    public List<Pod> getPod(@PathVariable String podName){
        return podService.findAll();
    }

    @GetMapping("/pods/{podName}/{id}")
    public Pod getPodById(@PathVariable String podName, @PathVariable long id){
        return podService.findById(id);
    }



    //DELETE - response entity returns a specific status of the content back
    @DeleteMapping("/pods/{podName}/{id}")
    public ResponseEntity<Void> deletePod(@PathVariable String podName, @PathVariable long id ){
        Pod pod = podService.deleteById(id);
        if(pod != null){
            return ResponseEntity.noContent().build(); // returning a status of no content if we can delete it successfully, otherwise its returning response entity
        }
        return ResponseEntity.notFound().build(); // returning not found status
    }


}
