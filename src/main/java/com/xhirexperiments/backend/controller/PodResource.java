package com.xhirexperiments.backend.controller;

import com.xhirexperiments.backend.model.Pod;
import com.xhirexperiments.backend.service.PodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PodResource {

    //--- FIELDS ---
    @Autowired
    private PodService podService;

    // --- REQUEST METHODS ---

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

    //EDIT/UPDATE a Pod
    // PUT
    @PutMapping("pods/{podName}/{id}")
    public ResponseEntity<Pod> updatePod(
            @PathVariable String podName, @PathVariable long id, @RequestBody Pod pod  ){

        Pod podUpdated = podService.save(pod);
        return new ResponseEntity<Pod>(pod, HttpStatus.OK);
    }

    // CREATE a new Pod
    // POST
    @PostMapping("pods/{podName}/pods")
    public ResponseEntity<Void> updatePod(
            @PathVariable String podName, @RequestBody Pod pod  ){

        Pod createdPod = podService.save(pod);

        //Location - is response header
        //Get current resource url
        // {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdPod.getId()).toUri();


        return ResponseEntity.created(uri).build();
    }




}
