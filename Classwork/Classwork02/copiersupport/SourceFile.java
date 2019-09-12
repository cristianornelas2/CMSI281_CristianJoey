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
		System.out.println(fileSource + "is closing");
	}
}






	/* private File source;
	public File target;
	private FileReader reader;
	private FileWriter writer;

	public SourceFile (String inPath, String outPath){
        source = new File(inPath);
        target = new File(outPath);
		

		if(source.canRead(){
			reader = new FileReader(source);
			writer = new FileWriter(target);
			int c;
			while((c = reader.read()) != -1) {
  	       		writer.write(c);
			}
		}
		
		if( reader != null) {
			reader.close();
		} 
		if( writer != null) {
			writer.close();
		}
	}
}
*/
