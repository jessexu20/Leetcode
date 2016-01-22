import java.util.*;
public class WordLadderII {
    List<List<String>> results;
    List<String> list;
    Map<String,List<String>> map;
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        results= new ArrayList<List<String>>();
        if (wordList.size() == 0)
            return results;

        int curr=1,next=0;    //current combination and next level combination 
		/*
				hit=>hot ->cur=1,next=1;
			    hot -> lot
				hot -> dot 
				}=> curr=1,next =2 
			
		*/     
        boolean found=false;            
        list = new LinkedList<String>();           
        map = new HashMap<String,List<String>>();

        Queue<String> queue= new LinkedList<String>();
        Set<String> unvisited = new HashSet<String>(wordList);
        Set<String> visited = new HashSet<String>();

        queue.add(beginWord);           
        unvisited.add(endWord);
        unvisited.remove(beginWord);
        //BFS
        while (!queue.isEmpty()) {

            String word = queue.poll();
            curr--;             
            for (int i = 0; i < word.length(); i++){
               StringBuilder builder = new StringBuilder(word); 
                for (char ch='a';  ch <= 'z'; ch++){
                    builder.setCharAt(i,ch);
                    String new_word=builder.toString(); 
                    if (unvisited.contains(new_word)){
                        //Handle queue
                        if (visited.add(new_word)){//Key statement,Avoid Duplicate queue insertion
                            next++;
                            queue.add(new_word);
                        }

                        if (map.containsKey(new_word))//Build Adjacent Graph
                            map.get(new_word).add(word);
                        else{
                            List<String> l= new LinkedList<String>();
                            l.add(word);
                            map.put(new_word, l);
                        }

                        if (new_word.equals(endWord)&&!found) found=true;       
                    }

                }//End:Iteration from 'a' to 'z'
            }//End:Iteration from the first to the last
			// System.out.println(map+"\t"+"current="+curr+"\t"+"next="+next);
			// System.out.println("visited"+visited+"\t"+"unvisited"+unvisited);
            if (curr==0){
                if (found) break;
                curr=next;
                next=0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }//End While
		// System.out.println(map);
        backTrace(endWord,beginWord);

        return results;  
    }
    private void backTrace(String word,String beginWord){//using dfs to reversely traverse the hashtable
        if (word.equals(beginWord)){
            list.add(0,beginWord);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0,word);
        if (map.get(word)!=null)
            for (String s:map.get(word))
                backTrace(s,beginWord);
        list.remove(0);
    }
	public static void main(String args []){
		WordLadderII wl=new WordLadderII();
		Set<String> set = new HashSet();
		set.add("hot");set.add("dot");set.add("dog");set.add("log");set.add("lot");
		String start="hit",end="cog";
		System.out.println(wl.findLadders(start,end,set));
	}
}