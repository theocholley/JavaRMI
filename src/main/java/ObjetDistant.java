package main.java;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant extends UnicastRemoteObject implements Distante {

    protected ObjetDistant(int port) throws RemoteException {
        super(port);
    }

    public static void main(String[] args) {
        ObjetDistant objetDistant = null;
        try {
            objetDistant = new ObjetDistant(8001);
            Registry registry = LocateRegistry.createRegistry(8001);
            registry.rebind("Distante", objetDistant);
            String url = "rmi://localhost:8001/testRmi";
            Naming.rebind(url, objetDistant);
            objetDistant.echo();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void echo() throws RemoteException {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello World!");
    }

    @Override
    public Resultat instance(int i) throws RemoteException {
        return new Resultat();
    }


}
