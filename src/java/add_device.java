/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBase.DBQuery;
import Logic.MyQr;
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
public class add_device extends HttpServlet {

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
            String ename=request.getParameter("ename");
            String description=request.getParameter("description");
            String tag=request.getParameter("tag");
            String manufacturer=request.getParameter("manufacturer");
            String vendor=request.getParameter("vendor");
            String date_of_manufacturing=request.getParameter("date_of_manufacturing");
            String date_of_introduction=request.getParameter("date_of_introduction");
            String date_of_expiry=request.getParameter("date_of_expiry");
            DBQuery db=new DBQuery();
            try {
              int eid=  db.add_device(ename, description, tag, manufacturer, vendor, date_of_manufacturing, date_of_introduction, date_of_expiry, "Active");
            
              MyQr mq=new MyQr();
              String info=eid+"#"+ename+"#"+description+"#"+tag+"#"+manufacturer+"#"+vendor+"#"+date_of_manufacturing+"#"+date_of_introduction+"#"+date_of_expiry+"#Active";
              mq.gen_qr1(eid+"", info);
              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(add_device.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(add_device.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;
            session.setAttribute("msg", "Device Added Successfully");
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
