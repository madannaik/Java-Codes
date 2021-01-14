import java.net.*;    
import java.io.*;
public class ContentsServer   
{
  public static void main(String args[]) throws Exception
  {                           // establishing the connection with the server
     ServerSocket sersock = new ServerSocket(4000);
     System.out.println("Server ready for connection");
     Socket sock1 = sersock.accept();            // binding with port: 4000
     System.out.println("Connection is successful and wating for chatting");
                                                                                                 
                               // reading the file name from client
     InputStream istream = sock1.getInputStream( );
     BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
     String fname = fileRead.readLine( );
                             // reading file contents
     BufferedReader contentRead = new BufferedReader(new FileReader(fname) );
			           
                           // keeping output stream ready to send the contents
    // OutputStream ostream = sock1.getOutputStream( );
     PrintStream pwrite = new PrintStream(sock1.getOutputStream( ));
    
     String str;


     while((str = contentRead.readLine()) !=  null) // reading line-by-line from file
     {
	pwrite.println(str);         // sending each line to client
     }

System.out.println("\nContents of file is sent...");
     sock1.close();  sersock.close();       // closing network sockets
     pwrite.close();  fileRead.close(); contentRead.close();
 
  }
}