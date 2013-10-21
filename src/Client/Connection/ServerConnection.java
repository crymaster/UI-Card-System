/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Connection;

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
    private ListeningThread listen = null;
    private Sending send = null;
    //Close signal
    static Boolean closed = false;

    public static Socket getSocket() {
        return clientSocket;
    }

    public static void setSocket(Socket socket) {
        ServerConnection.clientSocket = socket;
    }

    public ListeningThread getListen() {
        return listen;
    }

    public void setListen(ListeningThread listen) {
        this.listen = listen;
    }

    public Sending getSend() {
        return send;
    }

    public void setSend(Sending send) {
        this.send = send;
    }

    public void connect() {
        while (true) {
            try {
                clientSocket = new Socket(host, portNumber);
                listen.setInput(new ObjectInputStream(clientSocket.getInputStream()));
                send.setOutput(new ObjectOutputStream(clientSocket.getOutputStream()));
                break;
            } catch (UnknownHostException ex) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ConnectException ex) {
                //Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
                continue;
            } catch (IOException ex) {
                Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (clientSocket != null) {
            /* Create a thread to read from the server. */
            new Thread(listen).start();
        }
        this.listen.getControllerManager().getLogInController().connected();
    }

    public void disconnect() {
        listen.close();
        send.close();
        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(ServerConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        closed = true;
    }
}