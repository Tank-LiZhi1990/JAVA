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
		// Arraylists��һ���ɱ�����,�и�Ч�ķ��ʺ͵�Ч�Ĳ���ɾ��,��ȡ˳��Ͳ���˳��һ��
		collection = new ArrayList<>();
		System.out.println(collection instanceof RandomAccess);// true
		// �̰߳�ȫ,�����޸�ʱ��Ȼʹ�á�����,�����ڶ��߶���д�ߺܶ�����
		collection = new CopyOnWriteArrayList<>();
		// ˫���б�,֧�ָ�Ч�Ĳ����ɾ��,�����е�Ч�ķ���,JDK1.4��ʵ��RandomAccess�Ľӿڱ�ʶʵ�ֵ���֧�ָ�Ч�������.
		// �����ظ�ֵ,����null,����
		collection = new LinkedList<>();
		System.out.println(collection instanceof RandomAccess);// false
		// �����ṩͬ��,������Arraylist��ͬ,�̰߳�ȫ������Ч��,���������ʹ��Arraylist
		collection = new Vector<>();
		// �̳���vector,Ҳ���̰߳�ȫ��,�����Ѿ����Ƽ�ʹ��,�Ƽ�ʹ��deque.
		collection = new Stack<>();// vector-stack

		// set
		// ���������ظ�ֵ,������һ��null,���Կ��ٲ��Ҷ���,���ǲ��ܿ��Ƽ���������˳��
		collection = new HashSet<>();
		// �̳���hashset,����ͨ���������˳���������
		collection = new LinkedHashSet<>();
		// �������ظ�,����һ��null,�����Ķ����Ǿ���������һ������,��˱������ʵ��comparable�ӿ�,����ָ��������߽������
		collection = new TreeSet<>();
		// ��һ�����ݽṹ,����,ÿ���ڵ�洢����k���ڵ�ĵ�ַ,����ʱ��������,����ʱ�临�Ӷ�k/n+1,�ռ任ʱ��,�Ƕ������������չ
		// Ҫʵ��comparable�ӿ�
		collection = new ConcurrentSkipListSet<>();
		// �̰߳�ȫ��,�ڲ���CopyOnWriteArrayList,��������ͬ����
		collection = new CopyOnWriteArraySet<String>();
		// enumSetֻ�ܰ���ĳ��ö�����͵Ķ���,���������ظ�ֵ,������null,����˳���붨���һ��.

		Map<Object, Object> map;
		// hashmap
		// ����nullֵ��null��,�ŵ��ǿ��Կ��ٲ��Ҷ���,ȱ�����޷����ƶ�����map�е�˳��.
		map = new HashMap<>();
		// �̳���hashmap,���԰��ն���Ĳ���˳��ͷ���˳�����,ȡ���ڹ��캯������capacity/loadfactor;accessorder���Ը��ݶ���ķ���Ƶ������
		map = new LinkedHashMap<>();

		// ���map�м�����û��ʵ��equals(equals����Ϊ��==һ��),�����map��û�����������,�����ܲ���map�е����Ԫ��
		// ��������������������������Ԫ��,��weakHashMap�е����ֶ��󽫻ᱻ��������������,����֮���hashmapû������
		map = new WeakHashMap<>();

		// �̰߳�ȫ��,��Զ������ס������,��ֻ����סĳ��Ƭ��,����˲�����,������ֻ�ǵ�������������ʱ��״̬,���ݸı��˵������������õľɵ�����,������nullֵ��null��
		map = new ConcurrentHashMap<>();

		// ��hashmap����equals�жϼ������,��identityHashMap����==�ж�,����û������
		map = new IdentityHashMap<Object, Object>();

		// ���Ǿ��������,�γ���״�ṹ,����Ķ���Ҫʵ��comparable�ӿ�,���ṩ�˰��������ķ���.
		map = new TreeMap<>();

		// ����������Ļ�������չ,����˲����ض�ֵ���ѵ�����,ͬconcurrentSkipListSet();�̰߳�ȫ,��������null����nullֵ
		// �����Ԫ��Ҫʵ��comparable�ӿ�,����ʱ���ݸ��Ļ��ǵ����ɵ�ֵ,�����̰߳�ȫ��.
		map = new ConcurrentSkipListMap<Object, Object>();

		// enumMap������null��,����nullֵ,���ļ�����Ϊĳ��ö������

		// hashtable
		// ��hashset��������hashtable���߳�ͬ����;���Ҳ�������nullֵ��null��
		map = new java.util.Hashtable<>();
		map = new java.util.Properties();

		// java����Щ���е�ʵ�ֲ����Ƚ��ȳ���.
		Queue queue;
		// Ԫ���Ǿ��������.Ԫ�ر���ʵ��comparable�ӿ�,��ָ���Ƚ���;����Ԫ��ʱ˳������,����poll\remove\peek����������С��,�����ǵ�����˳���ǲ�ȷ����
		// û����������,������null(��null�ж��Ƿ���Ԫ��);���̰߳�ȫ��;�����������������
		queue = new PriorityQueue<>();

		// �̰߳�ȫ��,û����������,������nullֵ;ֻ������������ʱ������,���º��ǵ���������
		queue = new ConcurrentLinkedQueue<Object>();

		// ��������,�̰߳�ȫ,��������ʱ,put������ֱ���пռ�Ϊֹ,���п���take������ֱ��������Ϊֹ,��������-������
		// ��Ҫ�ڷ����ݽ���������ʶ����ָʾ���ݷ���,�Ա��������Զ�ֹͣ.

		// �ײ�ʹ������
		queue = new LinkedBlockingQueue<Object>();
		// �ṩ�̰߳�ȫ������,������priorityȴҲ����
		queue = new PriorityBlockingQueue<>();

		// �ײ�ʹ���������ݽṹ
		queue = new ArrayBlockingQueue<Object>(1);

		// �������е�Ԫ�ر���ʵ��Delayed�ӿ�,ֻ�е��ڵ�Ԫ�ز��ܱ�ȡ��,����ȡ�����ǵ���ʱ�����Ԫ��
		queue = new DelayQueue<>();

		// ���������κ�Ԫ��,�������ֱ����һ���̶߳�ȡ,�����߳�ͬ������
		queue = new SynchronousQueue<Object>();

		// ���Ե���linkedBlockingQueue��SynchronousQueueʹ��,�ȿ����ڶ���̼߳�ͬ����������Ҳ�����첽��������
		queue = new LinkedTransferQueue<E>();

		// Deque,˫�˶���,double ended queue,�ȿ��������Ƚ��ȳ��Ķ���Ҳ������������ȳ���ջ
		Deque<Object> deque;
		// �ײ�������ʵ��
		deque = new ArrayDeque<>();

		// �ײ�������
		deque = new LinkedList<>();

		// �����̰߳�ȫ��,��linkedList����
		deque = new ConcurrentLinkedDeque<Object>();

		// �ײ�������������˫�˶���
		deque = new LinkedBlockingDeque<Object>();

		// Arrays Collections
		// ������,�ṩ�ܶྲ̬����
		// Arrays.asList List.toArray
		// ͬ��:Collections.synchronizedCollection/map/list/set/sortedMap/sortedSet
		// ֻ��:Collections.unmodifiableMap/Collection/list/set/sortedMap/sortedSet
		// ����:Collections.sort/reverseOrder/shuffle
	}
}
