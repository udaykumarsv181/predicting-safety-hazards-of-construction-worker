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
public class add_project_plan extends HttpServlet {

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
            DBQuery db=new DBQuery();
            //project info
            String pname=request.getParameter("pname");
            String total_days=request.getParameter("total_days");
            String stdate=request.getParameter("stdate");
            String enddate=request.getParameter("enddate");
            try {
                db.add_Project_details(pname, total_days, stdate, enddate);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(add_project_plan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(add_project_plan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            //Foundation
            String Foundation_days=request.getParameter("Foundation_days");
            String Structural_Lines=request.getParameter("Structural_Lines");
            String Structural_Lines1=request.getParameter("Structural_Lines1");
            String Excavation_for_foundation=request.getParameter("Excavation_for_foundation");
            String Excavation_for_foundation1=request.getParameter("Excavation_for_foundation1");
            String Base_Concreting=request.getParameter("Base_Concreting");
            String Base_Concreting1=request.getParameter("Base_Concreting1");
            String Curing_for_Base_Concrete=request.getParameter("Curing_for_Base_Concrete");
            String Curing_for_Base_Concrete1=request.getParameter("Curing_for_Base_Concrete1");
            try {
                db.add_Foundation(Foundation_days, Structural_Lines, Structural_Lines1, Excavation_for_foundation, Excavation_for_foundation1, Base_Concreting, Base_Concreting1, Curing_for_Base_Concrete, Curing_for_Base_Concrete1);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(add_project_plan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(add_project_plan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
            //Footing
            String footing_days=request.getParameter("footing_days");
            String Placement_of_Footing_Reinforcement=request.getParameter("Placement_of_Footing_Reinforcement");
            String Placement_of_Footing_Reinforcement1=request.getParameter("Placement_of_Footing_Reinforcement1");
            String fConcreting=request.getParameter("fConcreting");
            String fConcreting1=request.getParameter("fConcreting1");
            String Curing_for_Footing=request.getParameter("Curing_for_Footing");
            String Curing_for_Footing1=request.getParameter("Curing_for_Footing1");
            try {
                db.add_Footing(footing_days, Placement_of_Footing_Reinforcement, Placement_of_Footing_Reinforcement1, fConcreting, fConcreting1, Curing_for_Footing, Curing_for_Footing1);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(add_project_plan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(add_project_plan.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            //Construction of Basement (Parking)
            String Construction_of_Basement=request.getParameter("Construction_of_Basement");
            String Coulmn=request.getParameter("Coulmn");
            String Coulmn1=request.getParameter("Coulmn1");
            String reinforcement=request.getParameter("reinforcement");
            String reinforcement1=request.getParameter("reinforcement1");
            String Concreting=request.getParameter("Concreting");
            String Concreting1=request.getParameter("Concreting1");
            String Curing=request.getParameter("Curing");
            String Curing1=request.getParameter("Curing1");
            
            
            
            //ground floor
            String ground_days=request.getParameter("ground_days");
            String gf_Coulmn=request.getParameter("gf_Coulmn");
            String gf_Coulmn1=request.getParameter("gf_Coulmn1");
            String gf_reinforcement=request.getParameter("gf_reinforcement");
            String gf_reinforcement1=request.getParameter("gf_reinforcement1");
            String gf_Concreting=request.getParameter("gf_Concreting");
            String gf_Concreting1=request.getParameter("gf_Concreting1");
            
            
            
            //FIRST FLOOR            
            String first_days=request.getParameter("first_days");
            String ff_Column_reinforcement_Extention=request.getParameter("ff_Column_reinforcement_Extention");
            String ff_Column_reinforcement_Extention1=request.getParameter("ff_Column_reinforcement_Extention1");
            String ff_Concreting=request.getParameter("ff_Concreting");
            String ff_Concreting1=request.getParameter("ff_Concreting1");
            String ff_Curing=request.getParameter("ff_Curing");
            String ff_Curing1=request.getParameter("ff_Curing1");
            String ff_Beam_and_Slab_Reinforcement=request.getParameter("ff_Beam_and_Slab_Reinforcement");
            String ff_Beam_and_Slab_Reinforcement1=request.getParameter("ff_Beam_and_Slab_Reinforcement1");
            String ff_Partition_walls=request.getParameter("ff_Partition_walls");
            String ff_Partition_walls1=request.getParameter("ff_Partition_walls1");
            String ff_Door_Window_Placement=request.getParameter("ff_Door_Window_Placement");
            String ff_Door_Window_Placement1=request.getParameter("ff_Door_Window_Placement1");
            String ff_Plastering=request.getParameter("ff_Plastering");
            String ff_Plastering1=request.getParameter("ff_Plastering1");
            String ff_Plastering_Curing=request.getParameter("ff_Plastering_Curing");
            String ff_Plastering_Curing1=request.getParameter("ff_Plastering_Curing1");
            String ff_Painting=request.getParameter("ff_Painting");
            String ff_Painting1=request.getParameter("ff_Painting1");
            
            
            
            
            HttpSession session = request.getSession();
            RequestDispatcher rd = null;
            session.setAttribute("msg", "Project Plan Added Successfully");
             

            rd = request.getRequestDispatcher("admin_home.jsp");
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
