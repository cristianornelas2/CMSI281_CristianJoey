/**
     * Editors: Joey Pereira, Cristian Ornelas
     * Function: The idea is to compare two numbers that are next to each other 
                 in the list, starting at the back of the array and moving to the front.
 **/
class BubbleSort {

    private long[] a;       
    private int nElems;  

   
    public BubbleSort( int max ) {
        a = new long[max];      
        nElems = 0;             
    }

    public void insertSort( long num ) {
        a[nElems] = num;
        nElems++;
    }

    /* public void bSort() {
        int out, in;
        for( out = nElems-1; out > 1; out-- ) {
            for ( in = 0; in < out; in++ ) {
                if ( a[in] > a[in+1] ) {
                    swap( in , in+1 );
                }
            }
        }
    } */

    public void oddEvenSort() {
        for ( int j = 0; j < nElems; j++ ) {
            for ( int i = 1; i < nElems-1; i+=2 ) {
                if ( a[i] > a[i+1] ) {
                    swap( i , i+1 );
                }
            }
            for ( int i = 0; i < nElems-1; i+=2 ) {
                if ( a[i] > a[i+1] ) {
                    swap( i , i+1 );
                }
            }
        }
    }

    private void swap( int first, int second ) {
        long temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public void display() {
        for( int i = 0; i < nElems; i++ ) {
            System.out.print( a[i] + " " );
        }
        System.out.println();
    }

    public static void main( String[] args ) {
        int maxSize = 50;              
        BubbleSort barray;                
        barray = new  BubbleSort(maxSize);


        System.out.println( "\n-----TESTING oddEvenSort() with 1 element-----");
        BubbleSort oneItem = new BubbleSort(1);
        oneItem.insertSort(50);
        oneItem.display();
        oneItem.oddEvenSort();
        oneItem.display();              

        System.out.println( "\n-----TESTING oddEvenSort() with 2 elements-----");
        BubbleSort twoItems = new BubbleSort(2);
        twoItems.insertSort(48);
        twoItems.insertSort(8);
        twoItems.display();
        twoItems.oddEvenSort();
        twoItems.display();

        System.out.println( "\n-----TESTING oddEvenSort() with 3 elements-----");
        BubbleSort threeItems = new BubbleSort(3);
        threeItems.insertSort(29);
        threeItems.insertSort(48);
        threeItems.insertSort(11);
        threeItems.display();
        threeItems.oddEvenSort();
        threeItems.display();

        System.out.println( "----TESTING oddEvenSort() with 10 elements----");
        barray.insertSort(00);
        barray.insertSort(49);
        barray.insertSort(33);
        barray.insertSort(22);
        barray.insertSort(15);
        barray.insertSort(11);
        barray.insertSort(20);
        barray.insertSort(40);
        barray.insertSort(38);
        barray.insertSort(19);
        barray.display();                 
        barray.oddEvenSort();            
        barray.display();

    }

}
