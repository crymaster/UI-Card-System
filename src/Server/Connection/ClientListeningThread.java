/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ClientListeningThread extends Thread{
    private static final int port = 2222;
    ServerSocket serverSocket;
    @Override
    public void run() {
        try {
            serverSocket= new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                ClientThread t = new ClientThread(socket);
                t.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
