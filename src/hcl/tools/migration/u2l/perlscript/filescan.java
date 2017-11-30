package hcl.tools.migration.u2l.perlscript;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/*import java.io.ObjectInputStream;
import java.io.Reader;*/
import java.io.StreamTokenizer;

public class filescan 
{

	public static void main(String args[])
	   {
		
		 /* try
		  {
		  // Open the file that is the first 
		  // command line parameter
		  FileInputStream fstream = new FileInputStream("sample.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)   
				  {
				  // Print the content on the console
				  System.out.println (strLine);
				  }
		  //Close the input stream
		  in.close();
		   }catch (Exception e){//Catch exception if any
		  System.err.println("Error: " + e.getMessage());
		   }*/
		
		try
		{
		
		/*// create an ObjectInputStream for the file we created before
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("sample.txt"));

        // create a new tokenizer
        Reader r = new BufferedReader(new InputStreamReader(ois));*/
        FileInputStream fstream = new FileInputStream("sample.txt");
		  // Get the object of DataInputStream
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
		  StreamTokenizer st = new StreamTokenizer(br);

        // print the stream tokens
        boolean eof = false;
        
        do {
           int token = st.nextToken();
           
           switch (token) {
              case StreamTokenizer.TT_EOF:
                 System.out.println("End of File encountered.");
                 eof = true;
                 break;
                 
              case StreamTokenizer.TT_EOL:
                 System.out.println("End of Line encountered.");
                 break;
                 
              case StreamTokenizer.TT_WORD:
                 System.out.println("Word: " + st.sval);
                 break;
                 
              case StreamTokenizer.TT_NUMBER:
                 System.out.println("Number: " + st.nval);
                 break;
                 
              default:
                 System.out.println((char) token + " encountered.");
                 
                 if (token == '!') {
                    eof = true;
                 }
           }
        } while (!eof);

     } catch (Exception ex) {
        ex.printStackTrace();
     }

	   }
	 

}
