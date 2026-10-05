package Application;

import Logic.Task;
import enums.Priority;
import enums.Status;

import java.util.Scanner;

public class Main {
    private static Scanner sc= new Scanner(System.in);
    static Task [] tasks= new Task[10];

    public static Task[] removeElement(Task [] array, int index){
        if(array==null || index<0|| index>= array.length){
            return array;
        }
        Task[] arrayTwo= new Task[array.length-1];
        for(int i=0, k=0; i< array.length; i++){
            if (i== index)
                continue;
            arrayTwo[k++]= array[i];
        }
        return arrayTwo;


    }

    public static void menu(){
        System.out.println("1. Add tasks");
        System.out.println("2. List tasks");
        System.out.println("3. Complete tasks");
        System.out.println("4. Delete tasks");
        System.out.println("5. Exit");
    }
    private static void separator(){
        String symbol="-";
        System.out.println(symbol.repeat(40));
        System.out.print(">");
    }
    public static void main(String[] args){
        int userInput=0;
        int id;
        String taskName;
        String taskDescription;
        String dueDate;
        Priority userPriority;
        int i=0;
        Task task;
        do{
            try{
                Status negative=Status.valueOf("UNFINISHED");
                Status positive= Status.valueOf("COMPLETED");
                menu();
                separator();
                userInput= Integer.parseInt(sc.nextLine());
                if(userInput==1){
                    System.out.print("Task id: ");
                    id= Integer.parseInt(sc.nextLine());
                    System.out.print("task name: ");
                    taskName= sc.nextLine();
                    System.out.print("task description: ");
                    taskDescription= sc.nextLine();
                    System.out.print("Due date: ");
                    dueDate= sc.nextLine();
                    System.out.print("what is your Priority: ");
                    System.out.println("HIGH/MID/LOW");
                    System.out.print(">");
                    String priority=sc.nextLine();
                    priority= priority.toUpperCase();
                    userPriority= Priority.valueOf(priority);
                    task= new Task(id,taskName, taskDescription,dueDate,userPriority);
                    System.out.println("New task? Y/N");
                    String question= sc.nextLine();
                   tasks[i]=task;
                   i++;


                   if(question.equals("Y")){
                       task.setStatus(negative);
                   }else{
                       task.setStatus(positive);
                   }
                }
                if(userInput==2){
                    for( i=0;i<tasks.length;i++){

                        if(tasks[i]==null){
                            break;
                        }else{
                            System.out.println(tasks[i].getId()+": "+tasks[i].getTitle()+"| "+tasks[i].getDescription()+" "
                            +tasks[i].getDueDate()+" "+tasks[i].getPriority()+" "+tasks[i].getStatus());
                        }

                    }
                    System.out.println();

                }
                if(userInput==3){
                        for(i =0;i<tasks.length;i++){
                            if(tasks[i]== null){
                                continue;
                            }
                            if(tasks[i].getStatus()==(negative)){
                                System.out.println(tasks[i].getId()+": "+tasks[i].getTitle()+"| "+tasks[i].getDescription()+" "
                                        +tasks[i].getDueDate()+" "+tasks[i].getPriority());

                            }
                                System.out.print("Please type in your task Id: ");
                                int taskFinisherId= Integer.parseInt(sc.nextLine());
                                if(taskFinisherId==tasks[i].getId()){
                                    System.out.println("Have you completed the task Y/N");
                                    String question=sc.nextLine();
                                    if(question.equals("Y")){
                                        tasks[i].setStatus(positive);
                                    }else{
                                        tasks[i].setStatus(negative);
                                    }
                                }



                        }


                }
                if(userInput==4) {
                    int taskDelete;
                    for (i = 0; i < tasks.length; i++) {
                        if (tasks[i] == null) {
                            break;
                        } else {
                            System.out.println(tasks[i].getId() + ": " + tasks[i].getTitle() + "| " + tasks[i].getDescription() + " "
                                    + tasks[i].getDueDate() + " " + tasks[i].getPriority() + " " + tasks[i].getStatus());
                            System.out.print("type the ID of the task you want to remove: ");
                            taskDelete= Integer.parseInt(sc.nextLine());
                        }

                       tasks= removeElement(tasks, taskDelete-1);
                    }



                }
            }catch(NumberFormatException e){
                System.out.println("Invalid please type a number");
            }
        }while(userInput!=5);

    }
}
