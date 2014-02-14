package client.tenebz.core;


import client.tenebz.view.AuthView;
import static client.tenebz.view.AuthView.ErrorMsg;
import client.tenebz.view.ChatView;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.tenebz.beans.Client;
import server.tenebz.beans.Message;
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

    private TenebzIO server;
    private Client client;
    private ChatView chat;
    
    public static void main(String[] args) throws RemoteException {
        TenebzClient tenebzClient = new TenebzClient();
        tenebzClient.connectServer();
        if(tenebzClient.getServer() == null) {
            ErrorMsg("Impossible de se connecter au serveur");
        } else {
            (new AuthView(tenebzClient)).view();            
        }
    }

    public boolean connectServer() {
        try {
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            server = (TenebzIO) reg.lookup("serveur");
            System.out.println("Connecté au serveur");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public TenebzIO getServer() {
        return server;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setChat(ChatView chat) {
        this.chat = chat;
    }
    
    public void receive(Message msg) {
        chat.afficher("lol");
    }
}
