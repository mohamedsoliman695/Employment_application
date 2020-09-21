package com.example.employmentapplication.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;




    @Database(entities ={Employeemode.class}
            ,version=1,exportSchema = false)
    public abstract class EmployeeDatabase extends RoomDatabase{

        public abstract EmployeeDAO getEmployeeDao();

    }



