package hash;

import java.util.LinkedList;


public class Hash<K, V> {
	private final int MAX_SIZE=10;
	private LinkedList<Cell<K,V>> [] items;
	public Hash(){
		items=(LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
		
	}
	public int hashCodeofKey(K key){
		return key.toString().length() % items.length;
	}
	public void put(K key,V value){
		int x=hashCodeofKey(key);
		if (items[x]==null) {
			items[x]=new LinkedList<Cell<K, V>>();
		}
		LinkedList<Cell<K, V>> collisionCells=items[x];
		for (Cell<K, V> cell : collisionCells) {
			if (cell.equivalent(key)) {
				collisionCells.remove(cell);
				break;
			}
		}
		Cell<K, V> c=new Cell<K,V>(key,value);
		collisionCells.add(c);
	}
	public V get(K key) {
		int x=hashCodeofKey(key);
		if (items[x]==null) {
			return null;
		}
		LinkedList<Cell<K, V>> collidedCells=items[x];
		for (Cell<K, V> cell : collidedCells) {
			if (cell.equivalent(key)) {
				return cell.getValue();
			}
		}
		return null;
	}
	public void traverseKey(){
		for (LinkedList<Cell<K, V>> list : items) {
			if (list!=null) {
				for (Cell<K, V> cell : list) {
					System.out.println(cell.getValue());
				}
			}
		}
	}
}

