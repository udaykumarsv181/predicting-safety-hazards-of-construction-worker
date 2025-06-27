

















package Logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author sumit
 */



import DataBase.DBQuery;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
// receive euipment details
public static int count=0;
public static String area = "a1",input="";
    public static void main(String[] args) throws IOException {
       
        ServerSocket listener = new ServerSocket(9091);
        try{
            while(true){
                Socket socket = listener.accept();
                socket.setKeepAlive(true);
                System.out.println("Client Connected");
                try{
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    input=in.readLine();
                   String site1="";
//                    try{
//                        File file1 = new File("C:/Users/91948/OneDrive/Documents/site.txt"); 
//
//                        BufferedReader br = new BufferedReader(new FileReader(file1)); 
//
//                        String st; 
//                        while ((st = br.readLine()) != null) {
//                        System.out.println(st); 
//                        site1=st;
//                        }
//                        }catch(Exception e)
//                        {
//                        e.printStackTrace();
//                        }
                   //  input=site1+"#"+input;
                    System.out.println("Client response: " + input);
                 
                   
                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    if(!input.equals("") && input.length()>4 && !input.startsWith("Key"))
                    {
                     //   input=input.substring(0,input.length()-1);  //to remove the junk value at the end
                    String arr[]=input.split("#");
                   // int rn=Integer.parseInt(arr[0])-48;
                    String site=arr[0];
                   String tag=arr[1];
                    DBQuery db=new DBQuery();
                    
                        System.out.println("tag= "+tag);
                        System.out.println("site= "+site);
                        
                        // check first the tag type---- equipment ot employee 
                        
                        
                        
                        
                        ArrayList al=db.get_equipment_details(tag);
                        if(al.size()!=0)
                        {
                        for(int i=0;i<al.size();i++)
                        {
                        
                            System.out.println(">>"+al.get(i).toString());
                        }
                        
                        int used_days=db.add_equipment_site(al.get(0).toString(), site);
                            System.out.println("used_days="+used_days);
                             if(used_days!=-1)
                            {
                        String ename=al.get(1).toString();
                            System.out.println("ename="+ename);
                        
                        String det=db.check_equipment_usage_foundation(ename);
                        System.out.println("det="+det);
                        String d[]=det.split("#");
                        int req_days=Integer.parseInt(d[2]);
                        int days=0;
                         days=used_days-req_days;
                        int tot_days=db.update_total_days(days);
                            System.out.println("tot_days="+tot_days);
                            
                        }
                        }
                        else{
                        ArrayList al1=db.get_employee_details(tag);
                        
                        if(al1.size()!=0)
                        {
                        for(int i=0;i<al1.size();i++)
                        {
                        
                            System.out.println(">>"+al1.get(i).toString());
                        }
                        db.add_employee_site(al1.get(0).toString(), site);
                        
                        
                        
                        }
                        }
                    
                    }
                    
                  
                    
                   
                    
                   
                   out.flush();
                     
                     
                }catch(Exception e)
                {
                e.printStackTrace();
                }
                
                finally {
                    socket.close();
                }
            }
        } finally {
            listener.close();
        }
    }

}