/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;
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
    private static int portNumber;
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
        Properties prop = new Properties();
        InetAddress address = null;
        try {
            //load serverip and serverport from .properties file
            prop.load(new FileReader("./config/Connection-client.properties"));
            address = Inet4Address.getByName(prop.getProperty("serverip", "127.0.0.1"));
            portNumber = Integer.parseInt(prop.getProperty("serverPort", "2222"));
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        while (true) {
            try {
                //try to connect to server
                clientSocket = new Socket(address, portNumber);
                listen.setInput(new ObjectInputStream(clientSocket.getInputStream()));
                send.setOutput(new ObjectOutputStream(clientSocket.getOutputStream()));
                break;
            } catch (UnknownHostException ex) {
            } catch (ConnectException ex) {
                continue;
            } catch (IOException ex) {
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
        }
        closed = true;
    }
}