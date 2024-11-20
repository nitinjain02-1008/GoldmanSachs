package com.GoldmanSacs.Payment;

import java.util.HashMap;
import java.util.Map;

class Node<K,V>{
	
	K key;
	V value;
	Node<K,V> next;
	Node<K,V> prev;
	
	public Node(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

public class LRUImpl<K,V> {	

	int capacity;
	int size;
//	LinkedList<Integer> cache = new LinkedList<Integer>();
	Map<K, Node<K,V>> data ;
	Node<K,V> head;
	Node<K,V> tail;
	
	public LRUImpl(int capacity) {
		this.capacity = capacity;
		data = new HashMap<>();
	}
	
	
	public K put(K key, V value) {
//		if(cache.size()>=capacity) {
//			int keyRemoved = cache.removeLast();
//			data.remove(keyRemoved);
//		}
//		
//		cache.addFirst(key);
//		data.put(key, value);
		
		Node<K,V> node = data.get(key);
		if(node!=null) {
			node.value = value;
			if(node.prev!=null) {
				node.prev.next = node.next;
				addFirst(node);
			}
		}else {
			if(canEvict()) {
				evict();
			}
			
			node = new Node<K,V>(key,value);
			
			if(head == null || tail ==null) {
				head = tail = node;
			}else {
				addFirst(node);
			}
			
			size++;
		}
		data.put(key, node);
		
		return key;
				
	}
	
	private void evict() {
		if(head==null || tail ==null) {
			throw new RuntimeException("cache is Empty");
		}
		
		remove(tail.key);
	}



	private V remove(K key) {
		if(head==null || tail ==null) {
			throw new RuntimeException("cache is Empty");
		}
		
		Node<K,V> nodeRemoved = data.remove(key);
		
		V value = nodeRemoved.value;
		
		if(nodeRemoved.prev!=null) {
			nodeRemoved.prev.next = nodeRemoved.next;
			
		}else {
			head = head.next;
		}
		
		if(nodeRemoved.next!=null) {
			nodeRemoved.next.prev = nodeRemoved.prev;
		}else {
			tail = tail.prev;
		}
		size--;
		
		// head = node.prev;
		// node.prev.next = head;
		return value;
	}



	private boolean canEvict() {
		return size==capacity;
	}

	private void addFirst(Node<K,V> node) {
		node.prev = null;
	//	node.next = head;
		node.next = tail;
		tail.prev = node;
		tail = tail.prev;
	}
	
	V get(K key) {
		Node<K,V> node = data.get(key);
		if(node==null) {
			throw new RuntimeException("No Mapping found");
		}else {
			if(node.prev!=null) {
				node.prev.next = node.next;
				if(node.next!=null) {
					node.next.prev = node.prev;
				}else {
					tail = tail.prev;
				}
				addFirst(node);
			}
		}
		
		return node.value;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}

	public static void main(String[] args) {
		LRUImpl<String, Integer> empCache = new LRUImpl<String, Integer>(5);
		
		empCache.put("Nitin",30);
		empCache.put("Sachin",25);
		empCache.put("Rahul",35);
		empCache.put("Virat",20);
        System.out.println(empCache.toString());
        empCache.put("India",75);
        System.out.println(empCache);
        empCache.put("India",70);
        empCache.put("US",100);
        System.out.println(empCache);
        empCache.get("India");
                
        System.out.println(empCache);
        
       // empCache.get("UK");

	}
	
	@Override
	public String toString() {
		return "LRUImpl [capacity=" + capacity + ", size=" + size + ", data=" + data + ", head=" + head + ", tail="
				+ tail + "]";
	}

}
