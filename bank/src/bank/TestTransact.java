package bank;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class TestTransact {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/transact", new TransactHandler());
        server.createContext("/userinfo", new TransactHandler());
        server.createContext("/test_handler", new LoginHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
    
    // TO-DO
    // Get user info from USER table
    static class UserInfoHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
        	String request = t.getRequestURI().getQuery(); // Parsing is needed
            String response = "Response: ";
            t.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
    // TO-DO by Shaoxi
    // Perform a transaction on USER and TRANSACTION tables
    static class TransactHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
        	String request = t.getRequestURI().getQuery(); // Parsing is needed
        	
            String response = "Response: ";
            
            t.sendResponseHeaders(200, response.getBytes().length);
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
    
}