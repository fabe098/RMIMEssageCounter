
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Budz
 */
public class client 
{
    public static void main(String args[]) throws RemoteException
    {
        /*
        Using scanner to receive input then sends it to the server
        */
        Scanner myObj = new Scanner(System.in);

    System.out.println("Enter your message: ");
    
        String text = "";
                text = myObj.nextLine();
        msg rmi = null;

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            rmi = (msg) registry.lookup("server");
            System.out.println("Connected to Server");
        } catch (NotBoundException | RemoteException e) {
        }
        if (rmi != null) {
            try {
                /**
                 * sends the message to the server 
                 */
                rmi.sendMsg(text);
                
                /**
                 * Receives the value for the Character counter
                 */
                System.out.println(rmi.getMsg(text));
            } catch (RemoteException e) {
            }
            System.out.println("Finished");
        }
    }
}

 

