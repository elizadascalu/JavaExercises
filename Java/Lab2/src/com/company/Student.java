package com.company;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Student {
    private String name;
    private int year_of_study;
    private Set<Project> preferences=new HashSet<Project>();;
    private int available;

    Student(String student_name, int year_of_study) { //constructor
        this.name = student_name;
        this.year_of_study = year_of_study;
        this.available = 1;
    }

    public boolean isAvailable(){ //verify if student chose a project
        if(available==1)return true;
        return false;
    }
    //setters
    public void setAvailable(int b){
        available=b;
    } //set a project
    public void setName(String new_name){
        this.name=new_name;
    }
    public void setYear(int year_of_study) {
        this.year_of_study = year_of_study;
    }

    //getters
    public String getName(){
        return this.name;
    }
    public int getYear(){
        return this.year_of_study;
    }

    //add project preference
    public void addPreference(Project project) {
        preferences.add(project);
    }

    //set project preference
    public void setPreferences(Project ... args) { ;
        for(Project arg:args)
            preferences.add(arg);
    }

    //return preferences
    public Set<Project> getPreferences() {
        return preferences;
    }

    //return preferences as list
    public List<Project> getListPreferences() {
        List<Project> preferences1=new ArrayList<Project>(preferences);
        return preferences1;
    }

     //converts Student class into a String representation
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", year_of_study=" + year_of_study +
                ", preferences=" + preferences +
                '}';
    }

    /* Equals override to be able to compare 2 different instances(or 2 objects) of the Student class
    @param o - any object
    @return - bool.
    */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return year_of_study == student.year_of_study &&
                Objects.equals(name, student.name) &&
                Objects.equals(preferences, student.preferences);
    }

    /**
     * Daca doua obiecte sunt egale conform metodei equals, atunci apelul
     * metodei hashCode pentru fiecare din cele doua obiecte ar trebui sa
     * returneze acelasi intreg.
     *
     * @return - int.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, year_of_study, preferences);
    }
}
