  public interface IntListInterface {
      int getValueAtIndex( int index );
      boolean append( int valueToAdd );
      boolean insertValueAtIndex( int value, int index );
      int removeValueAtIndex( int index );
   }

   public class IntList implements IntListInterface {
      private int[] theList;
      private int size;
      private int items;

      private int startSize; 

      public IntList(int size) {
        this.startSize = size;                        // doesn't HAVE to be declared public, but doesn't hurt
        theList = new int[size];
        size = 0;
      }

      public int getValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
         if( size == 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The list is empty!" );   // maybe not the best...
         } else if( index > size ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too large" );
         } else if( index < 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too small");
         } else {
            return theList[index];
         }
      }

      public boolean append( int valueToAdd ) {
         if( size < theList.length ) {
            theList[size] = valueToAdd;
            size++;
            return true;
         } else {
            // what should we do here, if there's no room?
            int[] newList = new int[size++];
            int count = 0;
            for (int x : theList) {
                newList[count++] = x;
            }
            newList[size-1] = valueToAdd;
         }

         theList = newList;

         return false;
      }

      public boolean prepend(int value){
        int[] newList = new int[size++];
        newList[0] = value;
        int count = 1;
        for (int x : theList) {
            newList[count++] = x;
        }

        theList = newList;

          return true;
      }

      public boolean checkIndex(int value){
          if(value>=0&&value<size){
              return true;
          }else{
              return false;
          }
      }

      // we've gotta have this to actually get things to compile
      public boolean insertValueAtIndex( int value, int index ) {

        if(index>size+1){
            //we have to make an array that is more than one index larger
        }else{
            //we only make an array of size+1 size

            int[] newList = new int[size++];

        }

        return true;
      }

      public int removeValueAtIndex( int index ) throws ArrayIndexOutOfBoundsException {
         int value = theList[index];
         if( size == 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The list is empty!" );   // maybe not the best...
         } else if( index > size ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too large" );
         } else if( index < 0 ) {
            throw new ArrayIndexOutOfBoundsException( "The index value is too small");
         } else {
            holeFiller( index );
         }
         return value;
      }

      private void holeFiller( int index ) {
         for( int i = index; i < size - 1; i++ ) {
            theList[i] = theList[i+1];
         }
         size--;
      }

      public static void main( String[] args ) {
         IntList list = new IntList();
         list.append( 2 );
         list.append( 3 );
         list.append( 5 );
         list.append( 7 );
         System.out.println( list.getValueAtIndex( 3 ) );   // should return the value 7
         list.append( 11 );
         list.append( 13 );
         list.append( 17 );
         list.append( 19 );
         System.out.println( list.getValueAtIndex( 7 ) );      // should return the value 19
         System.out.println( list.removeValueAtIndex( 3 ) );   // should return the value 7
         System.out.println( list.getValueAtIndex( 3 ) );      // should return the value 11
         System.out.println( list.getValueAtIndex( 18 ) );     // just to see what happens

      }
   }
            