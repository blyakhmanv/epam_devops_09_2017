package main.java.com.epam.practice.WServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WServer {

    public static void main (String[] args) throws IOException {

            ServerSocket serverSocket = new ServerSocket ( 10_000 );

            while (true) {

                try (Socket clientSocket = serverSocket.accept ( )) {
                    HttpProcessorModule httpProcessor = new HttpProcessorModule ( );
                    httpProcessor.process ( clientSocket );
                } catch (IOException e) {
                    e.printStackTrace ( );
                }
            }
        }
    }

