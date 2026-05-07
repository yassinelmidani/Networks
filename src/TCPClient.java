import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception
{
String sentence;
String modifiedSentence;

//input stream to read from the user
BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

//Create client socket, connect to serve
Socket clientSocket = new Socket("localhost", 6789);

//Create output stream attached to socket
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream()); 
 
//input stream attatched to socket
BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
sentence = inFromUser.readLine();

//send sentence to server
outToServer.writeBytes(sentence + '\n');

//read  sentence from server
modifiedSentence = inFromServer.readLine();
System.out.println("FROM SERVER: " + modifiedSentence);
clientSocket.close();
}
}


