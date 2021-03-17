package com.company;

import java.util.*;
import java.lang.*;

public class MaxMatch
{
    private int projectNumber;
    private int studentsNumber;
    private int maxNumberOfPairs;
    private Boolean[][] bpGraph; //bipartite graph
    private Problem problem; //current problem
    private List<Project> projects;
    private Integer[] students; //students[i] = project

    MaxMatch(Problem p){
        //declarations
        problem = p;
        maxNumberOfPairs = 0;
        Integer[] students = new Integer[100];
        List<Project> proj_list = new ArrayList<>();
        Boolean[][] bpGraph = new Boolean[100][100];

        //add all projects in one list
        proj_list.addAll(p.getProjects());
        this.projects = proj_list;
        this.students=students;

        //transform the problem into a bipartit graph
        studentsNumber=p.getStudents().size();
        projectNumber =proj_list.size();
        for(int i=0;i< 100;i++) {
            for (int j = 0; j < 100; j++)
                bpGraph[i][j] = false;

        }
        int i=0;
        for(Student stud:p.getStudents()){
            for(Project proj:stud.getListPreferences()){
                bpGraph[i][proj_list.indexOf(proj)] = true;
            }
            i++;
        }
        this.bpGraph = bpGraph;
    }


    // A DFS based recursive function that
    // returns true if a g for
    // vertex u is possible
    //

    /**
     * @param u - student index
     * @param visited - visited projects
     * @param matchR - match options are saved in this vector
     */
    private boolean bpm(int u, boolean visited[], int matchR[])
    {
        //goes throw every projects
        for (int v = 0; v < studentsNumber; v++)
        {

            // if the student doesn't have any projects assigned and if the current project is not taken
            if (bpGraph[u][v] && !visited[v])
            {
                // check the project as visited
                visited[v] = true;
                // if project v wasn't taken or there is a better alternative
                if (matchR[v] < 0 || bpm(matchR[v], visited, matchR))
                {
                    updateList(u,v);
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }


    public void updateList(int u,int v){
        students[u]=v;
    }

    /**
     * returns the maximum number of pairs that can be made between students and projects
     */
    public int maxBPM()
    {
        // array with student = taken project
        int matchR[] = new int[studentsNumber];

        // init the projects as free
        for(int i = 0; i < studentsNumber; ++i)
            matchR[i] = -1;

        // count assigned projects
        int result = 0;
        for (int u = 0; u < projectNumber; u++)
        {
            //mark peojects as not taken
            boolean seen[] =new boolean[studentsNumber] ;
            for(int i = 0; i < studentsNumber; ++i)
                seen[i] = false;

            // verify if a strundt u cand take the specific project
            if (bpm(u, seen, matchR))
                result++;
        }
        this.maxNumberOfPairs = result;
        return result;
    }

    /**
     * Returneaza studentul de la pozitia 'u'
     *
     * @param set - students list
     * @param u - index
     * @return - student
     */
    private Student getStudentAt(Set<Student> set, int u){
        int i=0;
        for(Student stud:set){
            if(i==u)return stud;
            i++;
        }
        return null;
    }

    public void Print(){
        for(int i=0;i<maxNumberOfPairs;i++){
            System.out.println(getStudentAt(problem.getStudents(),i).getName() +" has project " + projects.get(students[i]).getName() + ".");
        }
    }

}