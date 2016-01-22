package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

public class WordSearchII {
	class TrieNode {
	 // Initialize your data structure here.
		HashMap<Character, TrieNode> map;
	 public TrieNode() {
	     map=new HashMap<Character,TrieNode>();
	 }
	}
    private TrieNode root;

    public WordSearchII() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
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

    public boolean startWith2(TrieNode trieNode,String word) {
        if (word.length()==0) {
			return true;
		}
        if (trieNode.map.containsKey(word.charAt(0))) {
			return startWith2(trieNode.map.get(word.charAt(0)), word.substring(1));
		}
        else return false;
    }
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	if (prefix.length()==0) {
			return true;
		}
        else return startWith2(root, prefix);
    }
    public List<String> findWords(char[][] board, String[] words) {
        if (words.length<1) {
			return new ArrayList<String>();
		}
        
        for (String string : words) {
			insert(string);
		}
        List<String> result=new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				checkWords(board,result,"", i,j,root);
			}
		}
        return result;
    }
    public void checkWords(char[][] board,List<String>res,String temp, int x, int y,TrieNode node){
		if (x > board.length - 1 || x < 0 || y < 0 || y > board[0].length - 1)
			return;
    	if (node.map.containsKey(' ')) {
    		if (!res.contains(temp)) {
    			res.add(temp);
			}
		}
		char tc = board[x][y];
		if (!node.map.containsKey(tc)) {
			return;
		}
		else node=node.map.get(tc);
		temp+=tc;
		board[x][y] = '@';
		checkWords(board, res,temp,  x + 1, y, node);
		checkWords(board, res,temp, x - 1, y, node);
		checkWords(board, res,temp,x, y - 1, node);
		checkWords(board, res,temp, x, y + 1, node);
		checkWords(board, res, temp, x, y, node);
		board[x][y] = tc;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearchII ws=new WordSearchII();
//		char[][] board = { { 'o', 'a', 'a', 'n' },
//						{ 'e', 't', 'a', 'e' },
//						{ 'i', 'h', 'k', 'r' },
//						{ 'i', 'f', 'l', 'v' } };
		char [][] board={{'a','b'},{'a','a'}};
//		String []words={"oath","pea","eat","rain"};
		String [] words={"aba","baa","bab","aaab","aaa","aaaa","aaba"};
		List<String> list =ws.findWords(board, words);
		if (list!=null) {
			for (String string : list) {
				System.out.println(string);
			}
		}
	}

}
