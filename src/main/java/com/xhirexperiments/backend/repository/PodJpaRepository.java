package com.xhirexperiments.backend.repository;

import com.xhirexperiments.backend.model.Pod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//add annotation
@Repository
public interface PodJpaRepository extends JpaRepository<Pod, Long> {

    //to create a search method, and param for the search method
    List<Pod> findByPodName(String podName);


}
