/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.tenebz.io;

import java.rmi.Remote;
import java.rmi.RemoteException;
import server.tenebz.beans.Message;

/**
 *
 * @author TOURE
 */
public interface ClientIO extends Remote {
    public void receive(Message msg) throws RemoteException;
}
