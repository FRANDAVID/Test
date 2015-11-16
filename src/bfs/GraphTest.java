package bfs;


//用队列Queue实现 图 广度优先搜索


public class GraphTest {

    public static void main(String[] args) {
            GraphNode n1 = new GraphNode(1); 
            GraphNode n2 = new GraphNode(2); 
            GraphNode n3 = new GraphNode(3); 
            GraphNode n4 = new GraphNode(4); 
            GraphNode n5 = new GraphNode(5); 

            n1.neighbors = new GraphNode[]{n2,n3,n5};
            n2.neighbors = new GraphNode[]{n1,n4};
            n3.neighbors = new GraphNode[]{n1,n4,n5};
            n4.neighbors = new GraphNode[]{n2,n3,n5};
            n5.neighbors = new GraphNode[]{n1,n3,n4};

            breathFirstSearch(n1, 5);
    }

    public static void breathFirstSearch(GraphNode root, int x){
            if(root.val == x)
                    System.out.println("find in root");

            Queue queue = new Queue();
            root.visited = true;
            queue.enqueue(root);

            while(queue.first != null){
                    GraphNode c = (GraphNode) queue.dequeue();
                    for(GraphNode n: c.neighbors){

                            if(!n.visited){
                                    System.out.print(n + " ");
                                    n.visited = true;
                                    if(n.val == x)
                                            System.out.println("Find "+n);
                                    queue.enqueue(n);
                            }
                    }
            }
    }
}
