/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * File name:  Node.java
     * Authors: Joey Pereira, Cristian Ornelas
     *  Date          :  2019-12-05
     *  Description   :  See purpose
     *  Notes         :  None
     *  Warnings      :  None
     *  Exceptions    :  None
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 **/

public class Node {
    public int d;
    public Node childL;
    public Node childR;

    public Node( int dataIn ) {
        d = dataIn;
    }

    public void insertLeft( int dataIn ) {
        childL = new Node( dataIn );
    }

    public void insertRight( int dataIn ) {
        childR = new Node( dataIn );
    }

    public void inOrderTraversal( Node currentNode ) {
        if( currentNode == null ) {
            return;
        }
        inOrderTraversal( currentNode.childL );
        System.out.print( " " + currentNode.d + " " );
        inOrderTraversal( currentNode.childR );
    }

    public static void main( String args[] ) {
        System.out.println( "Testing In-Order With Binary Search Tree");
        Node root = new Node( 45 );
        root.insertLeft( 27 );
        root.insertRight( 73 );
        root.childL.insertLeft( 11 );
        root.childL.insertRight( 30 );
        root.childR.insertLeft( 68 );
        root.childR.insertRight( 90 );
        root.inOrderTraversal( root );
        System.out.println();
        System.out.println();

        System.out.println( "Testing In-Order With One Node");
        Node root2 = new Node( 27 );
        root.inOrderTraversal( root2 );
        System.out.println();
        System.out.println();

        System.out.println( "Testing In-Order With Left Children Only");
        Node root3 = new Node( 100 );
        root3.insertLeft( 50 );
        root3.childL.insertLeft( 24 );
        root3.childL.childL.insertLeft( 12 );
        root3.childL.childL.childL.insertLeft( 6 );
        root3.childL.childL.childL.childL.insertLeft( 2 );
        root3.inOrderTraversal( root3 );
        System.out.println();
        System.out.println();

        System.out.println( "Testing In-Order With Right Children Only");
        Node root4 = new Node( 75 );
        root4.insertRight( 100 );
        root4.childR.insertRight( 125 );
        root4.childR.childR.insertRight( 150 );
        root4.childR.childR.childR.insertRight( 175 );
        root4.childR.childR.childR.childR.insertRight( 200 );
        root4.inOrderTraversal( root4 );
        System.out.println();
    }
}
