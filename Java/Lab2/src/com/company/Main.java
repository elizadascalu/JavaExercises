package com.company;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) { //@param args - argumente primite la rulare.
        //Students init
        Student student1 = new Student("Student1", 1);
        Student student2 = new Student("Student2", 2);
        Student student3 = new Student("Student3", 3);
        Student student4 = new Student("Student4", 1);

        System.out.println(student1.getName() + ", year of study: " + student1.getYear());

        //Projects init
        Application app1 = new Application("App1", LocalDate.of(2021, Month.JUNE, 10), Language.PYTHON);
        Application app2 = new Application("App2", LocalDate.of(2021, Month.JANUARY, 20), Language.JAVA);
        Application app3 = new Application("App3", LocalDate.of(2021, Month.MARCH, 15), Language.JAVA);
        Essay e1 = new Essay("E1", LocalDate.of(2021, Month.JUNE, 10), Topic.ARTIFICIAL_INTELLIGENCE);
        Essay e2 = new Essay("E2", LocalDate.of(2021, Month.MARCH, 21), Topic.ARTIFICIAL_INTELLIGENCE);

        //Setare preferinte
        student1.setPreferences(app1,app2,app3);
        student2.setPreferences(app1,e1);
        student3.setPreferences(app2,app3,e1);
        student4.setPreferences(app3,e2);

        //Initializare problema
        Problem problem = new Problem();
        problem.setStudents(student1,student2,student3,student4);
        problem.setStudents(student1);
        System.out.println(problem.showProjects());
        System.out.println(problem);

        //Matching maximal
        MaxMatch max = new MaxMatch(problem);
        System.out.println("Max number:" + max.maxBPM());
        max.Print();
    }
}