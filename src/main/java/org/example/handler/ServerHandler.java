package org.example.handler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerHandler {

    private ServerSocket serverSocket;
    private Socket socket;
    private static ServerHandler serverHandler;
    private ArrayList<ClientHandler> clients = new ArrayList<>();

    private ServerHandler() throws IOException {
        serverSocket = new ServerSocket(6509);
        System.out.println("Server started on port 6509");
    }

    public static ServerHandler getInstance() throws IOException {
        System.out.println("ServerHandler.getInstance()");
        return serverHandler != null ? serverHandler : (serverHandler = new ServerHandler());

    }

    public void makeSocket() {
        System.out.println("ServerHandler.makeSocket()");
        while (!serverSocket.isClosed()) {
            try {
                socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, clients);
                clients.add(clientHandler);
                System.out.println("client socket accepted " + socket.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeServer() {
        System.out.println("ServerHandler.closesocket()");
        try {
            socket.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
