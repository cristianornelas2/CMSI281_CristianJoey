/** 
* File name: SourceFile.java
* Purpose: write out a copy of the input file
*/

package copiersupport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import  java.io.FileNotFoundException;

public class SourceFile {
	private FileReader reader;
	private String fileSource;
	private String s;
	private int c;

	public SourceFile (String inPath) throws FileNotFoundException, IOException {
		fileSource = inPath;
		reader = new FileReader(inPath);
	}

	public String readFile() throws FileNotFoundException, IOException{
		while(c != -1) {
  	       		c = reader.read();
  	       		s += (char)c;
			}
			return s;
	}

	public void closeFile() throws FileNotFoundException, IOException{
		reader.close();
		System.out.println(fileSource + " : shutting down");
	}
}
