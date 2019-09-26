 public class IntQueue {

      private Node head;
      private int  size;

     // the constructor
      IntQueue() {
         head = null;
         size = 0;
      }

      public int getSize() {
         return size;
      }

      /*

      public void prepend( int dataToAdd ) {
         Node currentHead = head;
         head = new Node( dataToAdd );
         head.next = currentHead;
         size++;
      }
      */

      public int peek(){
          return head.data;
      }

      public void insert(int x){
        Node newNode = new Node(x);
        Node current = head;
        while(current.next!=null){
            current = current.next;
        }
        current.next = newNode;
        size++;
      }


      /* this is for a stack

      public int remove(){
          Node current = head;
          Node last = current;
          while(current.next!=null){
              last = current;
              current = current.next;
          }
          int out = current.data;
          last.next = null;
          return out;
      }

      */

      public boolean isEmpty(){
          return (head==null) ? true : false;
      }

      public int remove(){
        int out = -1;
        if(head!=null)
        {
            out = head.data;
            if (head.next!=null){
                head = head.next;
            }else{
                head = null;
            }
            size--;
        }
        return out;
      }

      private class Node {

         int data;            // remember this is an IntLinkedList
         Node next;           // here's the self-referential part

         // constructor
         Node( int d ) {
            data = d;
            next = null;
         }
      }

      public Iterator getIteratorAt( int index ) {
         if( (index > size) || (index < 0) ) {
            throw new IllegalArgumentException();
         }
         Iterator it = new Iterator();
         while( index > 0 ) {
            it.next();
            index--;
         }
         return it;
      }

      /*


      public void insertAt(int index, int data) {
           Node newNode = new Node(data);
           IntLinkedList.Iterator it = getIteratorAt(index+1);
           newNode.next = it.currentNode.next;
           it.currentNode.next = newNode;
      }

      public void removeAt(int index) {
         IntLinkedList.Iterator it = getIteratorAt(index-1);
         it.currentNode.next = it.currentNode.next.next;

      }

      */

      public class Iterator {
         private Node currentNode;

         Iterator() {
            currentNode = head;
         }

         public void next() {
            if( currentNode == null ) {
               return;
            } else {
               currentNode = currentNode.next;
            }
         }

         public boolean hasNext() {
            return ((currentNode != null) && (currentNode.next != null));
         }

         public int getCurrentInt() {
            return currentNode.data;
         }

      }
   }
