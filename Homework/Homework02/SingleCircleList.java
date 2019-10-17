class SingleCircleList{
    
    class Node{

        public Object data; //can make strictly-typed, currently a general implementation
        public Node next;

        public Node(Object inD){
            data = inD;
            next = this;
        }
        public Node(Object inD, Node nextNode){
            data = inD;
            next = nextNode;
        }
    }

    Node current;
    int nItems;

    public SingleCircleList(){
        nItems = 0;
    }
    public SingleCircleList(Object startData){
        current = new Node(startData);
        nItems=1;
    }

    public void insert(Object data){
        if(nItems>1){
            Node fresh = new Node(data, current.next);
            current.next = fresh;
            current = fresh;
        }else if(nItems==1){
            Node fresh = new Node(data, current);
            current.next=fresh;
            current = fresh;
        }else{
            current = new Node(data);
        }
        
        nItems++;
    }

    public void step(){
        if(nItems>1){
            current = current.next;
        }
    }

    public void remove(){
        if(nItems<=1){
            current = null;
            nItems=0;
        }else{
            for(int i=0; i<nItems-1; i++){
                step(); //move the pointer to Node previous to current
            }
            current.next = current.next.next;
            nItems--;
        }
    }

    public Object peekCurrent(){
        if(nItems>0){
            return current.data;
        }
        else{
            System.out.println("List too small to peek, returning null..." + "\n");
            return new Object();
        }
    }

    public boolean contains(Object targetData){
        
        int checked = 0;
        while(checked<nItems){
            if(current.data.equals(targetData)){ //mismatch errors may occur with noncomparable data types
                return true;
            }else{
                checked++;
                step();
            }
        }

        return false;
    }


    public void display(){
        
        String out = "This circular list contains " + nItems + " items." + "\n";
        
        out+="\n" + "The contents of this list are: " + "\n";

        int toAdd = nItems;

        while(toAdd>0){
            out += "[" + current.data + "]" + "\n";
            step();
            toAdd--;
        }
        System.out.println(out);
    }

    public static void main(String[] args){


        //TESTING

        /*
        SingleCircleList list = new SingleCircleList(4);
        list.insert(3);
        list.insert(true);
        list.insert(1);
        list.insert("string!!!");
        list.display();
        list.step();
        list.remove();
        list.step();
        list.insert(200);
        list.step();

        System.out.println("current is " + list.current.data + ", next is " + list.current.next.data +  "\n");

        list.remove();
        list.display();

        list.insert(5);
        list.insert(5);
        list.insert(5);
        list.insert(5);
        list.insert(5);
        list.step();
        list.step();
        list.display();

        System.out.println("Searching for [200]... " + list.contains(200));
        System.out.println("Searching for [1]... " + list.contains(1));
        System.out.println("Searching for [1000]... " + list.contains(1000));

        */

    }

}