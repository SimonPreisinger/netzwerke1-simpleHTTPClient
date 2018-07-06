import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.Buffer;

public class SimpleHTTPClient {
    public static void main(String... args) throws Exception {
        Socket clientSocket;
        BufferedReader fromServer;
        BufferedWriter toServer;
        final String HOST = "simonpreisinger.de";

        clientSocket = new Socket(HOST, 80);
        toServer = new BufferedWriter(new OutputStreamWriter(
                clientSocket.getOutputStream()));

        toServer.write("GET / HTTP/1.1\r\nHost: " + HOST + "\r\n\r\n");
        toServer.flush();

        fromServer = new BufferedReader(new InputStreamReader(
                clientSocket.getInputStream()));

        System.out.println(fromServer.readLine());

        toServer.close();
        fromServer.close();
        clientSocket.close();
    }
}
