package client.tenebz.core;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.tenebz.beans.Client;
import server.tenebz.io.TenebzIO;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOURE
 */
public class TenebzClient {

    public static void main(String[] args) throws RemoteException {
        TenebzClient client = new TenebzClient();
        TenebzIO tenebz = client.connectServer();
        
        System.out.println(tenebz.join(new Client("John")));
        System.out.println(tenebz.join(new Client("Bob")));
        System.out.println(tenebz.join(new Client("Alice")));
        System.out.println(tenebz.join(new Client("John")));
        
    }

    public TenebzIO connectServer() {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            TenebzIO tenebz = (TenebzIO) reg.lookup("serveur");
            System.out.println("Connecté au serveur");
            return tenebz;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
