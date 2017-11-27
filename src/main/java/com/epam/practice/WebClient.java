package main.java.com.epam.practice;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class WebClient {

    public static void main (String[] args) throws IOException {
        //Get user input
        String userinput;
        Scanner reader = new Scanner ( System.in );
        while (true) {
            System.out.println ( "Enter a string: " );
            userinput = reader.nextLine ( );
            if ( userinput.length ( ) > 0 )
                break;
        }
        reader.close ( );

        try (Socket socket = new Socket ( "localhost", 10_000 ) ;
             BufferedWriter out = new BufferedWriter ( new OutputStreamWriter ( socket.getOutputStream ( ) ) ) ;

             BufferedReader in = new BufferedReader ( new InputStreamReader ( socket.getInputStream ( ) ) )) {
            out.write (userinput+"\n" );
            out.flush ( );
            //System.out.println ( "From server: " + in.readLine ( ) );
            char[] b = new char[1024];
            while (in.read(b) != -1) {
                System.out.print (b );
                in.read(b);

            }
        }

    }

}
