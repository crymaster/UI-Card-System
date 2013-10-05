/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Son
 */
public class ServerConnection {
    //Client socket

    private static Socket clientSocket = null;
    //Port
    private static final int portNumber = 2222;
    //hostname
    private static final String host = "localhost";
    private static ListeningThread listen = null;
    private static SendingThread send = null;
    //Close signal
    private static Boolean closed = false;

    public static Socket getSocket() {
        return clientSocket;
    }

    public static void setSocket(Socket socket) {
        ServerConnection.clientSocket = socket;
    }

    public static ListeningThread getListen() {
        return listen;
    }

    public static void setListen(ListeningThread listen) {
        ServerConnection.listen = listen;
    }

    public static SendingThread getSend() {
        return send;
    }

    public static void setSend(SendingThread send) {
        ServerConnection.send = send;
    }

    public void connect() {
        try {
            clientSocket = new Socket(host, portNumber);
            listen.setInput(new ObjectInputStream(clientSocket.getInputStream()));
            send.setOutput(new ObjectOutputStream(clientSocket.getOutputStream()));
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch(ConnectException ex){
            
        }catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (clientSocket != null) {
            /* Create a thread to read from the server. */
            new Thread(listen).start();
        }
    }
    
    public void disconnect(){
        listen.close();
        send.close();
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}