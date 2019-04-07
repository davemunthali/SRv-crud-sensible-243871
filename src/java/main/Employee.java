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
    String position;
    String country;
    int salary;
    // contructor
    
    // getters
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getPosition(){
        return this.position;
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
    public void setPosition(String position){
        this.position = position;
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
    public void setSalary(int salary){
        this.salary = salary;
    }
}
