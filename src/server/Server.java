package server;

import client.IClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Server extends UnicastRemoteObject implements IServer {

    private List<IClient> IClients = new ArrayList<>();
    private int cpt = 0;

    Server() throws RemoteException {
    }

    public void send(String s) throws RemoteException {
        for (IClient iClient : IClients) {
            (iClient).display(s);
        }
    }

    public void subscribe(IClient client) {
        System.out.println("Un client a rejoint le serveur : "+ ++cpt +" client(s) en ligne");
        this.IClients.add(client);
    }

    public void unSubscribe(IClient client) {
        System.out.println("Un client a quitté le serveur : "+ --cpt + " client(s) en ligne");
        this.IClients.remove(client);
    }

}