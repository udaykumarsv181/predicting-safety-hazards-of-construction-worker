/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBase.DBQuery;
import Logic.MailSend;
import Logic.MyQr;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;
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
public class add_employee extends HttpServlet {

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
           String eid=request.getParameter("eid");
            String ename=request.getParameter("ename");
            String email=request.getParameter("email");
            String mobile=request.getParameter("mobile");
            String tag=request.getParameter("tag");
            String dob=request.getParameter("dob");
            String doj=request.getParameter("doj");
            String dept=request.getParameter("dept");
           
            DBQuery db=new DBQuery();
            try {
             db.add_employee(eid, ename, email, mobile, tag, dob, doj, dept);
            
              MyQr mq=new MyQr();
              String info="emp#"+eid+"#"+ename+"#"+email+"#"+mobile+"#"+tag+"#"+dob+"#"+doj+"#"+dept+"#Active";
              mq.gen_qr1(eid+"", info);
              
              if(dept.equalsIgnoreCase("Supervisor"))
              {
               String pass="";
               Random r=new Random();
               for(int i=0;i<4;i++)
               {
               pass+=r.nextInt(10);
               }
               db.add_login(email, pass, dept);
                  MailSend ms=new MailSend();
                  ms.emailUtility(email, "Password", "Your login is is "+email+" and password is "+pass);
              }
              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(add_device.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(add_device.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;
            session.setAttribute("msg", "Employee Added Successfully");
            rd = request.getRequestDispatcher("add_device_details.jsp");
            rd.forward(request, response);
            
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
