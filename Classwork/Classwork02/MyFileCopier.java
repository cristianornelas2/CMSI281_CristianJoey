
/** 
* File name: MyFileCopier.java
* Purpose: write out a copy of the input file
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




	/*private static String sourceFileName;
	private static String targetFileName;
	private static final File target;


	public MyFileCopier()  {
	System.out.println( "\n\n Welcome to the 'MyFileCopier' program. \n");
	Scanner myInput = new Scanner (System.in );


	System.out.print( "Please enter a file name: ");
	String sourceFileName = myInput.nextLine();
	source = new File(sourceFileName);
	SourceFile sf = new SourceFile(sourceFileName);


	TargetFile tf = new TargetFile(sourceFileName, sf.readFile());

	sf.closeFile();
	tf.closeFile();
	}
}
*/
