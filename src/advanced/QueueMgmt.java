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
import java.rmi.*;
import java.util.HashMap;
public interface QueueMgmt extends Remote {
    public int nxt(String x) throws RemoteException;
    public void add() throws RemoteException;
    public int last() throws RemoteException;
    public int peek() throws RemoteException;
    public int siz() throws RemoteException;
    public HashMap que() throws RemoteException;
    
    
}
