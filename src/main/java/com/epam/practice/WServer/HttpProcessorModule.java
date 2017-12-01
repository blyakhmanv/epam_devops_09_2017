package main.java.com.epam.practice.WServer;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpProcessorModule implements HttpProcessor {
    @Override
    public void process (Socket socket) {
        try {
            BufferedReader in = new BufferedReader ( new InputStreamReader ( socket.getInputStream ( ), StandardCharsets.UTF_8 ) );
            BufferedWriter out = new BufferedWriter ( new OutputStreamWriter ( socket.getOutputStream ( ) ) );
            String start = in.readLine ( );
            String[] peaces = start.split ( " " );

            try {
                HttpRequest.Method method = HttpRequest.Method.valueOf ( peaces[ 0 ] );
                final HttpRequestModule httpRequest = new HttpRequestModule (method,peaces[1],peaces[2],in );
                HttpResponseModule httpResponse = new HttpResponseModule(out);
                WebServer webServer = new WebServerModule ( ) ;
                webServer.service ( httpRequest,httpResponse );

                } catch (IllegalArgumentException e) {
                System.out.println ("bad" );
                out.write("HTTP/1.1 400 Bad Request\r\n");
                out.flush ();
            }   catch (IOException e) {
            e.printStackTrace ( );
        }
    } catch (IOException e) {
            e.printStackTrace ( );
        }

    }



}

