package com.xhirexperiments.backend.model;
public class User {
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

}
public User(long id, String firstname, String lastname,String email, String role){
    this.id=id;
    this.firstname=firstname;
    this.lastname=lastname;
    this.email=email;
    this.role=role;
}

public User(){

}
public long getId(){
    return id;
}

public String getFirstName(){
    return firstname;
}
public String getLastName(){
    return lastname;
}
public String getEmail(){
    return email;
}

public String getRole(){
    return role;
}

}
