/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Davie
 */
public class Employee {
    int id;
    String name;
    String email;
    String password;
    String country;
    int salary;
    // contructor
    public Employee(String name,String email,String password,String country,int salary){
        this.name = name;
        this.email = email;
        this.country = country;
        this.salary = salary;
    }
    // getters
    public int getId(){
        return this.id;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getCountry(){
        return this.country;
    }
    public int getSalary(){
        return this.salary;
    }
    
    // setters
    public void setPassword(String password){
        this.password = password;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setName(String name){
        this.name = name;        
    }
    public void setId(int id){
        this.id = id;
    }
}
