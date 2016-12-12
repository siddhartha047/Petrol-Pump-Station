/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrolpumpproject;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author secret
 */
public class CommonFunctions {
    
     public static void updateFuelTable(JTable jTable){        
        
        ArrayList<String[]> listFuel=FileOperations.getFuelInfo(FileOperations.fuelFile);
        if(listFuel==null || listFuel.isEmpty())return;
        jTable.removeAll();
        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
        dm.getDataVector().removeAllElements();
        jTable.removeAll();        
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);
            String[] need=new String[2];
            for(int j=0;j<2;j++){
             //   jTable.getModel().setValueAt(infos[j],i,j);\
             need[j]=infos[j];
            }
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();            
            model.addRow(need);
            
        }
        
    }
    
      public static void updateFuelTable1(JTable jTable){        
        
        ArrayList<String[]> listFuel=FileOperations.getFuelInfo(FileOperations.fuelFile);
        if(listFuel==null || listFuel.isEmpty())return;
        jTable.removeAll();
        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
        dm.getDataVector().removeAllElements();
        jTable.removeAll();        
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);
            String[] need=new String[4];
            for(int j=0;j<4;j++){
             //   jTable.getModel().setValueAt(infos[j],i,j);
             need[j]=infos[j];
            }
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();            
            model.addRow(need);
            
        }
        
    }
     
     
      
     public static void updateFuelCombo(JComboBox comboBox){
        
        ArrayList<String[]> listFuel=FileOperations.getFuelInfo(FileOperations.fuelFile);
        if(listFuel==null || listFuel.isEmpty())return;
        comboBox.removeAllItems();
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);            
            comboBox.addItem(new ComboItem(infos[0],infos[0]));                        
        }
        
    }
     
     public static void updateAdminCombo(JComboBox comboBox){
        
         comboBox.removeAllItems();
        ArrayList<String[]> listFuel=FileOperations.getEmployeeInfo(FileOperations.employeeFile);
        if(listFuel==null || listFuel.isEmpty())return;
        
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);            
            comboBox.addItem(new ComboItem(infos[0],infos[0]));                        
        }
        
    }
     
     
     public static void loadOrders(JTable jTable, int type){
                
        ArrayList<String[]> listFuel=FileOperations.getOrderInfos(FileOperations.orderFile);
        if(listFuel==null || listFuel.isEmpty())return;

        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
        dm.getDataVector().removeAllElements();
        jTable.removeAll();        
    
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);
                        
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if(type==1 && infos[6].equals("1"))continue;
            if(type==1){
                infos[6]="Confirm";
            }
            else if(type==2){                               
                
                if(infos[6].equals("0")){
                    infos[6]="Pending";
                }
                else 
                {
                    infos[6]="Complete";
                }
            }
            model.addRow(infos);
            
            

        }
    }
     
    public static void loadOrders2(JTable jTable, int type){
        
        
        ArrayList<String[]> listFuel=FileOperations.getOrderInfos(FileOperations.orderFile);
        if(listFuel==null || listFuel.isEmpty())return;

        DefaultTableModel dm = (DefaultTableModel)jTable.getModel();
        dm.getDataVector().removeAllElements();
        jTable.removeAll();        
    
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);
            
            /*for(int j=0;j<infos.length-1;j++){
                jTable.getModel().setValueAt(infos[j],i,j);
            }
            jTable.getModel().setValueAt("Confirm",i,infos.length-1);
            */                         

            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            if(type==1){
                infos[6]="Confirm";
            }
            else if(type==2){
                if(infos[6].equals("0"))infos[6]="Pending";
                else 
                    infos[6]="Complete";
            }
            model.addRow(infos);
            
            

        }
                 
        if(type==1){
            
            
            AbstractAction delete = new AbstractAction()
            {
                public void actionPerformed(ActionEvent e)
                {
                    System.out.println("Clicked");
                    //JTable table = (JTable)e.getSource();
                    //int modelRow = Integer.valueOf( e.getActionCommand() );
                    //((DefaultTableModel)table.getModel()).removeRow(modelRow);
                }
            };
           

        
            ButtonColumn buttonColumn = new ButtonColumn(jTable,delete, 6);
                        
        }
        
       
            
        
        
        
    }
     
}
