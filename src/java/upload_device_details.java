/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBase.DBQuery;
import Logic.MyQr;
import Logic.info;
import com.oreilly.servlet.MultipartRequest;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
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
public class upload_device_details extends HttpServlet {
private final String UPLOAD_DIRECTORY = info.path;
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
           System.out.println("***************************");
            String dirName =UPLOAD_DIRECTORY;
            System.out.println("????????????????????????????????"+dirName);
	    String paramname=null;
            HttpSession session=request.getSession();
            //String user=session.getAttribute("user1").toString();
                int id=0; 
                byte[] b=null, b1=null,b2=null,b3=null;
                ArrayList list=new ArrayList();
                 FileWriter fw=null;
                
                Connection con=null;
                PreparedStatement pstmt=null;
                int row=0;
		int eid=0;
   		  File file1 = null;
   		  File file2 = null;
                  File file3= null;
                  File file4= null;
			
		RequestDispatcher view=null;
		
			int a=0,s=0,p=0;
                        String ename="",description="",tag="",manufacturer="",vendor="",date_of_manufacturing="",date_of_introduction="",date_of_expiry="",abPath="";
                        BufferedInputStream  bis = null; 
                        BufferedOutputStream bos = null;
			MultipartRequest multi = new MultipartRequest(request, dirName,	10 * 1024 * 1024); 
                        Enumeration params = multi.getParameterNames();
			while (params.hasMoreElements()) 
			{
				paramname = (String) params.nextElement();
                                if(paramname.equalsIgnoreCase("ename"))
				{
					ename=multi.getParameter(paramname);
				}
                                 if(paramname.equalsIgnoreCase("tag"))
				{
					tag=multi.getParameter(paramname);
				}
                                if(paramname.equalsIgnoreCase("manufacturer"))
				{
					manufacturer=multi.getParameter(paramname);
				}
                                if(paramname.equalsIgnoreCase("vendor"))
                                {
					vendor=multi.getParameter(paramname);
				}
                                if(paramname.equalsIgnoreCase("date_of_manufacturing"))
				{
					date_of_manufacturing=multi.getParameter(paramname);
				}
                                 if(paramname.equalsIgnoreCase("date_of_introduction"))
				{
					date_of_introduction=multi.getParameter(paramname);
				}
                                  if(paramname.equalsIgnoreCase("date_of_expiry"))
				{
					date_of_expiry=multi.getParameter(paramname);
				}
                                   if(paramname.equalsIgnoreCase("description"))
				{
					description=multi.getParameter(paramname);
				}
				
                              
                        }
                        Enumeration files = multi.getFileNames();	
                        while (files.hasMoreElements()) 
                        {
                            paramname = (String) files.nextElement();
                            
		
                            if(paramname != null && paramname.equals("file"))
                            {
                                a=1;
                                abPath = multi.getFilesystemName(paramname);
                                System.out.println("file>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+abPath);
                                String fPath = dirName+abPath;
                                System.out.println("<><><><><><><><><><><><>"+fPath);
                                
                            }
                        }
                        
		
            
                
               
                DBQuery db=new DBQuery();
            try {
               eid=  db.add_device(ename, description, tag, manufacturer, vendor, date_of_manufacturing, date_of_introduction, date_of_expiry, "Active");
            
              MyQr mq=new MyQr();
              String info="eq#"+eid+"#"+ename+"#"+description+"#"+tag+"#"+manufacturer+"#"+vendor+"#"+date_of_manufacturing+"#"+date_of_introduction+"#"+date_of_expiry+"#Active";
              mq.gen_qr1(eid+"", info);
              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(add_device.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(add_device.class.getName()).log(Level.SEVERE, null, ex);
            }
                File fs=new File(info.path+abPath);
               
                File fd=new File(info.path+eid+".pdf");
               
                copyFileUsingStream(fs,fd);
                fs.delete();
                
              
            RequestDispatcher rd = null;
            session.setAttribute("msg", "Device Added Successfully");
            rd = request.getRequestDispatcher("add_device_details.jsp");
            rd.forward(request, response);
                
                
                
                
                
            } catch (Exception ex)
            {
                request.setAttribute("message", "File upload failed due to : " + ex);
            }
        
    
    }
private static void copyFileUsingStream(File source, File dest) throws IOException {
    InputStream is = null;
    OutputStream os = null;
    try {
        is = new FileInputStream(source);
        os = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
    } finally {
        is.close();
        os.close();
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
