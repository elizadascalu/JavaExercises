package com.company;
import java.util.HashSet;
import java.util.Set;

public class Problem {
    private Set<Student> students=new HashSet<Student>();

    public void setStudents(Student ... args) { //student list assigned to the project
        for (Student arg:args)
            students.add(arg);
    }


    public Set<Student> getStudents() {
        return students;
    }

    public Set<Project> getProjects() {
        Set<Project> projects = new HashSet<Project>();
        for (Student arg : students)
            for(Project proj: arg.getPreferences())
                projects.add(proj);
        return projects; //Returns the project list that the students chosen
    }

    public String showProjects() {
        return "Projects="+getProjects();
    }

    @Override
    public String toString() {
        return "Problem{" +
                "students=" + students +
                '}';
    }
}