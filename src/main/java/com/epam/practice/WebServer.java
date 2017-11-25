package main.java.com.epam.practice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10_000);

            while (true) {
                try (Socket clientSocket = serverSocket.accept() ;
                     BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream())) ;
                     BufferedWriter out = new BufferedWriter(new OutputStreamWriter (clientSocket.getOutputStream()))) {
                     String path = in.readLine();
                    System.out.println (path );
                     ClassLoader classloader = ClassLoader.getSystemClassLoader ();
                     try {
                        BufferedInputStream bis = new BufferedInputStream ( classloader.getResourceAsStream(path));
                        while (bis.available ()>0) {
                        out.write( (bis.read ( )));
                        }

                     } catch (IOException e) {
                        out.write ( "File not found");
                     }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
