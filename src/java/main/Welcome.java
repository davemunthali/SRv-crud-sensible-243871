/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Davie
 */
public class Welcome extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        EmpDB db = new EmpDB();
        List<Employee> list = new ArrayList<Employee>();
        list = EmpDB.getEmployees();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Emp list</title>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class='navbar navbar-default'><div class='container-fluid'><div class='navbar-header'><a class='navbar-brand' href='#'>EmployeeRecords</a></div><ul class='nav navbar-nav'><li class='active'><a href='#'>Home</a></li><li><a href='#'>New</a></li><li><a href='#'>Edit</a></ul></div></nav>");
            out.println("<div class='container'><div class='row'><div class='col-lg-12'>");
            out.println("<hr><h4>Our employees</h4>");
            out.println("<table class='table'>");
            out.println("<tr><th>id</th><th>Name</th><th>email</th><th>position</th><th>Salary</th><th>Country</th><th></td></tr>");
            for(Employee e : list){
                out.println("<tr>");
                    out.println("<td>"+e.getId()+"</td>");
                    out.println("<td>"+e.getName()+"</td>");
                    out.println("<td>"+e.getEmail()+"</td>");
                    out.println("<td>"+e.getPosition()+"</td>");
                    out.println("<td>"+e.getSalary()+"</td>");
                    out.println("<td>"+e.getCountry()+"</td>");
                    out.println("<td><a heref=''>edit</a> | <a heref=''>delete</a></td>");
                out.println("</tr>");
            }
            out.println("</div></div></div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
