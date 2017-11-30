package main.java.com.epam.practice.WServer;

import java.io.BufferedWriter;


public class HttpResponseModule implements HttpResponse {

    String protocol;
    ResponseCode responseCode;
    private final BufferedWriter output;


    HttpResponseModule (BufferedWriter out) {
        this.output = out;
    }

    @Override
    public void setProtocol (String protocol) {
        this.protocol = protocol;

    }

    @Override
    public void setResponseCode (ResponseCode code) {
        this.responseCode = code;

    }

    @Override
    public void setHeader (String name, String value) {

    }

    @Override
    public void setServerHeader (String value) {

    }

    @Override
    public void setContentType (String value) {

    }

    @Override
    public void setContentLength (String value) {

    }

    @Override
    public BufferedWriter getOutputStream () {
        return this.output;
    }
}
