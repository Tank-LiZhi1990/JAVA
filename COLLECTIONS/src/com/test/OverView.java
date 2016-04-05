package com.test;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.WeakHashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class OverView {

	public static <E> void main(String[] args) {

		Collection<String> collection;
		// list
		// Arraylists是一个可变数组,有高效的访问和低效的插入删除,读取顺序和插入顺序一致
		collection = new ArrayList<>();
		System.out.println(collection instanceof RandomAccess);// true
		// 线程安全,数据修改时依然使用○引用,适用于读者多于写者很多的情况
		collection = new CopyOnWriteArrayList<>();
		// 双向列表,支持高效的插入和删除,但是有低效的访问,JDK1.4起实现RandomAccess的接口标识实现的类支持高效随机访问.
		// 允许重复值,允许null,有序
		collection = new LinkedList<>();
		System.out.println(collection instanceof RandomAccess);// false
		// 可以提供同步,其他和Arraylist相同,线程安全带来低效率,非特殊情况使用Arraylist
		collection = new Vector<>();
		// 继承自vector,也是线程安全的,现在已经不推荐使用,推荐使用deque.
		collection = new Stack<>();// vector-stack

		// set
		// 不允许有重复值,允许有一个null,可以快速查找对象,但是不能控制集合里对象的顺序
		collection = new HashSet<>();
		// 继承自hashset,可以通过对象插入顺序迭代对象
		collection = new LinkedHashSet<>();
		// 不允许重复,允许一个null,包含的对象是经过排序变成一个树的,因此必须对象实现comparable接口,可以指定升序或者降序迭代
		collection = new TreeSet<>();
		// 是一种数据结构,跳表,每个节点存储后面k个节点的地址,遍历时可以跳过,最坏情况时间复杂度k/n+1,空间换时间,是对有序链表的拓展
		// 要实现comparable接口
		collection = new ConcurrentSkipListSet<>();
		// 线程安全的,内部是CopyOnWriteArrayList,与其有相同特性
		collection = new CopyOnWriteArraySet<String>();
		// enumSet只能包含某种枚举类型的对象,不允许有重复值,不允许null,迭代顺序与定义的一致.

		Map<Object, Object> map;
		// hashmap
		// 允许null值和null键,优点是可以快速查找对象,缺点是无法控制对象在map中的顺序.
		map = new HashMap<>();
		// 继承自hashmap,可以按照对象的插入顺序和访问顺序迭代,取决于构造函数参数capacity/loadfactor;accessorder可以根据对象的访问频率排序
		map = new LinkedHashMap<>();

		// 如果map中键对象没有实现equals(equals的行为和==一致),如果在map外没有这个键对象,将不能查找map中的这个元素
		// 但是垃圾回收器并不会回收这个元素,在weakHashMap中的这种对象将会被垃圾回收器回收,除此之外和hashmap没有区别
		map = new WeakHashMap<>();

		// 线程安全的,永远不会锁住整个表,而只是锁住某个片段,提高了并发性,迭代器只是迭代创建迭代器时的状态,数据改变了迭代器还是引用的旧的数据,不允许null值和null键
		map = new ConcurrentHashMap<>();

		// 在hashmap中用equals判断键的相等,在identityHashMap中用==判断,其他没有区别
		map = new IdentityHashMap<Object, Object>();

		// 键是经过排序的,形成树状结构,加入的对象要实现comparable接口,还提供了按键检索的方法.
		map = new TreeMap<>();

		// 在有序链表的基础上拓展,解决了查找特定值困难的问题,同concurrentSkipListSet();线程安全,不允许有null键和null值
		// 加入的元素要实现comparable接口,迭代时数据更改还是迭代旧的值,它是线程安全的.
		map = new ConcurrentSkipListMap<Object, Object>();

		// enumMap不允许null键,允许null值,它的键必须为某个枚举类型

		// hashtable
		// 与hashset的区别是hashtable是线程同步的;而且不允许有null值和null键
		map = new java.util.Hashtable<>();
		map = new java.util.Properties();

		// java中有些队列的实现不是先进先出的.
		Queue queue;
		// 元素是经过排序的.元素必须实现comparable接口,或指定比较器;加入元素时顺序任意,但是poll\remove\peek返回总是最小的,迭代是迭代的顺序是不确定的
		// 没有容量限制,不允许null(用null判断是否还有元素);非线程安全的;典型例子是任务调度
		queue = new PriorityQueue<>();

		// 线程安全的,没有容量限制,不允许null值;只迭代创建迭代时的数据,更新后还是迭代旧数据
		queue = new ConcurrentLinkedQueue<Object>();

		// 阻塞队列,线程安全,当队列满时,put会阻塞直到有空间为止,队列空是take会阻塞直到有数据为止,简化了生产-消费者
		// 需要在放数据结束后放入标识数据指示数据放完,以便消费者自动停止.

		// 底层使用链表
		queue = new LinkedBlockingQueue<Object>();
		// 提供线程安全和阻塞,其他和priority却也相似
		queue = new PriorityBlockingQueue<>();

		// 底层使用数组数据结构
		queue = new ArrayBlockingQueue<Object>(1);

		// 加入其中的元素必须实现Delayed接口,只有到期的元素才能被取出,最先取出的是到期时间最长的元素
		queue = new DelayQueue<>();

		// 不能容纳任何元素,插入操作直到另一个线程读取,用于线程同步数据
		queue = new SynchronousQueue<Object>();

		// 可以当做linkedBlockingQueue或SynchronousQueue使用,既可以在多个线程间同步传递数据也可以异步传递数据
		queue = new LinkedTransferQueue<E>();

		// Deque,双端队列,double ended queue,既可以用作先进先出的队列也可以用做后进先出的栈
		Deque<Object> deque;
		// 底层用数组实现
		deque = new ArrayDeque<>();

		// 底层用链表
		deque = new LinkedList<>();

		// 除了线程安全外,和linkedList很像
		deque = new ConcurrentLinkedDeque<Object>();

		// 底层采用链表的阻塞双端队列
		deque = new LinkedBlockingDeque<Object>();

		// Arrays Collections
		// 工具类,提供很多静态方法
		// Arrays.asList List.toArray
		// 同步:Collections.synchronizedCollection/map/list/set/sortedMap/sortedSet
		// 只读:Collections.unmodifiableMap/Collection/list/set/sortedMap/sortedSet
		// 排序:Collections.sort/reverseOrder/shuffle
	}
}
