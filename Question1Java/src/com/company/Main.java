package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
    int employee_id;
    String employee_name;
    int salary;
    double IT;

    Employee(int emp_id, String name, int salary){
        employee_id = emp_id;
        employee_name = name;
        this.salary = salary;
    }

    public void calculateTax(){
        if(salary > 50000 && salary <= 60000){
            IT = 0.1 * salary;
        } else if(salary > 60000 && salary <= 150000){
            IT = 0.2 * salary;
        } else if(salary > 150000){
            IT = 0.3 * salary;
        }
    }

    public String toString(){
        return "Employee id: "+ employee_id + ", Employee name: "+ employee_name +", Salary: "+ salary + ", Income Tax: "+ IT;
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Employee> list= new ArrayList<>();
        int N, emp_id, salary;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of employees: ");
        N = sc.nextInt();
        System.out.println("Enter the employee id, name and salary of " + N +" employees: ");

        for(int i=0;i<N;i++){
            emp_id = sc.nextInt();
            name = sc.next();
            salary = sc.nextInt();
            list.add(new Employee(emp_id, name, salary));
        }

        for(Employee e: list){
            e.calculateTax();
            System.out.println(e);
        }
    }
}
