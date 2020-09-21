package com.example.employmentapplication.data;

import android.content.Context;

import androidx.room.Room;

import com.example.employmentapplication.database.EmployeeDatabase;
import com.example.employmentapplication.util.Constants;




public class DatabaseClient {


    private Context context;
    private static DatabaseClient instance;

    private EmployeeDatabase employesDatabase;

    private DatabaseClient(Context conext)
    {
        this.context =conext;
        employesDatabase = Room.databaseBuilder(context,EmployeeDatabase.class, Constants.Database_Name).build();



    }

    public static synchronized DatabaseClient getInstance(Context context){
        if(instance ==null)
        { instance = new DatabaseClient(context);}
        return instance;
    }

    public EmployeeDatabase getDatabaseInstance()
    {
        return employesDatabase;

    }


















}
