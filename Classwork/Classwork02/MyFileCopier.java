/** 
* File name: MyFileCopier.java
*/

import copiersupport.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MyFileCopier {
	public static void main (String []args) throws FileNotFoundException, IOException{
		System.out.println( "\n\n Welcome to the 'MyFileCopier' program. \n");
		Scanner myInput = new Scanner(System.in);

		System.out.print( "Please enter a file name: ");
		String sourceFileName = myInput.nextLine();
		SourceFile source = new SourceFile(sourceFileName);
		TargetFile target = new TargetFile(sourceFileName, source.readFile());

		source.closeFile();
	    target.closeFile();
	}
}
