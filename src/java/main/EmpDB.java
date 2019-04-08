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
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public static int save(Employee e){
        int status = 0;
        try{
            Connection con = getConnection();
            PreparedStatement sts = con.prepareStatement("INSERT INTO emp (name,email,country,position,salary) VALUES(?,?,?,?,?)");
            sts.setString(1,e.getName());
            sts.setString(2,e.getEmail());
            sts.setString(3,e.getCountry());
            sts.setString(4,e.getPosition());
            sts.setInt(5,e.getSalary());
            status = sts.executeUpdate();
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
            
        return status;
    }
    public static Employee getEmployee(int id){
        Employee e = new Employee();
        try{
            Connection con = getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM emp WHERE id=?");
            st.setInt(1, id);            
            ResultSet re = st.executeQuery();
            if(re.next()){
                e.setName(re.getString("name"));
                e.setEmail(re.getString("email"));
                e.setId(re.getShort("id"));
                e.setCountry(re.getString("country"));
                e.setPosition(re.getString("position"));
                e.setSalary(re.getInt("salary"));
            }
            
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return e;
    }
    public static int update(Employee e){
        int status = 0;
        try{
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE emp SET name=?,email=?,position=?,salary=?,country=? WHERE id=?");
            ps.setString(1,e.getName());
            ps.setString(2,e.getEmail());
            ps.setString(3,e.getPosition());
            ps.setInt(4,e.getSalary());
            ps.setString(5,e.getCountry());
            ps.setInt(6,e.getId());
            
            status = ps.executeUpdate();
            con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return status;
    }
    public static int delete(int id){
        int status = 0;
        
        try{
          Connection con = getConnection();
          PreparedStatement st = con.prepareStatement("DELETE FROM emp WHERE id=?");
          st.setInt(1,id);
          
          status = st.executeUpdate();
          con.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return status;
    }
    
    
}
