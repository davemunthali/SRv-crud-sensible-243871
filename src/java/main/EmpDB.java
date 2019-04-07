package main;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Davie
 */
public class EmpDB {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/srv-crud";
    static final String USER = "root";
    static final String PASS = "";
    
    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(URL,USER,PASS);
        }
        catch(Exception e){
            System.out.println("Couldnt connect => "+e);
        }
        return con;
    }
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<Employee>();
        try{
            Connection con = EmpDB.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM emp");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Employee e = new Employee();
                e.setCountry(rs.getString("country"));
                e.setEmail(rs.getString("email"));
                e.setName(rs.getString("name"));
                e.setId(rs.getInt("id"));
                e.setPosition(rs.getString("position"));
                e.setSalary(rs.getInt("salary"));
                list.add(e);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    
}
