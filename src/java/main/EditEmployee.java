/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Davie
 */
public class EditEmployee extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        Employee e = EmpDB.getEmployee(id);
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>New employee</title>");
            out.println("<meta charset='UTF-8'>");
            out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("<link rel='stylesheet' type='text/css' href='css/bootstrap.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<nav class='navbar navbar-default'><div class='container-fluid'><div class='navbar-header'><a class='navbar-brand' href='#'>EmployeeRecords</a></div><ul class='nav navbar-nav'><li><a href='#'>Home</a></li><li class='active'><a href='newemp.html'>New</a></li><li><a href='#'>Page 2</a></li><li><a href='#'>Page 3</a></li></ul></div></nav>");
            out.println("<div class='container'><div class='row'><div class='col-lg-12'>");
            out.println("<hr><h4>New employee</h4>");
            out.println("<form role='form' method='post' action='update'>");
            out.println("<div class='form-group'>");
            out.println("<label for='name'>Name :</label>");
            out.println("<input type='text' class='form-control' value='"+e.getName()+"' name='name'>");
            out.println("</div>");
            out.println("<label for='email'>email :</label>");
            out.println("<input type='text' class='form-control' value='"+e.getEmail()+"' name='email'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='position'>Position :</label>");
            out.println("<input type='text' class='form-control' value='"+e.getPosition()+"' name='position'>");
            out.println("</div>");
            out.println("<div class='form-group'>");
            out.println("<label for='salary'>Salary :</label>"); 
            out.println("<input type='text' class='form-control' value='"+e.getSalary()+"' name='salary'>"); 
            out.println("</div>"); 
            out.println("<div class='form-group'>"); 
            out.println("<label for='country'>Country :</label>");
            out.println("<input type='text' class='form-control' value='"+e.getCountry()+"' name='country'>");
            out.println("</div>");
            out.println("<button type='submit' class='btn btn-default'>Submit</button>");
            out.println("<input type='hidden' name='id' value='"+e.getId()+"'>");
            out.println("</form>");
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
