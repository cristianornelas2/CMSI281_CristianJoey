/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * File name:  Huffman.java
     * Authors: Joey Pereira, Cristian Ornelas
     * Purpose: 
     * Date:  2019-11-07
     * Description:  See purpose
     * Notes:  None
     * Warnings:  None
     * Exceptions:  None
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/
import java.util.*;

public class Huffman{

    private String initialEntry;
    private String[] letterDump;
    private TreeMap<Character,Integer> histogram;
    public TreeMap<Character,String> toBinaryTranslationTable;
    private TreeMap<String,Character> fromBinaryTranslationTable;
    private int highestFrequency;
    public HuffNode trueRoot;
    private HuffNode waitingSubtree;

    public Huffman(String entry){

        initialEntry = entry;
        
        InitializeLetterDump(); //builds an array of strings where each cell contains a monocharacter string
        
        BuildHistogram();   //using the length of each string in the letterDump, builds a histogram to determine frequency

        
        Map.Entry<Character,Integer> lowest = PullLowestHistogramValue();
        int lowestInt = lowest.getValue();
        char lowestChar = lowest.getKey();
        histogram.remove(lowest.getKey());


        Map.Entry<Character,Integer> secondLowest = PullLowestHistogramValue();     //Setting up tree with lowest two values
        int secondLowestInt = secondLowest.getValue();
        char secondLowestChar = secondLowest.getKey();
        histogram.remove(secondLowest.getKey());


        HuffNode leastestSubtree = new HuffNode(lowestInt+secondLowestInt);

        leastestSubtree.L = new HuffNode(lowestChar);
        leastestSubtree.R = new HuffNode(secondLowestChar);


        PopulateTree(leastestSubtree);

        trueRoot.codeString = "";
        toBinaryTranslationTable = new TreeMap<Character,String>();
        fromBinaryTranslationTable = new TreeMap<String,Character>();

        SetCodestringOnChildren(trueRoot);


        System.out.println("Binary Translation Table:    " + toBinaryTranslationTable + "\n");

   }

    private void InitializeLetterDump(){
        int size = initialEntry.length();
        letterDump = new String[size];

        for(int i = 0; i<size; i++){
            char toCheck = initialEntry.charAt(i);

            for(int j = 0; j<size; j++){
                if(letterDump[j] == null) {
                    letterDump[j] = (""+toCheck);
                    break;
                }else if(letterDump[j].charAt(0)==toCheck){
                    letterDump[j] += (""+toCheck);
                    break;
                }
            }
        }
    }

    private void BuildHistogram(){

        histogram = new TreeMap<Character, Integer>();
        

        int currentHighest = -1;
        int histCount = 0;
        while(letterDump[histCount]!=null){
            if(letterDump[histCount]!=null){
                String packaging = letterDump[histCount++];
                if(packaging.length()>currentHighest){currentHighest=packaging.length();}
                histogram.put(packaging.charAt(0), packaging.length());
            }else break;
        }

        highestFrequency = currentHighest;

        System.out.println("Histogram Generated! Letter occurences: " + histogram + "\n");

    }

   public int GetHighestHistogramFrequency(){
        int mostCheck = -1;
        return mostCheck;       
   }

    public Map.Entry<Character,Integer> PullLowestHistogramValue(){
        if(!histogram.isEmpty()){
            Map.Entry<Character,Integer> currentLowest = histogram.firstEntry();
            int leastCheck = currentLowest.getValue();    

            for(Map.Entry<Character, Integer> x : histogram.entrySet()){
                if(leastCheck - (int)x.getValue()>0){

                    currentLowest = x;
                    leastCheck = x.getValue();
                }
            }
            return currentLowest;
        }else return null; //If the histogram is empty
    }


    public void PopulateTree(HuffNode currentRoot){

        if(histogram.isEmpty()){    //base case
            if(waitingSubtree!=null){
                trueRoot = new HuffNode((int)waitingSubtree.data+highestFrequency); //complete tree construction by linking final two subtrees
                trueRoot.L = currentRoot;
                trueRoot.R = waitingSubtree;
            }else{
                trueRoot = currentRoot;
            }
            return;
        }


        else{
            if((int)currentRoot.data>highestFrequency){ //checking if a new subtree is needed

                if(waitingSubtree==null){
                    waitingSubtree = currentRoot;

                    if(histogram.size()>1){

                        Map.Entry<Character,Integer> subtreeNextLowest = PullLowestHistogramValue();
                        int subNextLowInt = subtreeNextLowest.getValue();
                        char subNextLowChar = subtreeNextLowest.getKey();

                        histogram.remove(subNextLowChar);


                        Map.Entry<Character,Integer> subtreeSecondNextLowest = PullLowestHistogramValue();
                        int subSecNextLowInt = subtreeSecondNextLowest.getValue();
                        char subSecNextLowChar = subtreeSecondNextLowest.getKey();
                        
                        histogram.remove(subSecNextLowChar);


                        HuffNode newRoot = new HuffNode(subNextLowInt+subSecNextLowInt);
                        newRoot.L = new HuffNode(subNextLowChar);
                        newRoot.R = new HuffNode(subSecNextLowChar);
                        
                        PopulateTree(newRoot);  //recursive case when new subtree is needed
                        return;

                    }

                }else{
                    HuffNode newSub = new HuffNode ((int)currentRoot.data+(int)waitingSubtree.data);
                    newSub.L = currentRoot;
                    newSub.R = waitingSubtree;
                    waitingSubtree = newSub;
                }
            }

            Map.Entry<Character,Integer> nextLowest = PullLowestHistogramValue();
            int nextInt = nextLowest.getValue();
            char nextChar = nextLowest.getKey();

            histogram.remove(nextChar);
            HuffNode addition = new HuffNode(nextInt+(int)currentRoot.data);
            addition.L = new HuffNode(nextChar);
            addition.R = currentRoot;


            PopulateTree(addition); //standard recursive case
        }

    }


    private class HuffNode{
        HuffNode L;
        HuffNode R;

        String codeString;

        Object data;

        public HuffNode(Object inData){
            data = inData;
        }

    }

    public void SetCodestringOnChildren(HuffNode current){

        if(current.L!=null){
        current.L.codeString = current.codeString + "0";
        if(current.L.data instanceof Character){
            toBinaryTranslationTable.put((char)current.L.data, current.L.codeString);
            fromBinaryTranslationTable.put(current.L.codeString,(char)current.L.data);

        }
        SetCodestringOnChildren(current.L);
        }

        if(current.R!=null){
        current.R.codeString = current.codeString + "1";
        if(current.R.data instanceof Character){
            toBinaryTranslationTable.put((char)current.R.data, current.R.codeString);
            fromBinaryTranslationTable.put(current.R.codeString,(char)current.R.data);

        }
        SetCodestringOnChildren(current.R);
        }
    }


    public String GetBinary(){
        String out = "";

        char[] chars = initialEntry.toCharArray();
        for(char x : chars){
            out += toBinaryTranslationTable.get(x);
        }

        return out;
    }

    public String MessageFromBinary(String binary){
        
        String out = "";
        String checking;

        int startDex=0;
        int endDex=1;

        int stopping = binary.length();

        while(endDex<stopping){
            checking = binary.substring(startDex,endDex+1);
            if(fromBinaryTranslationTable.containsKey(checking)){
                out += fromBinaryTranslationTable.get(checking);
                startDex = endDex + 1;
                endDex = startDex + 1;
            }else{
                endDex++;
            }
        }

        return out;
    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a message with at least three unique characters...   ");
        String toEncode = input.nextLine();

        Huffman test = new Huffman(toEncode);

        String binary = test.GetBinary();
        System.out.println("Binary Encoding:     \n" + binary + "\n");
        System.out.println("From Binary back to Message: \n" + test.MessageFromBinary(binary));

    }
    
}
