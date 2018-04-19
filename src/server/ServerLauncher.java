package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerLauncher {

    public static void main(String[] args) {
        try {
            Server Server = new Server();
            LocateRegistry.createRegistry(1099);
            Registry r = LocateRegistry.getRegistry();
            r.bind("ClientManager", Server);
            String url = "rmi://localhost/Server";
            Naming.rebind(url, Server);
            System.out.println("Serveur prêt, attente de connexion...");

            while (true) {
                FileReader fileReader = new FileReader("src/file.txt");

                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line = null;

                Server.send("\n");

                while ((line = bufferedReader.readLine()) != null) {
                    Thread.sleep(3000);
                    Server.send(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
