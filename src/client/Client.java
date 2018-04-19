package client;

import server.IServer;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {

    private Client() {
    }

    public static void main(String[] args) {
        IServer Server;
        boolean sub;

        try {
            Server = (IServer) Naming.lookup("rmi://localhost/Server");
            System.out.println("Subscription...");
            IClient IClient = new HookClient();
            Server.subscribe(IClient);
            System.out.println("Subscription OK");
            sub=true;
            System.out.println("Tapez 1 pour unsubscribe");

            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            while(sub){
                if(i==1) {
                    Server.unSubscribe(IClient);
                    System.out.println("Unsubscribing...");
                    sub=false;
                    System.out.println("Unsubscribing OK");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}