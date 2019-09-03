// SayHello.java
// demonstrates basic intro Java syntax
// to run this program: C>java SayHello
////////////////////////////////////////////////////////////////
import java.util.Scanner;

public class SayHello {
	public static void main (String[]args){
		System.out.println("Hello, World!");

		Scanner myInput = new Scanner( System.in );
		System.out.println("Enter your name below:");

		String inputName = myInput.nextLine();
		System.out.println("Hello, " + inputName + "!");
	}
}
