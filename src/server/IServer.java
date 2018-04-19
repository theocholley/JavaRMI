package server;

import client.IClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {

    void subscribe(IClient client) throws RemoteException;

    void unSubscribe(IClient client) throws RemoteException;
}
