package main.java.com.epam.practice.WServer;

import java.io.BufferedInputStream;
import java.io.IOException;

public class WebServerModule implements WebServer {
    @Override
    public void service (HttpRequest request, HttpResponse response) throws IOException {
        response.setProtocol ( "HTTP/1.1" );

      ClassLoader classloader = ClassLoader.getSystemClassLoader ();
        System.out.println (request.getURI () );
       try {
           BufferedInputStream bis = new BufferedInputStream ( classloader.getResourceAsStream(request.getURI ().substring ( 1 )));
           System.out.println (bis.available ());
           response.getOutputStream ().write ( "HTTP/1.1 200 OK\r\n" );
           response.getOutputStream ().write ( "\r\n" );
           response.getOutputStream ().write ( "\r\n" );
           while (bis.available ()>0) {

           response.getOutputStream ().write( (bis.read ( )));
           response.getOutputStream ().flush ();

           }
       }
       catch (IOException e) {
           response.getOutputStream ().write ( "HTTP/1.1 400  Bad request\r\n" );
           response.getOutputStream ().write ( "\r\n" );
           response.getOutputStream ().write ( "\r\n" );

           response.getOutputStream ().flush ();
           }

    }
}
