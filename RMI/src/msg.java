
import java.rmi.Remote;
import java.rmi.RemoteException;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Budz
 */
public interface msg extends Remote
{
    public void sendMsg(String msg) throws RemoteException;

    public String getMsg(String msg) throws RemoteException;
}
