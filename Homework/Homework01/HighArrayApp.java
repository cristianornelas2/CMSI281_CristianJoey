// HighArrayApp.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////

import HighArray.*;

class HighArrayApp
   {
   public static void main(String[] args)
          {
          int maxSize = 100;              // array size 
          HighArray arr;                  // reference to array
          arr = new HighArray(maxSize);   // create the array

          System.out.print("--------TESTING FOR INSERT() ---------");
          arr.insert(77);                 
          arr.insert(99); 
          arr.insert(44); 
          arr.insert(55); 
          arr.insert(22); 
          arr.insert(88); 
          arr.insert(11); 
          arr.insert(00); 
          arr.insert(66); 
          arr.insert(33);

          arr.display();

          int searchKey = 35;
          if( arr.find(searchKey)) {
             System.out.println("Found " + searchKey); 
          }
          else {
             System.out.println("Can’t find " + searchKey);
          }

          arr.delete(00);                // delete 3 items
          arr.delete(55); 
          arr.delete(99);
          arr.delete(88);
          arr.delete(77);
          arr.delete(66);
      
          System.out.println("--------Testing for GETMAX()--------");
            arr.insert(50);
          System.out.println("Expects: 50   Got: " + arr.getMax());
            arr.delete(50);
            arr.insert(75);
          System.out.println("Expects: 75   Got:  " + arr.getMax());
            arr.delete(75);
            arr.delete(44);
            arr.delete(33);
            arr.insert(25);
          System.out.println("Expects: 25   Got:  " + arr.getMax());
            arr.delete(25);
            arr.insert(100);
          System.out.println("Expects: 100  Got:  " + arr.getMax());
            arr.delete(100);
      
      
         System.out.println("--------Testing for NODUPS()--------");
            HighArray arr2 = new HighArray(20);
            arr2.insert(5);
            arr2.insert(10);
            arr2.insert(15);
            arr2.insert(20);
            arr2.insert(20);
            arr2.insert(25);
            arr2.insert(25);
            arr2.insert(25);
            arr2.insert(30);
            arr2.insert(35);
            arr2.insert(40);
            arr2.insert(45);
            arr2.insert(45);
            arr2.insert(50);
            arr2.insert(55);
            arr2.insert(60);
            arr2.insert(65);
            arr2.insert(70);
            arr2.insert(70);
            arr2.insert(75);
            
            arr2.display();
            arr2.noDups();
            arr2.display();
          } // end main()
         } 
         // end class HighArrayApp

////////////////////////////////////////////////////////////////
