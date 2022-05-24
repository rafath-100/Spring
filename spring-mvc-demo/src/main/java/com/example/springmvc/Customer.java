package com.example.springmvc;


import com.example.validation.CourseCode;

import javax.validation.constraints.*;

public class Customer {
    @NotNull(message = "is required")
    @Size(min=1, message="is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min=1, message="is required")
    private  String lastName;

    @Min(value=0, message="must be >=0")
    @Max(value=10, message="must be <=10")
    private int freePasses;

    @CourseCode(value="MRA", message="must start with MRA")
    @NotNull(message = "is required")
    private String courseCode;

    @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 chars/digits")
    @NotNull(message = "is required")
    private String postalCode;


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getFreePasses(){
        return freePasses;
    }

    public void setFreePasses(int freePasses){
        this.freePasses = freePasses;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCourseCode(){
        return courseCode;
    }

    public void setCourseCode(String courseCode){
        this.courseCode = courseCode;
    }
}
