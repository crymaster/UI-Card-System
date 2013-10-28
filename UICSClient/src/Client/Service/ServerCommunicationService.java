/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.Service;

import Client.Connection.ServerConnection;

/**
 *
 * @author Son
 */
public class ServerCommunicationService {
    private ServerConnection connection;

    public ServerConnection getConnection() {
        return connection;
    }

    public void setConnection(ServerConnection connection) {
        this.connection = connection;
    }
    
    public void send(Object data){
        this.connection.getSend().send(data);
    }
    
    public void close(){
        this.connection.disconnect();
    }
}
