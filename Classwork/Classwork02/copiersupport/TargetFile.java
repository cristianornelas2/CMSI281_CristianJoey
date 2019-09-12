/** 
* File name: TargetFile.java
* Purpose: write out a copy of the input file
*/

package copiersupport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TargetFile {
	private FileWriter writer;
	private String fileTarget;

	public TargetFile(String in, String out) throws FileNotFoundException, IOException {
		fileTarget = "Copy of " + in;
		writer = new FileWriter(fileTarget);
		writeFile(out);
	}

	public void writeFile(String writing) throws FileNotFoundException, IOException {
		writer.write(writing);
	}

	public void closeFile() throws FileNotFoundException, IOException {
		writer.close();
		System.out.println(fileTarget + " : shutting down");
	}	
}
