package bfs;
class Stack{
        Node top; 
 
        public Node peek(){
                if(top != null){
                        return top;
                }
 
                return null;
        }
 
        public Node pop(){
                if(top == null){
                        return null;
                }else{
                        Node temp = new Node(top.val);
                        top = top.next;
                        return temp;    
                }
        }
 
        public void push(Node n){
                if(n != null){
                        n.next = top;
                        top = n;
                }
        }
        public static void main(String[]args){
        	int arr[]={1,3,4,7,0,10,22,23};
        	Stack stack = new Stack();
       
        	for(int i=0;i<arr.length;i++)
        	{
        		Node n = new Node(arr[i]);
        		stack.push(n);
        	}
        	for(int i=0;i<arr.length;i++)
        	{
        		System.out.println(stack.pop().val);
        	}
        }
}