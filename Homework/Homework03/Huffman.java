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

    private String[] letterDump;
    private TreeMap<Character,Integer> histogram;
    public TreeMap<Character,String> translationTable;
    private int highestFrequency;
    public HuffNode trueRoot;
    private HuffNode waitingSubtree;

    public Huffman(String entry){

        int size = entry.length();
        letterDump = new String[size];

        for(int i = 0; i<size; i++){
            char toCheck = entry.charAt(i);

            for(int j = 0; j<size; j++){
                if(letterDump[j]== null) {
                    letterDump[j] = (""+toCheck);
                    break;
                }else if(letterDump[j].charAt(0)==toCheck){
                    letterDump[j] += (""+toCheck);
                    break;
                }
            }
        }

        histogram = new TreeMap<Character, Integer>();
        

        int currentHighest = -1;
        int histCount = 0;
        while(letterDump[histCount]!=null){
            String packaging = letterDump[histCount++];
            if(packaging.length()>currentHighest){currentHighest=packaging.length();}
            histogram.put(packaging.charAt(0), packaging.length());
        }

        System.out.println("Setting highest frequency to " + currentHighest);
        highestFrequency = currentHighest;

        System.out.println(histogram + "\n");

        
        Map.Entry<Character,Integer> lowest = PullLowestHistogramValue();
        System.out.println("LOWEST: " + lowest + "\n");

        int lowestInt = lowest.getValue();
        char lowestChar = lowest.getKey();


        histogram.remove(lowest.getKey());
        System.out.println("Histogram after removing lowest: " + histogram + "\n");


        Map.Entry<Character,Integer> secondLowest = PullLowestHistogramValue();
        System.out.println("SECOND LOWEST: " + secondLowest + "\n");

        int secondLowestInt = secondLowest.getValue();
        char secondLowestChar = secondLowest.getKey();

        histogram.remove(secondLowest.getKey());
        System.out.println("Histogram after removing second lowest: " + histogram + "\n");

        System.out.println(histogram + "\n");

        HuffNode leastestSubtree = new HuffNode(lowestInt+secondLowestInt);

        leastestSubtree.L = new HuffNode(lowestChar);
        leastestSubtree.R = new HuffNode(secondLowestChar);

        System.out.print("Keys stored. parent node: " + leastestSubtree.data + ", Left Child: " + leastestSubtree.L.data + ", Right Child: " + leastestSubtree.R.data + "\n");


        PopulateTree(leastestSubtree);

        trueRoot.codeString = "";
        translationTable = new TreeMap<Character,String>();
        SetCodestringOnChildren(trueRoot);

        System.out.println(trueRoot.R.R.L.codeString);

        System.out.println(translationTable);



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
            System.out.println("Returning from PullLowest with " + currentLowest + "\n");
            //currentLowest = histogram.get(currentLowest.getKey());
            return currentLowest;
        }return null;
    }


    public void PopulateTree(HuffNode currentRoot){

        if(histogram.isEmpty()){
            trueRoot = new HuffNode((int)waitingSubtree.data+highestFrequency);
            trueRoot.L = currentRoot;
            if(waitingSubtree!=null){
            trueRoot.R = waitingSubtree;
            }
            System.out.println("ALL DONE");
            return;}


        else{
            if((int)currentRoot.data>highestFrequency){
                System.out.println("NEED A NEW SUBTREE! Histogram population is currently " + histogram.size());

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
                        System.out.print("New Subtree forming! Keys stored. parent node: " + newRoot.data + ", Left Child: " + newRoot.L.data + ", Right Child: " + newRoot.R.data + "\n");
                        

                        System.out.println(histogram + "\n");
                        PopulateTree(newRoot);
                        return;

                    }else{
                        Map.Entry<Character,Integer> lastEntry = PullLowestHistogramValue();
                        int lastValue = lastEntry.getValue();
                        int lastChar = lastEntry.getKey();


                        //need to check but idk if this is doing anything

                        trueRoot = new HuffNode(lastValue+(int)waitingSubtree.data);
                        trueRoot.L = currentRoot;
                        trueRoot.R = waitingSubtree;
                        
                        System.out.println("All done!!!");
                        return;
                    }

                }else{
                    System.out.print("Connecting Subtrees! \n");
                    HuffNode newSub = new HuffNode ((int)currentRoot.data+(int)waitingSubtree.data);
                    newSub.L = currentRoot;
                    newSub.R = waitingSubtree;
                    waitingSubtree = newSub;
                }
            }

            Map.Entry<Character,Integer> nextLowest = PullLowestHistogramValue();
            int nextInt = nextLowest.getValue();
            char nextChar = nextLowest.getKey();

            System.out.println("Removing key/value entry " + nextLowest + "\n");
            histogram.remove(nextChar);
            HuffNode addition = new HuffNode(nextInt+(int)currentRoot.data);
            addition.L = new HuffNode(nextChar);
            addition.R = currentRoot;
            System.out.print("Keys stored. parent node: " + addition.data + ", Left Child: " + addition.L.data + ", Right Child: " + addition.R.data + "\n");

            System.out.println(histogram);

            PopulateTree(addition);
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
        if(current.L.data instanceof Character){translationTable.put((char)current.L.data, current.L.codeString);}
        SetCodestringOnChildren(current.L);
        }

        if(current.R!=null){
        current.R.codeString = current.codeString + "1";
        if(current.R.data instanceof Character){translationTable.put((char)current.R.data, current.R.codeString);}
        SetCodestringOnChildren(current.R);
        }
    }

    public static void main(String[] args){
        Huffman test = new Huffman("This string is a message that I am testing, yes I am testing this string, this message.");
    }
    
}
