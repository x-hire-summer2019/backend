package com.xhirexperiments.backend.service;

import com.xhirexperiments.backend.model.Pod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PodService {

    // TEMPORARY DB FOR TEST

    // --- FIELDS ---
    private static List<Pod> pods = new ArrayList<>();

    private static int idCounter = 0;

    static {
        pods.add(new Pod(++idCounter,"MyPod", "The Best Pod in the world!!",
                "Ash", "myemail@gmail.com", new Date(), true ));

        pods.add(new Pod(++idCounter,"MyPod2", "The SECOND Best Pod in the world!!",
                "Maybe Ash", "myemail2@gmail.com", new Date(), true ));
    }

    // --- PUBLIC METHODS ---
    public List<Pod> findAll(){
        return pods;
    }

    public Pod deleteById(long id){
        Pod pod = findById(id);
        if(pod == null){
            return null;
        }
        if(pods.remove(pod)){
            return pod;
        }
        return null;
    }

    public Pod findById(long id) {
        for(Pod pod : pods){
            if(pod.getId() == id){
                return pod;
            }
        }
        return null;
    }

}
