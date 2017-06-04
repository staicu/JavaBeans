/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import todo.ejb.TodoDataEJB;
import todo.ejb.TodoDataEJBRemote;
import todo.entities.TodoItem;

/**
 *
 * @author larry
 */
public class AddTodoServlet extends HttpServlet {

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
            out.println("<title> Add Todo Items </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Add Todo Items </h1>");
            out.print("To list all the added task : <a href=\"list\">list</a> <br>");
            out.println("<form method=\"post\">");
            out.println("Task  : <input type=\"text\" name=\"task\">");
            out.println("Due Date  : <input type=\"date\" name=\"date\">");
            out.println("Is Done  : <input type=\"checkbox\" name=\"isdone\">");
            out.println("<input type=\"submit\" value=\"Add ToDo Item\">");
            out.println("</form>");
            String task = request.getParameter("task");
            String dueDateStr = request.getParameter("date");
            String isDoneStr = request.getParameter("isdone");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            boolean isDone = true;

            try {
                Date dueDate = format.parse(dueDateStr);
                //          boolean isDone = Boolean.parseBoolean(isDoneStr);
                if (isDoneStr == null) {
                    isDone = false;
                } else {
                    isDone = true;
                }
                TodoItem item = new TodoItem(task, dueDate, isDone);

                tododata.addTodoItem(item);
                out.printf("<p>Task: %s was added <br> the date: %s <br> the task "
                        + "is Done: %s</p>\n", task, dueDate, isDone);
//                out.print(task);
//                out.println(dueDate);
//                out.println(isDone);
            } catch (ParseException ex) {
                out.printf("<div>Exception %s: %s</div>", ex, ex.getMessage());
            }

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
