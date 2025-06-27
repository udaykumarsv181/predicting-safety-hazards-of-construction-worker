/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

/**
 *
 * @author sumit
 */


import java.text.SimpleDateFormat;
import java.time.*;   
import java.util.*;   
public class DifferenceExample {   
    // Create function for finding difference   
   
   public static int[] find(LocalDate  first_date, LocalDate second_date)
    {   
        int ar[]=new int[3]; 
        // Get period between the first and the second date   
        Period difference = Period.between(first_date, second_date);   
        // Show date difference in years, months, and days   
        System.out.print("Difference between two dates is:\n");   
        System.out.printf( "%d days, %d months and %d years",   
            difference.getDays(),  
            difference.getMonths(),   
            difference.getYears());  
        ar[0]=difference.getDays();
        ar[1]=difference.getMonths();
        ar[2]=difference.getYears();
        return ar;
    }   
    // Main class  
    
    public static void main(String[] args)
    {      String pattern = "MM-dd-yyyy";
  SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

  String tdate = simpleDateFormat.format(new Date());
  System.out.println(tdate);
  String ar[]=tdate.split("-");
        // Create first and second date using LocalDate's of() method  
        LocalDate first_date = LocalDate.of(Integer.parseInt(ar[2]), Integer.parseInt(ar[0]), Integer.parseInt(ar[1]));   
        LocalDate second_date = LocalDate.of(2021, 9, 22);   
        // Calling find() method to get and print the period between both dates   
        find(first_date, second_date);   
    }   
}  