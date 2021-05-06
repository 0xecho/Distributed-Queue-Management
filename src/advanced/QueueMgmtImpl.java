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
import java.rmi.server.UnicastRemoteObject;
import java.rmi.*;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueueMgmtImpl extends UnicastRemoteObject implements QueueMgmt {

    public QueueMgmtImpl() throws RemoteException, SQLException {
        super();
        try {
            this.createConn();
        } catch (Exception ex) {
            Logger.getLogger(QueueMgmtImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static Queue<Integer> qu = new LinkedList<>();
    static Queue<String> queue = new LinkedList<>();
    static HashMap<String, Integer> as = new HashMap<String, Integer>();
    static int n = 1;
    Connection conn;

    public void createConn() throws ClassNotFoundException, SQLException {

        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        String DB_URL = "jdbc:mysql://localhost:3306/rmi";

        String USER = "root";
        String PASS = "";

        Connection conn = null;
        PreparedStatement stmt = null;

        Class.forName("com.mysql.cj.jdbc.Driver");

        this.conn = DriverManager.getConnection(DB_URL, USER, PASS);

    }

    public int nxt(String x) throws RemoteException {
        if (qu.size() == 0) {
            System.out.println("No One In Line");
            return -1;
        } else {
            System.out.println("Sending Number" + qu.peek() + " to " + x);
            as.remove(qu.peek());
            as.put(x, qu.peek());
            return qu.remove();
        }
    }

    public void add() throws RemoteException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Customer(`name`) Values(?)");
//            System.out.println("Added: " + n);
            stmt.setString(1,Integer.toString(n));
            qu.add(n);
            
            stmt.executeUpdate();

        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        n++;

    }

    public int last() throws RemoteException {
        if (qu.size() == 0) {
            return -1;
        }
        return (int)qu.toArray()[qu.size()-1];
    }
    
    public int peek() throws RemoteException {
        if (qu.size() == 0) {
            return -1;
        }
        return qu.peek();
    }

    public int siz() throws RemoteException {
        return qu.size();
    }

    public HashMap que() throws RemoteException {
        return as;
    }

}
