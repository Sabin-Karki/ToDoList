package com.example.secondStarter;

import java.util.Date;

public class ToDoClass {
    private static int nextId = 1;

    private int id;
    private String title;
    private String desc;
    private Date date;

    public ToDoClass(String title, String desc) {
        this.id = nextId++;
        this.title = title;
        this.desc = desc;
        this.date=new Date();
    }

    public Date getDate() {
        return date;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHumanDate(){
        Date now=new Date();
       long endDate= now.getTime();
        long startDate=date.getTime();

        long diff=endDate-startDate;   //millisecond;
       diff=diff/1000;

       if(diff==0){
           return "just now";

       }
        if(diff<=60){
            return diff+" sec ago";
        }else{
            int min=(int) diff/60;
            return min +" min ago";
        }

    }
    @Override
    public String toString() {
        return "ToDoClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}