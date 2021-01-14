import java.net.*;
import java.io.*;
public class ContentsClient   
{
  public static void main( String args[ ] ) throws Exception
  {
     Socket sock = new Socket( "127.0.0.1", 4000);//Creating Socket
 
                   // reading the file name from keyboard. Uses input stream
     System.out.println("Enter the file name:");
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
     String fname = keyRead.readLine();
                                         
	        // sending the file name to server. Uses PrintWriter
     OutputStream  ostream = sock.getOutputStream( );
     PrintStream pwrite = new PrintStream(ostream);
     pwrite.println(fname);            
          	          // receiving the contents from server.  Uses input stream
     InputStream istream = sock.getInputStream();
     BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
 System.out.println("\nContents of the file:");
     String str;
     while((str = socketRead.readLine())  !=  null) // reading line-by-line 
     { 
         System.out.println(str);          
     } 
     pwrite.close(); socketRead.close(); keyRead.close();
  }
}