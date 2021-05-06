/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advanced;

/**
 *
 * @author Bemmy
 */
import java.rmi.Naming;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class QueueClient {
    public static void main(String a[]){
            HashMap<String,Integer> as=new HashMap<String, Integer>();
            as.put("AA",2);
            as.put("Ab",2);
            as.put("Ac",2);
            as.put("Ad",2);
            as.put("Ae",2);
            for(Map.Entry<String,Integer> entry : as.entrySet()){
                System.out.println(entry.getKey()+" = "+entry.getValue());
            }
    }
    
}
