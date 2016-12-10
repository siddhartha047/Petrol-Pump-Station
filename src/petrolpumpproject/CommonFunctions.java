/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrolpumpproject;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author secret
 */
public class CommonFunctions {
    
     public static void updateFuelTable(JTable jTable){        
        
        ArrayList<String[]> listFuel=FileOperations.getFuelInfo(FileOperations.fuelFile);
        if(listFuel==null || listFuel.isEmpty())return;
        jTable.removeAll();
        for(int i=0;i<listFuel.size();i++){
            String[] infos=listFuel.get(i);
            for(int j=0;j<2;j++){
                jTable.getModel().setValueAt(infos[j],i,j);
            }
            
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
     
}
