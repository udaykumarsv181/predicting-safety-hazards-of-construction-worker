/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sumit
 */
public class info {
     public static String year="2025",pname="Construction Site Monitoring";
     public int total_guide=20,total_students=100;
    public static String path="C:/Users/uday kumar/Downloads/code/Real_Estate_Site_Monitoring/Real_Estate_Site_Monitoring/web/";
    public static ArrayList al=new ArrayList();
    public static ArrayList alst=new ArrayList();
       public static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
    
}
