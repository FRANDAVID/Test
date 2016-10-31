package 优先队列;

public class TestPriorityQueue {
    public static void main(String[] args) {  
        Patient patient1 = new Patient("john", 2);  
        Patient patient2 = new Patient("slmile", 0);  
        Patient patient3 = new Patient("dohn", 5);  
        Patient patient4 = new Patient("jack", 3);  
        Patient patient5 = new Patient("sen", 7);  
  
        MyPriorityQueue priorityQueue = new MyPriorityQueue();  
        priorityQueue.enqueue(patient1);  
        priorityQueue.enqueue(patient2);  
        priorityQueue.enqueue(patient3);  
        priorityQueue.enqueue(patient4);  
        priorityQueue.enqueue(patient5);  
  
        while (priorityQueue.getSize() > 0) {  
            System.out.println(priorityQueue.dequeue() + " ");  
        }  
    }  
  
}  
  
class Patient implements Comparable {  
    private String name;  
    private int priority;  
  
    public Patient(String name, int priority) {  
        this.name = name;  
        this.priority = priority;  
    }  
  
    public String toString() {  
        return name + "(priority: " + priority + ")";  
    }  
  
    public int compareTo(Object o) {  
        return this.priority - ((Patient) o).priority;  
    }  
}  