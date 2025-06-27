/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBase.DBQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author sumit
 */
public class login extends HttpServlet {

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
           try {
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;

            String email = request.getParameter("email");// 
            String password = request.getParameter("password");// 



            DBQuery db = new DBQuery();
            
            String utype = db.loginInfo(email, password);
          
            if (utype.equalsIgnoreCase("admin")) {

                session.setAttribute("login", "Wecome:: " + email);
                session.setAttribute("utype", "admin");
                session.setAttribute("srn", email);
                System.out.println("srn = " + email);

                rd = request.getRequestDispatcher("admin_home.jsp");
                rd.forward(request, response);

            }
            else  if (utype.equalsIgnoreCase("insurance")) {

                session.setAttribute("login", "Wecome:: " + email);
                session.setAttribute("utype", "insurance");
                session.setAttribute("srn", email);
                System.out.println("srn = " + email);

                rd = request.getRequestDispatcher("insurance_home.jsp");
                rd.forward(request, response);

            }
            else if (utype.equalsIgnoreCase("Supervisor")) {
                out.print("ok");
            }
           
            else {

                session.setAttribute("logins", "Sorry: Your Login Failed!!!");
                rd = request.getRequestDispatcher("Login.jsp");
                rd.forward(request, response);

            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {

            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
