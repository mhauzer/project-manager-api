package com.mhalab.projectmanager.model;

import javax.persistence.*;

// TODO: Change to https://schema.org/ScheduleAction

//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(nullable=false, updatable=false)
    private long id;

    @Column(columnDefinition="text", nullable=false)
    private String description;

    @Column(nullable=false)
    private StatusType status;

    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private StatusType st; // just for testing

    @ManyToOne
    private Person owner;

    public Task() {

    }

    public Task(String description, Person owner) {
        this.description = description;
        this.owner = owner;
        this.status = StatusType.TODO;
    }

    public Task(String description, Person owner, StatusType status) {
        this.description = description;
        this.owner = owner;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public StatusType getSt() {
        return st;
    }

    public void setSt(StatusType st) {
        this.st = st;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", owner=" + owner +
                '}';
    }
}
