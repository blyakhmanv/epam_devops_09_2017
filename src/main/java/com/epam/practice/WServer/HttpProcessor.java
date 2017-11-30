package main.java.com.epam.practice.WServer;

import java.net.Socket;

public interface HttpProcessor {

    void process (Socket socket);
}
