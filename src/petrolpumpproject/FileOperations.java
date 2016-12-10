/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrolpumpproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author secret
 */
public class FileOperations {
    
    public static boolean appendToFile(String info, String fileName){ 
        try{
            PrintWriter out=new PrintWriter(new PrintWriter(new FileOutputStream(new File(fileName), true))); 
            out.append(info);
            out.close();
            return true;
        }
        catch(Exception e){
            return false;
        }
    
        
    }
    
    public static int ID=1111;
    
    public static final String fuelFile="Files/fuel.txt";
    public static final String orderFile="Files/PendingOrders.txt";
    
    
    public static ArrayList<String[]> getFuelInfo(String fileName){
         try{
            Scanner in=new Scanner(new File(fileName));
            ArrayList<String[]> info=new ArrayList<String[]>();
            while(in.hasNext()){
                String []infos=in.nextLine().trim().split("\\$");
                info.add(infos);
            }
            
            return  info;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static double getFuelValue(String fuelType,int index, String fileName){
        try{
            Scanner in=new Scanner(new File(fileName));            
            while(in.hasNext()){
                String []infos=in.nextLine().trim().split("\\$");
                if(infos[0].equals(fuelType)){
                    try{
                        double quantity=Double.parseDouble(infos[index]);
                        return quantity;
                    }
                    catch(Exception e){                        
                    }                    
                }
            }
            
            return -1;
        }
        catch(Exception e){
            return -1;
        }
    }
    
    
}
