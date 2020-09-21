package com.example.employmentapplication.data;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.employmentapplication.activity.SplashActivity;
import com.example.employmentapplication.adapter.ListAdapter;
import com.example.employmentapplication.database.EmployeeDatabase;
import com.example.employmentapplication.database.Employeemode;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Button;

import com.example.employmentapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.internal.operators.flowable.FlowableAnySingle;

public class MainActivity extends AppCompatActivity {

    ListAdapter listAdapter;
    RecyclerView listRecycelerView;
    LinearLayoutManager linearLayoutManager;
    List<Employeemode> employeemodels;
    List<Employeemode> employeemodelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Button fab = findViewById(R.id.Fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //  Employment activity

                startActivity(new Intent(MainActivity.this, AddActivity.class));


                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
            }
        });

        //dummy data
        employeemodelList = new ArrayList<>();
        // Employeemodel employeemodel = new Employeemodel();

        //employeemodel.setName("Mohamed");
        //employeemodel.setAge(Integer.parseInt("24"));
        // employeemodel.setJobtitle("Android developer");
        //employeemodel.setGender("male");


        //    employeemodelList.add(employeemodel);
        //   employeemodelList.add(employeemodel);
        //  employeemodelList.add(employeemodel);
        //  employeemodelList.add(employeemodel);


//saved imployment list


        //listRecycelerView  = findViewById(R.id.list_phrases);
        //  final RecyclerView listRecycelerView = findViewById(R.id.list_phrases);
        //final listRecycelerView adapter = new listRecycelerView();

        //Log.v(TAG, "index=" );

        //final EmployeeDatabase postsDatabase = EmployeeDatabase.getInstance(this);
        // listAdapter = new ListAdapter(MainActivity.this,employeemodelList);
        // listRecycelerView.setAdapter(listAdapter);
        //calling function /Method in create


        //  getEmployeeeDetails();
        new GetEmployeeDataTask().execute();

        listRecycelerView = findViewById(R.id.list_phrases);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        listAdapter = new ListAdapter(MainActivity.this, employeemodelList);
        listRecycelerView.setAdapter(listAdapter);
        listRecycelerView.setLayoutManager(linearLayoutManager);
        listRecycelerView.setHasFixedSize(true);
        Button startBtn=findViewById(R.id.Fab);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }


    //Executes only one thread
    ExecutorService es = Executors.newSingleThreadExecutor();

    //Internally manages thread pool of 2 threads
    ExecutorService es2 = Executors.newFixedThreadPool(2);

    //Internally manages thread pool of 10 threads to run scheduled tasks
    ExecutorService es4 = Executors.newScheduledThreadPool(10);


    class GetEmployeeDataTask extends AsyncTask<Void, Void, List<Employeemode>> {
        //on post execute
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected List<Employeemode> doInBackground(Void... voids) {
            employeemodels = DatabaseClient.getInstance(getApplicationContext()).getDatabaseInstance().getEmployeeDao().getEmployeeDetails();

            for (int i = 0; i < employeemodels.size(); i++) {
                employeemodelList.add(employeemodels.get(i));

            }

            return employeemodels;
        }

        @Override
        protected void onPostExecute(List<Employeemode> employeemodes) {
            listAdapter.notifyDataSetChanged();

        }

        //Demo task
        Runnable runnableTask = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                    System.out.println("Current time :: ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        //Executor service instance
        ExecutorService executor = Executors.newFixedThreadPool(10);

        //1. execute task using execute() method
        // executor.execute(runnableTask);

        //2. execute task using submit() method
        Future<String> result = executor.submit(runnableTask, "DONE");

        // while(result.isDone() == false)
        {
            try {
                System.out.println("The method return value : " + result.get());
                //
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                GetEmployeeDataTask GetEmployeeDataTask = new GetEmployeeDataTask();
                GetEmployeeDataTask.execute();
            }

            //Sleep for 1 second
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //Shut down the executor service
        //  executor.shutdownNow();
    }


}


