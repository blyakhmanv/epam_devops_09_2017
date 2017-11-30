package main.java.com.epam.practice.WServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Map;

public interface HttpRequest {

    Method getMethod ();
    String getURI ();
    String getProtocol ();
    Map<String, String> getHeaders ();
    String getHeader (String header);
    BufferedReader getInputStream ();

    enum Method {
        GET,
        POST,
        PUT,
        DELETE,
        UPDATE
    }
}
