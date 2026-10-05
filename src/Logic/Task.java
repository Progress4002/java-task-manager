package Logic;

import enums.Priority;
import enums.Status;

public class Task {
    private int id;
    private String title;
    private String description;
    private String dueDate;
    private Priority priority;
    private Status status;

    public Task(int id, String title, String description, String dueDate, Priority priority){
        this.id= id;
        this.title=title;
        this.description=description;
        this.dueDate=dueDate;
        this.priority=priority;


    }
    /*public void setId(int id){
        this.id=id;
    }*/
    public int getId(){
        return id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return title;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getDescription(){
        return description;
    }
    public void setDueDate(String dueDate){
        this.dueDate=dueDate;
    }
    public String getDueDate(){
        return dueDate;
    }
    public void setPriority(Priority priority){
        this.priority=priority;
    }
    public Priority getPriority(){
        return priority;
    }
    public void setStatus(Status status){
        this.status= status;
    }
    public Status getStatus(){
        return status;
    }
}
