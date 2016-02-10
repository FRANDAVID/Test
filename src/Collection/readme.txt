http://www.cnblogs.com/skywang12345/p/3323085.html
http://blog.csdn.net/crave_shy/article/details/17416791
http://www.cnblogs.com/skywang12345/p/3603935.html 数据结构和算法目录

Collection
     ├List                                     /**允许重复的value集合*/
     │├LinkedList                        /**用双向链表实现*/
     │├ArrayList                          /**非同步，用数组实现，自增为原来长度的50%*/
     │└Vector                             /**同步，用数组实现，自增为原来的一倍*/
     │　└Stack                           /**用vector实现栈结构*/
     └Set                                    /**不允许重复的value集合*/
        ├HashSet
        ├LinkedHashSet
        └TreeSet

     Map                                    /**不允许重复的key-value集合*/
     ├Hashtable                         /**同步，key-value，不允许key为null*/
     ├HashMap                          /**非同步，key-value，允许key为null*/
     └WeakHashMap

java 集合系列
1. List的实现类主要有: LinkedList, ArrayList, Vector, Stack。

(01) LinkedList是双向链表实现的双端队列；它不是线程安全的，只适用于单线程。
(02) ArrayList是数组实现的队列，它是一个动态数组；它也不是线程安全的，只适用于单线程。
(03) Vector是数组实现的矢量队列，它也一个动态数组；不过和ArrayList不同的是，Vector是线程安全的，它支持并发。
(04) Stack是Vector实现的栈；和Vector一样，它也是线程安全的。

 

2. Set的实现类主要有: HastSet和TreeSet。

(01) HashSet是一个没有重复元素的集合，它通过HashMap实现的；HashSet不是线程安全的，只适用于单线程。
(02) TreeSet也是一个没有重复元素的集合，不过和HashSet不同的是，TreeSet中的元素是有序的；它是通过TreeMap实现的；TreeSet也不是线程安全的，只适用于单线程。

 

3.Map的实现类主要有: HashMap，WeakHashMap, Hashtable和TreeMap。

(01) HashMap是存储“键-值对”的哈希表；它不是线程安全的，只适用于单线程。
(02) WeakHashMap是也是哈希表；和HashMap不同的是，HashMap的“键”是强引用类型，而WeakHashMap的“键”是弱引用类型，也就是说当WeakHashMap 中的某个键不再正常使用时，会被从WeakHashMap中被自动移除。WeakHashMap也不是线程安全的，只适用于单线程。
(03) Hashtable也是哈希表；和HashMap不同的是，Hashtable是线程安全的，支持并发。
(04) TreeMap也是哈希表，不过TreeMap中的“键-值对”是有序的，它是通过R-B Tree(红黑树)实现的；TreeMap不是线程安全的，只适用于单线程。
更多关于这些集合类的介绍，可以参考“Java 集合系列目录(Category)”。

(01) CopyOnWriteArrayList相当于线程安全的ArrayList，它实现了List接口。CopyOnWriteArrayList是支持高并发的。
(02) CopyOnWriteArraySet相当于线程安全的HashSet，它继承于AbstractSet类。
CopyOnWriteArraySet内部包含一个CopyOnWriteArrayList对象，它是通过CopyOnWriteArrayList实现的

(01) ConcurrentHashMap是线程安全的哈希表(相当于线程安全的HashMap)；它继承于AbstractMap类，并且实现ConcurrentMap接口。ConcurrentHashMap是通过“锁分段”来实现的，它支持并发。
(02) ConcurrentSkipListMap是线程安全的有序的哈希表(相当于线程安全的TreeMap); 它继承于AbstractMap类，并且实现ConcurrentNavigableMap接口。ConcurrentSkipListMap是通过“跳表”来实现的，它支持并发。
(03) ConcurrentSkipListSet是线程安全的有序的集合(相当于线程安全的TreeSet)；它继承于AbstractSet，并实现了NavigableSet接口。ConcurrentSkipListSet是通过ConcurrentSkipListMap实现的，它也支持并发。

(01) ArrayBlockingQueue是数组实现的线程安全的有界的阻塞队列。
(02) LinkedBlockingQueue是单向链表实现的(指定大小)阻塞队列，该队列按 FIFO（先进先出）排序元素。
(03) LinkedBlockingDeque是双向链表实现的(指定大小)双向并发阻塞队列，该阻塞队列同时支持FIFO和FILO两种操作方式。
(04) ConcurrentLinkedQueue是单向链表实现的无界队列，该队列按 FIFO（先进先出）排序元素。
(05) ConcurrentLinkedDeque是双向链表实现的无界队列，该队列同时支持FIFO和FILO两种操作方式。

(06) LinkedList可以作为FIFO(先进先出)的队列，作为FIFO的队列时，下表的方法等价：

	
	队列方法       等效方法
	
	add(e)        addLast(e)
	offer(e)      offerLast(e)
	remove()      removeFirst()
	poll()        pollFirst()
	element()     getFirst()
	peek()        peekFirst()
	
	(07) LinkedList可以作为LIFO(后进先出)的栈，作为LIFO的栈时，下表的方法等价：

	栈方法        等效方法
	push(e)      addFirst(e)
	pop()        removeFirst()
	peek()       peekFirst()











