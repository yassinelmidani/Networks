import java.io.*;
import java.net.*; 

public class TCPServer {
public static void main(String argv[]) throws Exception
{
String clientSentence;
String capitalizedSentence;

//create welcoming socket at port 6789
ServerSocket welcomeSocket = new ServerSocket(6789);

while(true) {

 //wait on welocoming socket for a connection request(contact) from client 
Socket connectionSocket = welcomeSocket.accept();

//create input stream attached to socket
BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

//create output stream attached to socket
DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

//read in line from socker and convert to upper case
clientSentence = inFromClient.readLine();
capitalizedSentence = clientSentence.toUpperCase() + '\n';
outToClient.writeBytes(capitalizedSentence);
}
}
}
