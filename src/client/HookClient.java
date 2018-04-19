package client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HookClient extends UnicastRemoteObject implements IClient, Serializable {
    protected HookClient() throws RemoteException {
    }

    @Override
    public void display(String s) {
        System.out.println(s);
    }
}
