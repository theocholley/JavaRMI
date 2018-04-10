package main.java;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Distante extends Remote{

    public void echo() throws RemoteException;

    public Resultat instance(int i) throws RemoteException;
}
