/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.tenebz.core;

import client.tenebz.io.ClientIO;
import client.tenebz.view.ChatView;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.tenebz.beans.Client;
import server.tenebz.beans.Message;
import server.tenebz.io.TenebzIO;

/**
 *
 * @author TOURE
 */
public class ClientIOImp extends UnicastRemoteObject implements ClientIO {
    
    Client client;
    ChatView chat;
    TenebzIO server;
    
    public ClientIOImp(Client client, ChatView chat, TenebzIO server) throws RemoteException {
        this.client = client;
        this.chat = chat;
        this.server = server;
    }

    @Override
    public void receive(Message msg) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
