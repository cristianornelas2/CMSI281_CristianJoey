class CircleStack{          //based on the implementation for SingleCircleList.java
    
    class Node{

        public Object data; //can make strictly-typed, currently a general implementation
        public Node next;

        public Node(Object inD){  //internal Node class constructors + properties completely unchanged
            data = inD;
            next = this;
        }
        public Node(Object inD, Node nextNode){
            data = inD;
            next = nextNode;
        }
    }

    Node top; //SingleCircleList's "current" renamed "top" for Stack naming convention
    int nItems;

    public CircleStack(){
        nItems = 0;
    }
    public CircleStack(Object startData){
        top = new Node(startData);
        nItems=1;
    }

    public void push(Object data){

        //Replaces insert(), but this method is way simpler because Stack priority only requires "top" to link to the next item/task

        if(top!=null){
            top = new Node(data,top);
        }else{
            top = new Node(data);
        }

        nItems++;
    }

    public Object pop(){

        //rewritten to not require a step() function (Stack access convention: we probably don't want one)
        //step() is no longer needed due to a Stack's explicit beginning + end designations vs a circular list


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

    public Object peek(){ //renamed method but identical implementation
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

            Node searching = top; //This temp pseudo-iterator node is used to replace our removed step() function

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

        System.out.println("stack should display: string!!, 1, true, 3, 4"  +  "\n");

        stack.display();
        stack.pop();
        stack.pop();

        System.out.println("stack should display: true, 3, 4"  +  "\n");

        stack.display();
        stack.push(200);

        System.out.println("current should be 200, next should be true "  +  "\n");
        System.out.println("current is " + stack.peek() + ", next is " + stack.top.next.data +  "\n");

        stack.pop();

        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);

        System.out.println("stack should display: 5, 5, 5, 5, 5, true, 3, 4"  +  "\n");


        stack.display();

    }

}