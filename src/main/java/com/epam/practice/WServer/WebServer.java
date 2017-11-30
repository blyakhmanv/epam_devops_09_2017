package main.java.com.epam.practice.WServer;

import java.io.IOException;

public interface WebServer {

    void service (HttpRequest request, HttpResponse response) throws IOException;
}
