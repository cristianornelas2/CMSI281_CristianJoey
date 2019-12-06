/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * File name:  LinearStringHash.java
     * Authors: Joey Pereira, Cristian Ornelas
     *  Date          :  2019-12-05
     *  Description   :  Hashes and stores strings in an array
     *  Notes         :  None
     *  Warnings      :  None
     *  Exceptions    :  None
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
public class FoldingHasher{

    private int arraySize;
    private int nDigits;

    //just a hashing algorithm, doesn't actually contain a storage array or directly use the indices it produces!
    //To implement storage and linear probing, I would use an int[] and initialize it to [arraySize] in the constructor,
    //and then for linear probing, all that is needed is a null-checker loop, relying on an nItems int field and IsFull() boolean method
    //  (can see homework item #3 for an implementation of this)

    public FoldingHasher(int arraySize){
        
        SetArraySize(arraySize);    //To handle arrays of any size and groups of any number of digits
        SetNDigits();
        System.out.println("FoldingHasher created with capacity " + arraySize + "! \n");
    }

    public void SetArraySize(int newSize){
        arraySize = newSize;
    }

    public int HashIndexFromEntry(int entry){
        
        entry = Math.abs(entry);
        int total = 0;

        String numString = "" + entry;
        
        while(numString.length()>nDigits){  //add to total values in groups of size nDigits
            total += Integer.parseInt(numString.substring(0, nDigits));
            if(numString.length()>nDigits+1){
                numString = numString.substring(nDigits+1, numString.length()-1);
            }else{break;}
        }

        //now handle remainder digits
        if(numString.length()>0){
            total += Integer.parseInt(numString);
        }
        total %= arraySize;

        System.out.print("Hashing " + entry + " for entry into an array of size " + arraySize + "... resulting hash: " + total + "\n");

        return total;
    }

    private int FindDigitCount(int x){
        x=Math.abs(x);
        String numString = "" + x;
        x = numString.toCharArray().length;
        return x;
    }

    private void SetNDigits(){  //calibrate nDigit group size dynamically based on size of storage array
        nDigits = Math.max(1, FindDigitCount(arraySize)-1);
    }

    public static void main(String[] args){
        
        FoldingHasher hash1 = new FoldingHasher(9);
        FoldingHasher hash2 = new FoldingHasher(200);
        FoldingHasher hash3 = new FoldingHasher(5005);

        int test1 = 2;
        int test2 = 1233;
        int test3 = 2144443;
        int test4 = -979797;

        hash1.HashIndexFromEntry(test1);
        hash2.HashIndexFromEntry(test1);
        hash3.HashIndexFromEntry(test1);

        hash1.HashIndexFromEntry(test2);
        hash2.HashIndexFromEntry(test2);
        hash3.HashIndexFromEntry(test2);

        hash1.HashIndexFromEntry(test3);
        hash2.HashIndexFromEntry(test3);
        hash3.HashIndexFromEntry(test3);
        
        hash1.HashIndexFromEntry(test4);
        hash2.HashIndexFromEntry(test4);
        hash3.HashIndexFromEntry(test4);
    }

}

