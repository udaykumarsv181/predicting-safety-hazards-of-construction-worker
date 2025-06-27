/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sumit
 */
public class check_alert extends HttpServlet {

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
            System.out.println("Checking equipment status");
            File file = new File("E:/fire.txt"); 
            FileReader fr=new FileReader(file);
            BufferedReader br = new BufferedReader(fr); 

               
            File file0 = new File("E:/eid.txt"); 
            FileReader fr0=new FileReader(file0);
            BufferedReader br0 = new BufferedReader(fr0); 

            String st0="",eid=""; 
            while ((st0 = br0.readLine()) != null) 
            {
            System.out.println(st0);
            eid=st0;
            }
            
            FileOutputStream fout0=new FileOutputStream(file0);
            fout0.write("".getBytes());
            fout0.close();
            
            
            br0.close();
            fr0.close();
            
            
            
            
            String st="",fire=""; 
            while ((st = br.readLine()) != null) 
            {
            System.out.println(st);
            fire=st;
            }
            
            FileOutputStream fout=new FileOutputStream(file);
            fout.write("".getBytes());
            fout.close();
            
            
            br.close();
            fr.close();
            
            File file1 = new File("E:/smoke.txt"); 
            FileReader fr1=new FileReader(file1);
            BufferedReader br1 = new BufferedReader(fr1); 

            String st1="",smoke=""; 
            while ((st1 = br1.readLine()) != null) 
            {
            System.out.println(st1);
            smoke=st1;
            }
            
            FileOutputStream fout1=new FileOutputStream(file1);
            fout1.write("".getBytes());
            fout1.close();
            
            
            br1.close();
            fr1.close();
            
            
            
            File file2 = new File("E:/voltage.txt"); 
            FileReader fr2=new FileReader(file2);
            BufferedReader br2 = new BufferedReader(fr2); 

            String st2="",voltage=""; 
            while ((st2 = br2.readLine()) != null) 
            {
            System.out.println(st2);
            voltage=st2;
            }
            
            FileOutputStream fout2=new FileOutputStream(file2);
            fout2.write("".getBytes());
            fout2.close();
            
            
            br2.close();
            fr2.close();
            
            
            
            File file3 = new File("E:/current.txt"); 
            FileReader fr3=new FileReader(file3);
            BufferedReader br3 = new BufferedReader(fr3); 

            String st3="",current=""; 
            while ((st3 = br3.readLine()) != null) 
            {
            System.out.println(st3);
            current=st3;
            }
            
            FileOutputStream fout3=new FileOutputStream(file3);
            fout3.write("".getBytes());
            fout3.close();
            
            
            br3.close();
            fr3.close();
            
            
            
            
            
            
            out.print(eid+"##"+fire+"##"+smoke+"##"+voltage+"##"+current);
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
