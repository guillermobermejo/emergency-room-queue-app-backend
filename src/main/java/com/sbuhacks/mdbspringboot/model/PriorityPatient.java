package com.sbuhacks.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("prioritypatients")
public class PriorityPatient {

    @Id
    private String id;

    private String name;
    private int priority;

    public PriorityPatient(String id, String name, int priority) {
            super();
            this.id = id;
            this.name = name;
            this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}
