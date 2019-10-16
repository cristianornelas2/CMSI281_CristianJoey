
 /**
     * Editors: Joey Pereira, Cristian Ornelas
     * Function: Deque Class that allows the user to insert and remove elements
 **/
public class Deque {
    private int maxSize;
    private long[] dArray;
    private int front;
    private int back;
    private int nElems;


    public Deque( int s ) {
        maxSize = s;
        dArray = new long[maxSize];
        front = 0;
        back = -1;
        nElems = 0;
    }


    public void insertLeft( long d ) {
        if ( front == 0 ) {
            front = maxSize;
        }
       dArray[--front] = d;
        nElems++;
    }


    public void insertRight( long d ) {
        if ( back == maxSize-1 ) { 
            back = -1;
        }
       dArray[++back] = d;    
        nElems++;            
    }


    public long removeLeft() {
        long temp = dArray[front++]; 
        if ( front == maxSize ) {        
            front = 0;
        }
        nElems--;                   
        return temp;
    }


    public long removeRight() {
        long temp = dArray[back--]; 
        if ( back == -1 ) {                
            back = maxSize-1;
        }
        nElems--;                       
        return temp;
    }


    public boolean isEmpty() {
        return ( nElems == 0 );
    }


    public boolean isFull() {
        return ( nElems == maxSize );
    }


    public void display() {
        int index = front;
        for ( int count = 0; count < nElems; count++ ) {
            System.out.print(dArray[index] + " " );
            if ( index == maxSize - 1 ) {   
                index = 0;
            }
            else {
                index++;
            }
        }
        System.out.println();
    }

    public static void main( String args[] ) {

    	Deque newDeque = new Deque(10);

    	System.out.println("------------TESTING FOR insertLeft()------------");
    	newDeque.insertLeft(5);
    	System.out.println("inserting 5");
    	newDeque.insertLeft(4);
    	System.out.println("inserting 4");
    	newDeque.insertLeft(3);
    	System.out.println("inserting 3");
    	newDeque.insertLeft(2);
    	System.out.println("inserting 2");
    	newDeque.insertLeft(1);
    	System.out.println("inserting 1");
    	System.out.println("DEQUE LIST AFTER INSERT LEFT : "); 
    	newDeque.display();
    	System.out.println();

    	System.out.println("------------TESTING FOR insertRight()------------");
    	newDeque.insertRight(6);
    	System.out.println("inserting 6");
    	newDeque.insertRight(7);
    	System.out.println("inserting 7");
    	newDeque.insertRight(8);
    	System.out.println("inserting 8");
    	newDeque.insertRight(9);
    	System.out.println("inserting 9");
    	newDeque.insertRight(10);
    	System.out.println("inserting 10");
    	System.out.println("DEQUE LIST AFTER INSERT RIGHT : "); 
    	newDeque.display();
    	System.out.println();

    	System.out.println( "---------------TESTING isFull() AND isEmpty()---------------");
        System.out.println("IS THE DEQUE FULL ? : " + newDeque.isFull());
        System.out.println("Correct Answer: true");
        System.out.println("IS THE DEQUE EMPTY ? : " + newDeque.isEmpty());
        System.out.println("Correct Answer: false");
        System.out.println();

    	System.out.println( "---------------TESTING removeLeft() AND removeRight()---------------");
        newDeque.removeLeft();
        System.out.println( "removing left" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeLeft();
        System.out.println( "removing left" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeLeft();
        System.out.println( "removing left" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeRight();
        System.out.println( "removing right" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeRight();
        System.out.println( "removing right" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeRight();
        System.out.println( "removing right" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        System.out.println();

        System.out.println( "---------------TESTING isFull() AND isEmpty()---------------");
        System.out.println("IS THE DEQUE FULL ? : " + newDeque.isFull());
        System.out.println("Correct Answer: false");
        System.out.println("IS THE DEQUE EMPTY ? : " + newDeque.isEmpty());
        System.out.println("Correct Answer: false");
        System.out.println();

        System.out.println( "---------------TESTING removeLeft() AND removeRight()---------------");
        newDeque.removeLeft();
        System.out.println( "removing left" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeLeft();
        System.out.println( "removing left" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeRight();
        System.out.println( "removing right" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        newDeque.removeRight();
        System.out.println( "removing right" );
        System.out.print( "DEQUE LIST: ");
        newDeque.display();
        System.out.println();

        System.out.println( "---------------TESTING isFull() AND isEmpty()---------------");
        System.out.println("IS THE DEQUE FULL ? : " + newDeque.isFull());
        System.out.println("Correct Answer: false");
        System.out.println("IS THE DEQUE EMPTY ? : " + newDeque.isEmpty());
        System.out.println("Correct Answer: true");
        System.out.println();

    }

}

