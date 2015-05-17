package hash;

public class Cell<K,V> {
	private K key;
	private V value;
	public Cell(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key=key;
		this.value=value;
	}
	public boolean equivalent(Cell<K, V>c){
		return equivalent(c.getKey());
	}
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}
	public boolean equivalent(K k) {
		return key.equals(k);
	}
	public V getValue() {
		return value;
	}


}
