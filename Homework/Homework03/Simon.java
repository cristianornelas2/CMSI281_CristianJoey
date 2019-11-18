/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *  File name:  Simon.java
     *  Authors: Joey Pereira, Cristian Ornelas
     *  Date:  2019-17-07
     *  Notes:  None
     *  Warnings:  None
     *  Exceptions:  None
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
import java.util.*;

class Simon {
    public static void main (String[] args) {
        Character[] ints  = {'G', 'R', 'Y', 'B', 'O'};

        String seq = "";
        String backSpace = "";
        boolean answer = true;
        Scanner newScanner = new Scanner(System.in);
        String answerIn = "";
        while ( answer ) {
            int addChar = (int)(Math.floor( Math.random() * 4 ));
            seq += ints[addChar];
            backSpace += "\b";
            System.out.println( "The Sequence: " );
            for ( char color : seq.toCharArray() ) {
                System.out.print( color );
                backSpace += "\b";
                try {
                    Thread.sleep( 1000 );
                }
                catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.print( backSpace );
            System.out.print("\n Repeat the sequence as shown above: " );
            answerIn = newScanner.next();
            if ( answerIn.equals(seq) ) {
                answer = true;
            }
            else {
                answer = false;
                System.out.println( "INNCORRECT!" + "\n" + "THE SEQUENCE WAS: " + seq);
                System.out.println( "YOU ENTERED:" + answerIn);
            }
        }
    }
}
