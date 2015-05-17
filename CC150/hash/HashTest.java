package hash;

public class HashTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hash<String, Integer> hash=new Hash<>();
		hash.put("a", 1);
		hash.put("b", 1);
		hash.put("a", 2);
		hash.traverseKey();
	}

}
