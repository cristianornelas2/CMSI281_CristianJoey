class CircleStack{          //based on the implementation for SingleCircleList.java
    
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

    Node top;
    int nItems;

    public CircleStack(){
        nItems = 0;
    }
    public CircleStack(Object startData){
        top = new Node(startData);
        nItems=1;
    }

    public void push(Object data){

        if(top!=null){
            top = new Node(data,top);
        }else{
            top = new Node(data);
        }

        nItems++;
    }

    public Object pop(){

        if(nItems<=0){
            System.out.println("Trying to pop an empty stack! Returning null object...");
            return new Object();
        } 
        
        Object out = top.data;

        if(nItems==1){
            top = null;
            nItems=0;
        }else{
            top = top.next;
            nItems--;
        }
        return out;
    }

    public Object peek(){
        if(nItems>0){
            return top.data;
        }
        else{
            System.out.println("List too small to peek, returning null..." + "\n");
            return new Object();
        }
    }

    public void display(){
        
        String out = "This stack contains " + nItems + " items." + "\n";
        
        if(nItems>0){

            out+="\n" + "The contents of this stack are: " + "\n";

            int toAdd = nItems;

            Node searching = top;

            while(toAdd>0){
                out += "[" + searching.data + "]" + "\n";
                searching = searching.next;
                toAdd--;
            }

        }
        System.out.println(out);
    }

    public static void main(String[] args){


        CircleStack stack = new CircleStack(4);
        stack.push(3);
        stack.push(true);
        stack.push(1);
        stack.push("string!!!");
        stack.display();
        stack.pop();
        stack.display();
        stack.pop();
        stack.display();
        stack.push(200);

        System.out.println("current is " + stack.top.data + ", next is " + stack.top.next.data +  "\n");

        stack.pop();
        stack.display();

        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.display();

    }

}