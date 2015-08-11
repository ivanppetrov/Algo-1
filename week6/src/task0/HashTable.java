package task0;

import java.util.List;

public class HashTable<K, V> {
	private static final int INITIAL_SIZE = 1000;
	private int size;
	private List<V>[] table;
	
	public HashTable() {
		this.table = new List[INITIAL_SIZE];
		this.size = table.length;
	}
	
	private int getHash(K key) {
		return size;
		
	}
	
	public void put(K key, V value) {
		
	}
}
