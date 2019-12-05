/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * File name:  PriorityQ.java
     * Authors: Joey Pereira, Cristian Ornelas
     *  Date          :  2019-12-05
     *  Description   :  See purpose
     *  Notes         :  None
     *  Warnings      :  None
     *  Exceptions    :  None
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
import java.util.*;
class PriorityQ {

  private int maxSize;
  private Heap qHeap;

public PriorityQ(int max) {
  maxSize = max;
  qHeap = new Heap(maxSize);
}

public int size(){
  return qHeap.getSize();
}

public void insert(int item) {
  qHeap.insert(item);
}

public int remove()
{
  return qHeap.getNodeKey(qHeap.remove());
}

public long peekMax() 
{
   return qHeap.getRoot();
}

public boolean isEmpty()
{
  return qHeap.getSize() == 0;
}

public boolean isFull()
{
  return qHeap.getSize() == maxSize;
}

public void displayQueue(){
  int[] nQueue = new int[qHeap.getSize()];
  for(int i = 0; i < qHeap.getSize(); i++){
    nQueue[i] = qHeap.getNodeKey( qHeap.getArray()[i]);
  }
  Arrays.sort( nQueue );
  for(int i = qHeap.getSize()-1; i >= 0; i --){
    System.out.print( nQueue[i] + " " );
  }
}

public static void main( String args[] ){
  PriorityQ priorityQue = new PriorityQ( 10 );
        System.out.println( "insert method" );
        priorityQue.insert( 10 );
        priorityQue.insert( 20 );
        priorityQue.insert( 40 );
        priorityQue.insert( 72 );
        priorityQue.insert( 36 );
        priorityQue.insert( 29 );
        System.out.print("Display Queue: ");
        priorityQue.displayQueue();

        System.out.println( "\nremove method" );
        System.out.println( "Remove: " + priorityQue.remove() );
        System.out.println( "Remove: " + priorityQue.remove() );
        System.out.println( "Remove: " + priorityQue.remove() );
        System.out.println( "Remove: " + priorityQue.remove() );
        System.out.println( "Remove: " + priorityQue.remove() );
        System.out.print("Display Queue: ");
        priorityQue.displayQueue();

       System.out.println( "\nisEmpty method" );
       priorityQue.insert( 13 );
       priorityQue.insert( 83 );
       priorityQue.insert( 45 );
       System.out.print("Display Queue: ");
       priorityQue.displayQueue();
       System.out.println( "\nEmpty? " + priorityQue.isEmpty()  );
       priorityQue.remove();
       System.out.println( "Empty? " + priorityQue.isEmpty()  );
       priorityQue.remove();
       System.out.println( "Empty? " + priorityQue.isEmpty()  );
       priorityQue.remove();
       System.out.println( "Empty? " + priorityQue.isEmpty() );
       priorityQue.remove();
       System.out.println( "Empty? " + priorityQue.isEmpty() );

       System.out.println( "\nisFull method" );
       priorityQue.insert( 20 );
       priorityQue.insert( 38 );
       System.out.print("Display Queue: ");
       priorityQue.displayQueue();
       System.out.println( "\nFull? " + priorityQue.isFull() );
       priorityQue.insert( 69 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 16 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 48 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 20 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 99 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 60 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 40 );
       System.out.println( "Full? " + priorityQue.isFull() );
       priorityQue.insert( 25 );
       System.out.println( "Full? " + priorityQue.isFull() );
       System.out.print("Display Queue: ");
       priorityQue.displayQueue();

    }
}
