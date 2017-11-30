package main.java.com.epam.practice.WServer;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestModule implements HttpRequest {
    private final Method method;
    private final String uri;
    private final String protocol;
    private BufferedReader input;
    private HashMap<String,String> headers;

    public HttpRequestModule (Method method, String uri, String protocol, BufferedReader input) {
        headers = new HashMap ();
        String[] header;
        this.method = method;
        this.uri = uri;
        this.protocol = protocol;
        try {
          while (input.ready ()) {
               header =  input.readLine ().split ( ": " );
               if ( header.length!=1) {headers.put ( header[0],header[1] );}
              }

        } catch (IOException e) {
             e.printStackTrace ( );
        }

    }


    @Override
    public Method getMethod () {
        return method;
    }

    @Override
    public String getURI () {
        return uri;
    }

    @Override
    public String getProtocol () {
        return protocol;
    }

    @Override
    public Map<String, String> getHeaders () {
        return headers;
    }

    @Override
    public String getHeader (String header) {
        return null;
    }

    @Override
    public BufferedReader getInputStream () {
        return input;
    }
}
