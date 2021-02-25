package com.sanju.recyclerviewdiffutildemosk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.sanju.recyclerviewdiffutildemosk.model.Animal;
import com.sanju.recyclerviewdiffutildemosk.model.Model;
import com.sanju.recyclerviewdiffutildemosk.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Employee> employeeList = new ArrayList<>();
    RecyclerView recyclerview;
    Button button, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(new Employee("3","Akki"));
                employeeList.add(new Employee("4","Rudra"));
                employeeList.add(new Employee("5","Arun"));
                employeeList.add(new Employee("1","Sanju"));
                employeeList.add(new Employee("2","Nimkki"));
                adapter.updateSimpleList(employeeList);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(new Employee("5","Arun"));
                employeeList.add(new Employee("1","Sanju"));
                employeeList.add(new Employee("6","New3"));
                employeeList.add(new Employee("4","Rudra"));
                employeeList.add(new Employee("2","Nimkki"));
                employeeList.add(new Employee("3","Akki"));
                employeeList.add(new Employee("7","New1"));
                employeeList.add(new Employee("8","New2"));
                adapter. diffUtilChangeData(employeeList);
            }
        });
        prepareList();
        setDataINList();
    }

    public void prepareList(){
        employeeList.add(new Employee("1","Sanju"));
        employeeList.add(new Employee("2","Nimkki"));
        employeeList.add(new Employee("3","Akki"));
        employeeList.add(new Employee("4","Rudra"));
        employeeList.add(new Employee("5","Arun"));

    }

    ImageAdapter adapter;
    public void setDataINList(){
         adapter = new ImageAdapter(this,employeeList);
        recyclerview.setAdapter(adapter);
    }

    List<Model> modelList = new ArrayList<>();
    public void multiViewTypeList(){
        MenuAdapter menuAdapter = new MenuAdapter();
        recyclerview.setAdapter(menuAdapter);

        modelList.add(new Animal("A"));
        modelList.add(new Person("b"));
        modelList.add(new Animal("c"));
        modelList.add(new Person("d"));
        modelList.add(new Animal("e"));

        menuAdapter.submitList(modelList);

    }
}