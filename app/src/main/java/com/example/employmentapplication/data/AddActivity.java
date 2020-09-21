package com.example.employmentapplication.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.employmentapplication.R;
import com.example.employmentapplication.database.Employeemode;

public class AddActivity extends AppCompatActivity {



    //EditText usernameeditText,editText2,editText3,editText4;
    String username,age,job,gender;

    EditText usernameeditText ;
    EditText ageeeditText;
    EditText JobeditText;
    EditText gendereditText;


    int id;
    Button saveBtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


    usernameeditText = findViewById(R.id.editText);
    ageeeditText = findViewById(R.id.editText2);
     JobeditText = findViewById(R.id.editText3);
     gendereditText = findViewById(R.id.editText4);
        saveBtn  = findViewById(R.id.button);
    }
    public void Saveemployee(View view) {

      username = usernameeditText.getText().toString().trim();
      age = ageeeditText.getText().toString().trim();
      job = JobeditText.getText().toString().trim();
      gender = gendereditText.getText().toString().trim();

        SaveEmployeeRecordTask  saveEmployeeRecordTask = new SaveEmployeeRecordTask();
        saveEmployeeRecordTask.execute();


    }


    protected class SaveEmployeeRecordTask extends AsyncTask<Void, Void, Employeemode>
    {



        @Override
        protected Employeemode doInBackground(Void... voids) {


            Employeemode employeemodel = new Employeemode(id,username,Integer.parseInt(age),job,gender);
            employeemodel.setId(id);
            employeemodel.setName(username);
            employeemodel.setAge(Integer.parseInt(age));
            employeemodel.setJobtitle(job);
            employeemodel.setGender(gender);
            DatabaseClient.getInstance(getApplicationContext()).getDatabaseInstance().getEmployeeDao().insertEmployeeDetails(employeemodel);
            return null;
        }

        @Override
        protected void onPostExecute(Employeemode aVoid) {
            super.onPostExecute(aVoid);
           finish();
           startActivity(new Intent(getApplicationContext(),MainActivity.class));
            Toast.makeText(getApplicationContext(), "Record Saved", Toast.LENGTH_SHORT).show();
        }
    }














}
