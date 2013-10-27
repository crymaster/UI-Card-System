/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Thread;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ClientListeningThread extends Thread{
    private static int port;
    ServerSocket serverSocket;
    @Override
    public void run() {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("./config/Connection.properties"));
            port = Integer.parseInt(prop.getProperty("serverPort", "2222"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            
        }
        try {
            serverSocket= new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                ClientHandlingThread t = new ClientHandlingThread(socket);
                t.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ClientListeningThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
