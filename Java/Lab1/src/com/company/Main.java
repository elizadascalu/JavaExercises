package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String languages[]={"C", "C++", "C#", "Go", "JavaScript", "Perl", "PHP", "Python", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.format("n = %d\n", n);
        n = n * 3;
        String binary="10101";
        int from_binary=Integer.parseInt(binary,2);
        n = n + from_binary;

        String hexa="FF";
        int from_hexa=Integer.parseInt(binary,16);
        n = n + from_hexa;
        n *= 6;

        int digits_sum;
        if(n%9==0)
            digits_sum=9;
        else
            digits_sum=n%9;

        System.out.format("n = %d\n",digits_sum);
        System.out.print("Willy-nilly, this semester I will learn " + languages[digits_sum]);
    }
}