/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import todo.ejb.TodoDataEJBRemote;
import todo.entities.TodoItem;

/**
 *
 * @author larry
 */
public class TodoListServlet extends HttpServlet {

    @EJB
    TodoDataEJBRemote tododata;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> Todo List</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Todo List </h1>");
            out.print("To add a task : <a href=\"add\">add</a> <br>");
//            TodoItem todoit;
//            tododata.getAllTodoItems();
            out.print("<style> table {border-collapse: collapse;}th, td {border: 1px solid orange; padding: 10px;text-align: left;}</style>");

            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Task</th>");
            out.println("<th>Due Date</th>");
            out.println("<th>Is Done</th>");
            out.println("</tr>");
            for (TodoItem s : tododata.getAllTodoItems()) {
                out.println("<tr>");
                out.printf("<td> %s </td>", s.getId());
                out.printf("<td> %s </td>", s.getTask());
                out.printf("<td> %s </td>", s.getDueDate());
                out.printf("<td> %s </td>", s.isIsDone());
                out.println("</tr>");
//                out.println(s.getId());
//                out.println(s.getTask());
//
//                out.println(s.getDueDate());
//                out.println(s.isIsDone());

            }
            out.println("</table>");
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
