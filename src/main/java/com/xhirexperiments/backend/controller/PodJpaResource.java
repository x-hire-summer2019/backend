package com.xhirexperiments.backend.controller;


import com.xhirexperiments.backend.model.Pod;
import com.xhirexperiments.backend.repository.PodJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PodJpaResource {

    @Autowired
    private PodJpaRepository podJpaRepository;


    //GetAllPods() - /api/all-pods
    //SetSinglePod(Id


    @GetMapping("/api/all-pods")
    public List<Pod> getAllPods(){
        //search method made in repository interface
        return podJpaRepository.findAll();

    }



    @GetMapping("/api/pods/{podName}")
    public List<Pod> getPodByName(@PathVariable String podName){
        //search method made in repository interface
        return podJpaRepository.findByPodName(podName);

    }

    @GetMapping("/api/pods/{podType}")
    public List<Pod> getPodByType(@PathVariable String podType){
        //search method made in repository interface
        return podJpaRepository.findByPodType(podType);

    }


    @GetMapping("/api/single-pod/{id}")
    public Pod getPodById( @PathVariable long id){
        return podJpaRepository.getOne(id);

    }

    @GetMapping("/api/pods/{podName}/pods/{id}")
    public Pod getPod(@PathVariable String podName, @PathVariable long id){
        return podJpaRepository.findById(id).get();

    }

    //DELETE
    @DeleteMapping("/api/pods/{podName}/{id}")
    public ResponseEntity<Void> deletePod(@PathVariable String podName, @PathVariable long id ){

        podJpaRepository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    //EDIT/UPDATE a Pod
    // PUT
    @PutMapping("/api/pods/{podName}/{id}")
    public ResponseEntity<Pod> updatePod(
            @PathVariable String podName, @PathVariable long id, @RequestBody Pod pod  ){

        //Pod podUpdated = podService.save(pod);
        Pod podUpdated = podJpaRepository.save(pod);

        return new ResponseEntity<Pod>(pod, HttpStatus.OK);
    }

    // CREATE a new Pod
    // POST
    @PostMapping("/api/pods/{podName}/pods")
    public ResponseEntity<Void> createPod(
            @PathVariable String podName, @RequestBody Pod pod  ){

        //Pod createdPod = podService.save(pod);
        pod.setPodName(podName);
        Pod createdPod = podJpaRepository.save(pod);

        //Location - is response header
        //Get current resource url
        // {id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdPod.getId()).toUri();


        return ResponseEntity.created(uri).build();
    }


}
