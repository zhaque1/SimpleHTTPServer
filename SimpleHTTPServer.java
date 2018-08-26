
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket; // setting up a web server with java serverSocket class
import java.net.Socket; // for blocking method accept() to wait and accept a connection from a client
import java.util.Date;

/*
 *  Zayd Haque
 *  Simple HTTP Server 
 *  -------------- NOTES -------------------------
 *  the first two lines and the loop is all thats needed to set up a web server, but the server is just waiting 
 *  for a connection, the inf loop allows the program to keep running but again the server is just waiting for a 
 *  connection
 *  
 * - HTTP is state less, it doesnt remeber previous connections, all it cares about are new incoming connects
 *  
 *  when compiled the program will recieve a GET response from the browser, but as of right now, the there is no
 *  response back yet
 *  
 *  1st - Read HTTP request from client socket 
 *	2nd - Prep a HTTP response
 *	3rd - Send the HTTP response to client
 *	4th - close the socket (auto closes with try)
 *  
 *  responds to client with todays date
 *  
 *   --- HOW TO CLOSE SOCKET PROPERLY ???? -----
 *  
 */
public class SimpleHTTPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ServerSocket server = new ServerSocket(8079);
		System.out.println("Listening for connection on port 8079......");
		while(true){
			
			
			Socket clientSocket = server.accept();
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader reader = new BufferedReader(isr);
			String line = reader.readLine();
			while(!line.isEmpty()){
				
				System.out.println(line);
				line = reader.readLine();
				
			}
			Date today = new Date();
			String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
			clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			
			
			
			
		}
		
	
	
	}

}
