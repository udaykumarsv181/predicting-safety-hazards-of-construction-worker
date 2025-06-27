/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import Logic.DifferenceExample;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBQuery {

    Connection con = null;
    ResultSet rs = null;
    Statement st = null;

    public String loginInfo(String email, String password) throws ClassNotFoundException, SQLException {

        String utype = "";
        con = DBConnection.getConnection();
        st = con.createStatement();
        String q = "select * from login where email='" + email + "' and pass='" + password + "'";
        System.out.println("value of email and password: " + email + "   " + password);
        System.out.println("q = " + q);
        rs = st.executeQuery(q);

        if (rs.next()) {

            utype = rs.getString("utype");//vuvu
        }//jhvhjvh

        return utype;
    }
    public int add_insurance_request(String eid, String name, String email, String mobile, String dept,String vid) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection();
        
        String pattern = "dd-MM-yyyy";
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

                        String tdate = simpleDateFormat.format(new Date());
                        System.out.println(tdate);
                        
                        String  pattern1 = "hh-mm-ss";
                        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);

                        String tdate1 = simpleDateFormat1.format(new Date());
                        tdate1=tdate1.replace(":", "-");
                        System.out.println(tdate1);
        
        
        String q = "insert into insurance_request set eid='" + eid + "',name='" + name + "',email='" + email + "',mobile='" + mobile + "',dept='"+dept+"' ,adate='"+tdate+"',atime='"+tdate1+"' ,vid='"+vid+"',status='Pending'";
        System.out.println(">>" + q);
        st = con.createStatement();

        System.out.println("" + q);
        i = st.executeUpdate(q);


       

        return i;
    }
    public int update_insurance_request(String id, String status) throws ClassNotFoundException, SQLException {
        int i = 0;
        con = DBConnection.getConnection();
        
        
        
        
        String q = "update  insurance_request set status='" + status + "' where id='" + id + "'";
        System.out.println(">>" + q);
        st = con.createStatement();

        System.out.println("" + q);
        i = st.executeUpdate(q);


       

        return i;
    }
// public String get_type_of_tag(String tag) throws ClassNotFoundException, SQLException {
//
//        String utype = "";
//        con = DBConnection.getConnection();
//        st = con.createStatement();
//        String q = "select * from login where email='" + email + "' and pass='" + password + "'";
//        System.out.println("value of email and password: " + email + "   " + password);
//        System.out.println("q = " + q);
//        rs = st.executeQuery(q);
//
//        if (rs.next()) {
//
//            utype = rs.getString("utype");//vuvu
//        }//jhvhjvh
//
//        return utype;
//    }
public int add_login(String email, String pass, String utype) throws ClassNotFoundException, SQLException {
        int i = 0;
        String q = "insert into login set email='" + email + "',pass='" + pass + "',utype='" + utype + "' ";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        
        return i;
    }

 
     public int add_device(String equipment_name, String equipment_description, String rfid_tag,String manufacturer, String vendor, String date_of_manufacturing, String date_of_introduction, String date_of_expiry,String status) throws ClassNotFoundException, SQLException {
        int i = 0;
        String q = "insert into equipment_details set equipment_name='" + equipment_name + "',equipment_description='" + equipment_description + "',rfid_tag='" + rfid_tag + "',status='" + status + "',manufacturer='" + manufacturer + "',vendor='" + vendor + "',date_of_manufacturing='" + date_of_manufacturing + "',date_of_introduction='" + date_of_introduction + "',date_of_expiry='" + date_of_expiry + "' ";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        String q1="select MAX(eid) from equipment_details";
        rs=st.executeQuery(q1);
        if(rs.next())
        {
        i=rs.getInt(1);
        }
        
        return i;
    }
     
     public int add_employee(String eid, String ename, String email,String mobile, String tag, String dob, String doj, String dept) throws ClassNotFoundException, SQLException {
        int i = 0;
        String q = "insert into employee_details set eid='" + eid + "',ename='" + ename + "',email='" + email + "',mobile='" + mobile + "',tag='" + tag + "',dob='" + dob + "',doj='" + doj + "',dept='" + dept + "' ";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
    
        
        return i;
    }
      public int update_total_days(int days) throws ClassNotFoundException, SQLException {
        int total_days=0;
        con = DBConnection.getConnection();
        st = con.createStatement();
        String qq="select total_days from project_details";
        rs=st.executeQuery(qq);
        if(rs.next())
        {
        total_days=rs.getInt(1);
        
        }
        total_days=total_days+days;
        String q = "update  project_details set total_days='" + total_days + "' ";
        
        st.executeUpdate(q);
    
        
        return total_days;
    }
     public ArrayList  get_equipment_details(String tag) throws ClassNotFoundException, SQLException {
        ArrayList al=new ArrayList();
        String q = "select * from equipment_details where  rfid_tag='" + tag + "' ";
        System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        rs=st.executeQuery(q);
        if(rs.next())
        {
        al.add(rs.getInt("eid"));
        al.add(rs.getString("equipment_name"));
        al.add(rs.getString("equipment_description"));
        al.add(rs.getString("status"));
        al.add(rs.getString("manufacturer"));
        al.add(rs.getString("vendor"));
        al.add(rs.getString("date_of_manufacturing"));
        al.add(rs.getString("date_of_introduction"));
        al.add(rs.getString("date_of_expiry"));
        }
        
      
        return al;
    }
     public ArrayList  get_employee_details(String tag) throws ClassNotFoundException, SQLException {
        ArrayList al=new ArrayList();
        String q = "select * from employee_details where  tag='" + tag + "' ";
        System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        rs=st.executeQuery(q);
        if(rs.next())
        {
        al.add(rs.getString("eid"));
        al.add(rs.getString("ename"));
        al.add(rs.getString("email"));
        al.add(rs.getString("mobile"));
        al.add(rs.getString("dob"));
        al.add(rs.getString("doj"));
        al.add(rs.getString("dept"));
       
        }
        
      
        return al;
    }
     
     public String  check_equipment_usage_foundation(String ename) throws ClassNotFoundException, SQLException {
        String stages="",days="";
        String q = "select * from foundation ";
        System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        rs=st.executeQuery(q);
        if(rs.next())
        {
        String Structural_Lines1=rs.getString("Structural_Lines1");
        if(Structural_Lines1.contains(ename))
        {
        stages="foundation#Structural_Lines";
        days=rs.getString("Structural_Lines");
        }
        else if(Structural_Lines1.contains(ename))
        {
        stages="foundation#Excavation_for_foundation";
        days=rs.getString("Excavation_for_foundation");
        }
        else if(Structural_Lines1.contains(ename))
        {
        stages="foundation#Base_Concreting";
        days=rs.getString("Base_Concreting");
        }
        else
        {
        stages="foundation#Curing_for_Base_Concrete";
        days=rs.getString("Curing_for_Base_Concrete");
        }
        
       
        
        
       
        }
        
      
        return stages+"#"+days;
    }
     
     public static void main(String[] args) {
        DBQuery db=new DBQuery();
        try {
          int used_days=  db.add_equipment_site("10", "5");
          System.out.println("used_days="+used_days);
                        String ename="BACKHOE EXCAVATOR";
                            System.out.println("ename="+ename);
                        
                        String det=db.check_equipment_usage_foundation(ename);
                        System.out.println("det="+det);
                        String d[]=det.split("#");
                        int req_days=Integer.parseInt(d[2]);
                        int days=0;
                         days=used_days-req_days;
                        int tot_days=db.update_total_days(days);
                            System.out.println("tot_days="+tot_days);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public int add_equipment_site(String eid,String site_id) throws ClassNotFoundException, SQLException {
        int i = 0;
        int old_site=0;
        String indate="";
        String q = "select * from equipment_current_site where  eid='" + eid + "' ";
        System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        rs=st.executeQuery(q);
        if(rs.next())
        {
        i=-1;
        old_site=rs.getInt("site_id");
        }
        if(i==0)
        {
            i=-1;
         String q1="insert into equipment_current_site values('" + eid + "','"+site_id+"')";
         st.executeUpdate(q1);
        }
        else{
         String q2="update equipment_current_site set site_id= '"+site_id+"' where eid='" + eid + "'";
         st.executeUpdate(q2);
         String pattern = "dd-MM-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

         String tdate = simpleDateFormat.format(new Date());
         System.out.println(tdate);

         String pattern1 = "hh-mm-ss";
         SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);

         String tdate1 = simpleDateFormat1.format(new Date());
         tdate1=tdate1.replace(":", "-");
         System.out.println(tdate1);
         String qq="select * from track_eqipment where eid='"+eid+"' and status='on_track'";
            System.out.println(qq);
         ResultSet rs=st.executeQuery(qq);
         if(rs.next())
         {
         indate=rs.getString("in_date");
         
         }
            System.out.println("indate="+indate);
            System.out.println("cdate="+tdate);
         String q3 ="update track_eqipment set status='off_track', out_date='"+tdate+"', out_time='"+tdate1+"' where eid='"+eid+"' and status='on_track'"; 
         st.executeUpdate(q3);
         
         
         String q4="insert into track_eqipment set eid='"+eid+"',site_id='"+site_id+"',in_date='"+tdate+"',in_time='"+tdate1+"',status='on_track'";
         st.executeUpdate(q4);
         
         DifferenceExample de=new DifferenceExample();
         String ar1[]=indate.split("-");
         String ar2[]=tdate.split("-");
         LocalDate first_date = LocalDate.of(Integer.parseInt(ar1[2]), Integer.parseInt(ar1[1]), Integer.parseInt(ar1[0]));
                LocalDate second_date = LocalDate.of(Integer.parseInt(ar2[2]), Integer.parseInt(ar2[1]), Integer.parseInt(ar2[0]));
                int diff[]=de.find(first_date, second_date);
                System.out.println("Diff in  days "+diff[0]);
                System.out.println("Diff in  months "+diff[1]);
                System.out.println("Diff in  years "+diff[2]);
                i=diff[0];
         
         
        }
      
      
        return i;
    }
  public int add_employee_site(String eid,String site_id) throws ClassNotFoundException, SQLException {
        int i = 0;
        int old_site=0;
        String q = "select * from employee_current_site where  eid='" + eid + "' ";
        System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        rs=st.executeQuery(q);
        if(rs.next())
        {
        i=1;
        old_site=rs.getInt("site_id");
        }
        if(i==0)
        {
         String q1="insert into employee_current_site values('" + eid + "','"+site_id+"')";
         st.executeUpdate(q1);
        }
        else{
         String q2="update employee_current_site set site_id= '"+site_id+"' where eid='" + eid + "'";
         st.executeUpdate(q2);
         String pattern = "dd-MM-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

         String tdate = simpleDateFormat.format(new Date());
         System.out.println(tdate);

         String pattern1 = "hh-mm-ss";
         SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);

         String tdate1 = simpleDateFormat1.format(new Date());
         tdate1=tdate1.replace(":", "-");
         System.out.println(tdate1);
         String q3 ="update track_employee set status='off_track', out_date='"+tdate+"', out_time='"+tdate1+"' where eid='"+eid+"' and status='on_track'"; 
         st.executeUpdate(q3);
         String q4="insert into track_employee set eid='"+eid+"',site_id='"+site_id+"',in_date='"+tdate+"',in_time='"+tdate1+"',status='on_track'";
         st.executeUpdate(q4);
        }
      
      
        return i;
    }
  public int add_equipment_status(String eid, String fire, String smoke,String voltage, String status) throws ClassNotFoundException, SQLException {
        int i = 0;
        String pattern = "dd-MM-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

         String tdate = simpleDateFormat.format(new Date());
         System.out.println(tdate);

         String pattern1 = "hh-mm-ss";
         SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);

         String tdate1 = simpleDateFormat1.format(new Date());
         tdate1=tdate1.replace(":", "-");
         System.out.println(tdate1);
        String q = "insert into equipment_status set eid='" + eid + "',fire='" + fire + "',smoke='" + smoke + "',voltage='" + voltage + "',status='" + status + "',rdate='" + tdate + "',rtime='" + tdate1 + "' ";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        
        return i;
    }
 
 
 
 
 
 
 
  public int add_equipment_issues(String supervisor, String eid, String name,String Manufacturer, String Vendor, String msg) throws ClassNotFoundException, SQLException {
        int i = 0;
        String pattern = "dd-MM-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

         String tdate = simpleDateFormat.format(new Date());
         System.out.println(tdate);

         String pattern1 = "hh-mm-ss";
         SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);

         String tdate1 = simpleDateFormat1.format(new Date());
         tdate1=tdate1.replace(":", "-");
         System.out.println(tdate1);
        String q = "insert into equipment_issues_details set supervisor='" + supervisor + "',eid='" + eid + "',name='" + name + "',Manufacturer='" + Manufacturer + "',Vendor='" + Vendor + "',msg='" + msg + "',idate='" + tdate + "',itime='" + tdate1 + "',status='Pending' ";
      System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        String q1="select MAX(id) from equipment_issues_details";
        rs=st.executeQuery(q1);
        if(rs.next())
        {
        i=rs.getInt(1);
        }
        
        return i;
    }
 
  public int add_issues(String supervisor, String eid, String name,String mob, String dept, String msg) throws ClassNotFoundException, SQLException {
        int i = 0;
        String pattern = "dd-MM-yyyy";
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

         String tdate = simpleDateFormat.format(new Date());
         System.out.println(tdate);

         String pattern1 = "hh-mm-ss";
         SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(pattern1);

         String tdate1 = simpleDateFormat1.format(new Date());
         tdate1=tdate1.replace(":", "-");
         System.out.println(tdate1);
        String q = "insert into issues_details set supervisor='" + supervisor + "',eid='" + eid + "',name='" + name + "',mob='" + mob + "',dept='" + dept + "',msg='" + msg + "',idate='" + tdate + "',itime='" + tdate1 + "',status='Pending' ";
      System.out.println(q);
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        String q1="select MAX(id) from issues_details";
        rs=st.executeQuery(q1);
        if(rs.next())
        {
        i=rs.getInt(1);
        }
        
        return i;
    }
 
  public int add_Project_details(String pname, String total_days, String st_days,String  end_days) throws ClassNotFoundException, SQLException {
        int i = 0;
        String q = "insert into project_details values( '" + pname + "','" + total_days + "','" + st_days + "','" + end_days + "' )";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        
        return i;
    }
 public int add_Foundation(String Foundation_days, String Structural_Lines, String Structural_Lines1,String  Excavation_for_foundation,String  Excavation_for_foundation1,String  Base_Concreting,String  Base_Concreting1,String Curing_for_Base_Concrete ,String  Curing_for_Base_Concrete1) throws ClassNotFoundException, SQLException {
        int i = 0;
        String q = "insert into foundation values( '" + Foundation_days + "','" + Structural_Lines + "','" + Structural_Lines1 + "','" + Excavation_for_foundation + "','" + Excavation_for_foundation1 + "','" + Base_Concreting + "','" + Base_Concreting1 + "','" + Curing_for_Base_Concrete + "','" + Curing_for_Base_Concrete1 + "' )";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        
        return i;
    }
 
  public int add_Footing(String footing_days, String Placement_of_Footing_Reinforcement, String Placement_of_Footing_Reinforcement1,String  fConcreting,String  fConcreting1,String  Curing_for_Footing,String  Curing_for_Footing1) throws ClassNotFoundException, SQLException {
        int i = 0;
        String q = "insert into footing values( '" + footing_days + "','" + Placement_of_Footing_Reinforcement + "','" + Placement_of_Footing_Reinforcement1 + "','" + fConcreting + "','" + fConcreting1 + "','" + Curing_for_Footing + "','" + Curing_for_Footing1 + "' )";
        con = DBConnection.getConnection();
        st = con.createStatement();
        i = st.executeUpdate(q);
        
        return i;
    }
 
}
