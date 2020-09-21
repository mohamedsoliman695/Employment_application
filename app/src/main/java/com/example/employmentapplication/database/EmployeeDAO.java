package com.example.employmentapplication.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.employmentapplication.util.Constants;

import java.util.List;

@Dao
public interface EmployeeDAO {

    @Insert
    Long insertEmployeeDetails (Employeemode employeeModel);

//Show data

    @Query("SELECT *  FROM " + Constants.Table_Name)
    List<Employeemode> getEmployeeDetails();


}
