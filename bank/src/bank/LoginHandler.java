package bank;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class LoginHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange arg0) throws IOException {
		// TODO Auto-generated method stub
		System.out.println(arg0.getRequestMethod() + "\r\n");
		InputStream in = arg0.getRequestBody();
		int i = in.available();
		if (i > 0) {
			byte[] btBuffer = new byte[i];
			int iRead = in.read(btBuffer, 0, btBuffer.length);
			i = i = iRead;
			System.out.println(new String(btBuffer) + "\r\n");
		}
		// Solution to Access-Control-Allow-Origin error
		arg0.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
		if (arg0.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
			arg0.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
			arg0.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
			arg0.sendResponseHeaders(200, -1);
            return;
        }
		System.out.println("reading finsihed");
		String response = "The message has successfully received by server";
        arg0.sendResponseHeaders(200, response.length());
        OutputStream os = arg0.getResponseBody();
        os.write(response.getBytes());
        os.close();
	}
}