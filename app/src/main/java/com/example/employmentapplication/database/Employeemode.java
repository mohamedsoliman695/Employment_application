package com.example.employmentapplication.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.employmentapplication.util.Constants;
@Entity(tableName = Constants.Table_Name)

public class Employeemode {




    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private int age;
    private String jobtitle;
    private String gender;


    public Employeemode( int id,String name,int age, String jobtitle, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.jobtitle = jobtitle;
        this.gender = gender;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return (age);
    }

    public void setAge(int age) {
        this.age = (age);
    }
}
