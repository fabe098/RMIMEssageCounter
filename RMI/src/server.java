
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Budz
 */
public class server implements msg
{
    /**
     * 
     * prints the client input into the server
     * 
     */
     @Override
    public void sendMsg(String s) throws RemoteException {
        System.out.println(s);
    }
    
    /**
     * The counter for the message
     * then sends the value back to the client 
     */
    @Override
    public String getMsg(String text) throws RemoteException {
        int count = 0;
        /*
         using for loop to count the number of characters in the
        */
         for(int i = 0; i < text.length(); i++) {    
            
            if(text.charAt(i) != ' ')    
                count++;    
        }  
         
        return "Character count is: " + count ;
    }
   public static void main(String[] args) {
        Registry reg = null;
        try {
            reg = LocateRegistry.createRegistry(1234);
        } catch (RemoteException e) {
            System.out.println("Could not create the registry.");
        }
        server serverObject = new server();
        System.out.println("Waiting for client...");
        System.out.println("Client input/s:");
        try {
            reg.rebind("server", (msg) UnicastRemoteObject.exportObject(serverObject, 0));
        } catch (RemoteException e) {
            System.out.println("Failed to register the server object.");
        }
    }
}

