/**
 * Project Name:Test
 * File Name:Snippet.java
 * Package Name:集合
 * Date:2015年12月2日下午7:46:22
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
*/

package 集合;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//http://www.hollischuang.com/archives/33
/**
 * fail-fast 机制是java集合(集合)中的一种错误机制。当多个线程对同一个集合的内容进行操作时，就可能会产生fail-fast事件。
　　例如：当某一个线程A通过iterator去遍历某集合的过程中，若该集合的内容被其他线程所改变了；那么线程A访问集合时，
就会抛出ConcurrentModificationException异常，产生fail-fast事件。
要了解fail-fast机制，我们首先要对ConcurrentModificationException 异常有所了解。当方法检测到对象的并发修改，
但不允许这种修改时就抛出该异常。同时需要注意的是，该异常不会始终指出对象已经由不同线程并发修改，
如果单线程违反了规则，同样也有可能会抛出改异常。
诚然，迭代器的快速失败行为无法得到保证，它不能保证一定会出现该错误，
但是快速失败操作会尽最大努力抛出ConcurrentModificationException异常，
所以因此，为提高此类操作的正确性而编写一个依赖于此异常的程序是错误的做法，
正确做法是：ConcurrentModificationException 应该仅用于检测 bug。


 */

public class Snippet {
	/**  
	 * 使用增强的for循环  
	 * 在循环过程中从List中删除非基本数据类型以后，继续循环List时会报ConcurrentModificationException  
	 */    
	public void listRemove() {    
	    List<Student> students = new ArrayList<Student>();    
	    for (Student stu : students) {    
	        if (stu.getId() == 2)     
	            students.remove(stu);    
	    }    
	}    
	
	
	
	/**  
	 * 像这种使用增强的for循环对List进行遍历删除，但删除之后马上就跳出的也不会出现异常  
	 */    
	public void listRemoveBreak() {    
	    List<Student> students = new ArrayList<Student>();    
	    for (Student stu : students) {    
	        if (stu.getId() == 2) {    
	            students.remove(stu);    
	            break;    
	        }    
	    }    
	}    
	
	
	/**  
	 * 这种不使用增强的for循环的也可以正常删除和遍历,  
	 * 这里所谓的正常是指它不会报异常，但是删除后得到的  
	 * 数据不一定是正确的，这主要是因为删除元素后，被删除元素后  
	 * 的元素索引发生了变化。假设被遍历list中共有10个元素，当  
	 * 删除了第3个元素后，第4个元素就变成了第3个元素了，第5个就变成  
	 * 了第4个了，但是程序下一步循环到的索引是第4个，  
	 * 这时候取到的就是原本的第5个元素了。  
	 */    
	public void listRemove2() {    
	    List<Student> students = new ArrayList<Student>();    
	    for (int i=0; i<students.size(); i++) {    
	        if (students.get(i).getId()%3 == 0) {    
	            Student student = students.get(i);    
	            students.remove(student);    
	        }    
	    }    
	}    
	
	
	
	/**  
	 * 使用Iterator的方式可以顺利删除和遍历  
	 */    
	public void iteratorRemove() {    
	    List<Student> students = new ArrayList<Student>();    
	    System.out.println(students);    
	    Iterator<Student> stuIter = students.iterator();    
	    while (stuIter.hasNext()) {    
	        Student student = stuIter.next();    
	        if (student.getId() % 2 == 0)    
	            stuIter.remove();//这里要使用Iterator的remove方法移除当前对象，如果使用List的remove方法，则同样会出现ConcurrentModificationException    
	    }    
	    System.out.println(students);    
	}    
	class Student{
		int id ;
		public int getId(){
			return id;
		}
	}
}

