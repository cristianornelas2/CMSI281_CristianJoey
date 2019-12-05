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

////////////////////////////////////////////////////////////////
class Node {
  private int iData;             // data item (key)
  // -----------------------------------------------------------
  public Node(int key)           // constructor
  { iData = key; }
  // ------------------------------------------------------------
  public int getKey()
    { return iData; }
  // ------------------------------------------------------------
  public void setKey(int id)
    { iData = id; }
    // ------------------------------------------------------------
  }  // end class Node
  ////////////////////////////////////////////////////////////////
  class Heap {
    private Node[] heapArray;
    private int maxSize;           // size of array
    private int currentSize;       // number of nodes in array
    // ------------------------------------------------------------
    public Heap(int mx)            // constructor
    {
      maxSize = mx;
      currentSize = 0;
      heapArray = new Node[maxSize];  // create array
    }
    // ------------------------------------------------------------
    public boolean isEmpty()
    { return currentSize==0; }
    // ------------------------------------------------------------

    public int getSize(){
      return currentSize;
    }


    public boolean insert(int key)
    {
      if(currentSize==maxSize) return false;
      Node newNode = new Node(key);
      heapArray[currentSize] = newNode;
      trickleUp(currentSize++);
      return true;
    }  // end insert()
    // ------------------------------------------------------------
    public void trickleUp(int index)
    {
      int parent = (index-1) / 2;
      Node bottom = heapArray[index];
      while( index > 0 && heapArray[parent].getKey() < bottom.getKey() )
      {
        heapArray[index] = heapArray[parent];  // move it down
        index = parent;
        parent = (parent-1) / 2;
      }  // end while
      heapArray[index] = bottom;
    } // end trickleUp()
    // ------------------------------------------------------------
    public Node remove()           // delete item with max key
    {                           // (assumes non-empty list)
      Node root = heapArray[0];
      heapArray[0] = heapArray[--currentSize];
      trickleDown(0);
      return root;
    }  // end remove()
    // ------------------------------------------------------------
    public void trickleDown(int index)
    {
      int largerChild;
      Node top = heapArray[index];       // save root
      while(index < currentSize/2)       // while node has at
      {                               //    least one child,
        int leftChild = 2*index+1;
        int rightChild = leftChild+1; // find larger child
        if(rightChild < currentSize &&  // (rightChild exists?)
          heapArray[leftChild].getKey() <
          heapArray[rightChild].getKey())
          largerChild = rightChild;
        else largerChild = leftChild; // top >= largerChild?
        if( top.getKey() >= heapArray[largerChild].getKey() ) break; // shift child up
        heapArray[index] = heapArray[largerChild];
        index = largerChild;            // go down
      }  // end while
      heapArray[index] = top;            // root to index
  }  // end trickleDown() // ------------------------------------------------------------
  public boolean change(int index, int newValue)
  {
    if(index<0 || index>=currentSize)
      return false;
    int oldValue = heapArray[index].getKey(); // remember old
    heapArray[index].setKey(newValue);  // change to new
    if(oldValue < newValue)             // if raised,
      trickleUp(index);                // trickle it up
    else
      trickleDown(index);
    return true;
  }  // end change()
// ------------------------------------------------------------
  public void displayHeap()
  {
    System.out.print("heapArray: ");    // array format
    for(int m=0; m<currentSize; m++){
      if(heapArray[m] != null)
        System.out.print( heapArray[m].getKey() + " ");
      else
        System.out.print( "-- ");
    }
    System.out.println(); // heap format
    int nBlanks = 32;
    int itemsPerRow = 1;
    int column = 0;
    int j = 0;                          // current item
    String dots = "...............................";
    System.out.println(dots+dots);      // dotted top line
  while(currentSize > 0)              // for each heap item
  {
    if(column == 0){                  // first item in row?
      for(int k=0; k<nBlanks; k++){  // preceding blanks
        System.out.print(" ");
       }
    } // display item
    System.out.print(heapArray[j].getKey());


  if(++j == currentSize)           // done?
    break;
  if(++column==itemsPerRow)        // end of row?
  {
    nBlanks /= 2;                 // half the blanks
    itemsPerRow *= 2;             // twice the items
    column = 0;                   // start over on
    System.out.println();         //    new row
  }
  else                             // next item on row
    for(int k=0; k<nBlanks*2-2; k++)
      System.out.print(" ");     // interim blanks
    }  // end for
    System.out.println("\n"+dots+dots); // dotted bottom line
  }  // end displayHeap()
  // ------------------------------------------------------------
}  // end class Heap
