package com.company;

import java.time.LocalDate;

public class Essay extends Project {
    private Topic topic;

    //constructor
    Essay(String essayName, LocalDate deadLine, Topic topic){
        setName(essayName);
        setDeadline(deadLine);
        this.topic =topic;
        setAvailable(1);
    }

    public Topic getTopic() {
        return topic;
    }
    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Essay{" +
                "topic=" + topic + ", " + "name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}