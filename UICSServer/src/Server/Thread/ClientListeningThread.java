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
public class ClientListeningThread extends Thread {

    private static int port;
    ServerSocket serverSocket;

    @Override
    public void run() {
        Properties prop = new Properties();
        try {
            //load serverport from Connection.properties
            prop.load(new FileReader("./config/Connection.properties"));
            port = Integer.parseInt(prop.getProperty("serverPort", "2222"));
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                //Listen for connection and create new thread if a client connects 
                Socket socket = serverSocket.accept();
                ClientHandlingThread t = new ClientHandlingThread(socket);
                t.start();
            }

        } catch (IOException ex) {
        }
    }
}
