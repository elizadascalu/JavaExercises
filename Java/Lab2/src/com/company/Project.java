package com.company;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Project {
    protected String name;
    protected LocalDate deadline;
    protected int available;
    protected Student lucky;

    public boolean isAvailable(){ //check if the project was chosen
        if(available==1)return true;
        return false;
    }
    //setters
    public void setStudent(Student s){
        lucky = s;
    }
    public void setName(String newName){
        this.name=newName;
    }
    public void setDeadline(LocalDate newDate){
        this.deadline=newDate;
    }
    public void setAvailable(int b){
        available=b;
    }

    //getters
    public Student getStudent(){ //returns the student that chose the project
        return lucky;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, deadline);
    }

}