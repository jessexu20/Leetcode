package leetcode;
import java.util.HashMap;
public class WordDictionary {
    private TrieNode root=new TrieNode();
	class TrieNode {
		HashMap<Character, TrieNode> map;
	    public TrieNode() {
	        map=new HashMap<Character,TrieNode>();
	    }
	}
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word.length()>=1) {
			insert2(root, word);
		}
        else{
			return;
		}
    }
    public void insert2(TrieNode trieNode,String word){
    	if (word.length()==0) {
    		trieNode.map.put(' ', null);
			return;
		}
    	if (trieNode.map.containsKey(word.charAt(0))) {
			insert2(trieNode.map.get(word.charAt(0)), word.substring(1));
		}
    	else {
			trieNode.map.put(word.charAt(0), new TrieNode());
			insert2(trieNode.map.get(word.charAt(0)), word.substring(1));
		}
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length()==0) {
			return true;
		}
        else return search2(root, word);
    }
    public boolean search2(TrieNode trieNode,String word){
    	if (word.length()==0) {
    		if (trieNode.map.containsKey(' ')) {
				return true;
			}
			return false;
		}
    	if (word.charAt(0)=='.') {
    		boolean flag=false;
    		for (TrieNode node : trieNode.map.values()) {
    			if (node!=null) {
    				flag=flag || search2(node, word.substring(1));
				}
			}
			return flag;
		}
    	else if (trieNode.map.containsKey(word.charAt(0))) {
			return search2(trieNode.map.get(word.charAt(0)), word.substring(1));
		}
        else return false;
    }
	public static void main(String args[]){
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("a");
		wordDictionary.addWord("a");
		System.out.println(wordDictionary.search("."));
		System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search("aa"));
		System.out.println(wordDictionary.search("a"));
		System.out.println(wordDictionary.search(".a"));
		System.out.println(wordDictionary.search("a."));
	}
}

// Your WordDictionary object will be instantiated and called as such:
