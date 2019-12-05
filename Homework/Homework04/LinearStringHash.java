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
public class LinearStringHash{

    private String[] strings;
    public int arraySize = 50;
    public int nItems;

    public LinearStringHash(int arraySize){
        this.arraySize = arraySize;
        strings = new String[arraySize];
        nItems = 0;
    }

    public void StoreString(String entry){
        if(!IsFull()){
            int attemptedIndex = GetIndex(entry);
            while(strings[attemptedIndex]!=null){ //linear probing
                attemptedIndex++;
                if(attemptedIndex>=arraySize){
                    attemptedIndex = 0;
                }
            }
            strings[attemptedIndex]=entry;
            nItems++;
            System.out.println("String " + entry + " hashed and stored at index " + attemptedIndex);
        }else{
            System.out.println("Error! Storage array is full!");
        }
    }

    public String GetValue(int keyIndex){
        return strings[keyIndex];
    }

    private boolean IsFull(){
        return(nItems>=arraySize);
    }

    private int GetIndex (String toHash){
        toHash = toHash.toLowerCase();
        int out = 0;
        char[] characters = toHash.toCharArray();
        for(char x : characters){
            out+=(x-96);    //adding character codes to out total
        }

        return out % arraySize; //hashing with the modulo operator
    }
    
    public static void main(String[] args){
        LinearStringHash storage = new LinearStringHash(50);    //testing
        storage.StoreString("string");
        storage.StoreString("a");
        storage.StoreString("congratulations");
        storage.StoreString("woof");
        storage.StoreString("blah");
        storage.StoreString("terrific");
        storage.StoreString("abcdefghijklmnopqrstuvwxyz");
        storage.StoreString("abcdefghijklmnopqrstuvwxyz");  //linear probe testing
        storage.StoreString("abcdefghijklmnopqrstuvwxyz");
    }

}