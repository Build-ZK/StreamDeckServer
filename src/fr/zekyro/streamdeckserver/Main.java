package fr.zekyro.streamdeckserver;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {
        Executor executor = Executors.newSingleThreadExecutor();
        HttpServer server = HttpServer.create(new InetSocketAddress("127.0.0.1", 25565), 0);
        server.createContext("/request", new CommandHttpHandler());
        server.setExecutor(executor);
        server.start();
        System.out.println("Server started !");
    }
}
