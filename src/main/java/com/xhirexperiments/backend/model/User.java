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

public void setId(long id){
    this.id=id;
}

public void setFirstName(String firstname){
    this.firstname=firstname;
}

public void setLastName(String lastname){
    this.lastname=lastname;
}

public void setEmail(String email){
    this.email=email;
}

public void setRole(String role){
    this.role=role;
}

 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
