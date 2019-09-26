package com.xhirexperiments.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Pod {

    // -- FIELDS --
    @Id
    @GeneratedValue
    private Long id;  //use wrapper Long class not long

    private String podName;
    private String podType;
    private String description;
    private String organizer;
    private String organizerEmail;
    private Date created;
    private boolean status;


    // -- CONSTRUCTORS --

    // - default constructor for @RequestBody
    protected Pod(){

    }


    public Pod(long id, String podName, String podType, String description, String organizer, String organizerEmail, Date created, boolean status) {
        this.id = id;
        this.podName = podName;
        this.podType = podType;
        this.description = description;
        this.organizer = organizer;
        this.organizerEmail = organizerEmail;
        this.created = created;
        this.status = status;
    }

    // -- PUBLIC METHODS --
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    //=== podType===
    public String getPodType() {
        return podType;
    }

    public void setPodType(String podType) {
        this.podType = podType;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getOrganizerEmail() {
        return organizerEmail;
    }

    public void setOrganizerEmail(String organizerEmail) {
        this.organizerEmail = organizerEmail;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pod)) return false;

        Pod pod = (Pod) o;

        return id == pod.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
