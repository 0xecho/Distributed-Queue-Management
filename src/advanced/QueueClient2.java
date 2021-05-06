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
import java.util.Scanner;
public class QueueClient2 {
    public static void main(String a[]){
		try{
			QueueMgmt R=(QueueMgmt)Naming.lookup("//localhost:1000/Queue");
			Scanner in=new Scanner(System.in);
			double x,y;
			char s;
			while(true){
				System.out.println("Enter 1 to add 2 to remove... -1 To Exit");

				x=in.nextDouble();
                                if(x==1){
				R.add();
                                
                                }
                                else{
                                System.out.println("next "+ R.nxt("Client 2"));
                                }
			}
			
		}
		catch(Exception E){
			System.out.println(E);
		}
	}
}
