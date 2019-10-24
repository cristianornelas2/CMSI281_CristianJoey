public class BinaryTree {
      public static void main( String[] args ) {
         BinaryTreeNode root = new BinaryTreeNode( 0 );
         root.add( 1, "L" );
         root.add( 2, "R" );
         BinaryTreeNode one = root.getChild( "L" ); // looks at the children in root and gets the child to the LEFT 
                                                    // assigns it to "one"
         BinaryTreeNode two = root.getChild( "R" ); // looks at the children in root and gets the child to the RIGHT
                                                    // assigns it to "two"
         one.add( 3, "L" );
         one.add( 4, "R" );
         two.add( 5, "L" );
         two.add( 6, "R" );
         BinaryTreeNode six = two.getChild( "R" );
         six.add( 7, "L" );
         six.add( 8, "R" );

         System.out.println("-----------TESTING preOrderPrinter()------------");
         System.out.println();
         System.out.println("Subtree/Node of the Root");
         root.preOrderPrinter(root);
         root.preOrderPrinter( root.getChild( "L" ) );
         root.preOrderPrinter( root.getChild( "R" ) );
         System.out.println();
         System.out.println();


         System.out.println("-----------TESTING postOrderPrinter()------------");
         System.out.println();
         System.out.println("Subtree/Node of the Root");
         root.postOrderPrinter( root.getChild( "L" ) );
         root.postOrderPrinter( root.getChild( "R" ) );
         root.postOrderPrinter(root);
         System.out.println();
         System.out.println();


         System.out.println("-----------TESTING inOrderPrinter()------------");
         System.out.println();
         System.out.println("Subtree/Node of the Root");
         root.inOrderPrinter( root.getChild( "L" ) );
         root.inOrderPrinter(root);
         root.inOrderPrinter( root.getChild( "R" ) );
         System.out.println();
         System.out.println();

      }
   }
