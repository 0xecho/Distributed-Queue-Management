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
import java.rmi.registry.*;
public class QueueServer {
    public static void main(String []a){
		try{
			Registry reg= LocateRegistry.createRegistry(10000);
			QueueMgmtImpl que=new QueueMgmtImpl();
			reg.bind("Queue",que);
			System.out.println("Server Started Successfuly!!");
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
}
