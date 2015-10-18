import java.util.*;
public class WordLadder{
    class Word{
        String str;
        int level;
        public Word(String s,int l){
            str=s;
            level=l;
        }
    }
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.length()<1 || endWord.length()<1) return 0;
        Queue<Word> que= new LinkedList<Word>();
        Set<String> visited=new HashSet();
		// System.out.println(wordList);
		Word begin=new Word(beginWord,1);
        que.offer(begin);
        visited.add(beginWord);
        while(!que.isEmpty()){
			Word t=que.poll();
            String w=t.str;
            int l=t.level;
            for(int i =0;i<w.length();i++){
                StringBuilder temp= new StringBuilder(w);
                for(char c='a';c<'z';c++){
                    temp.setCharAt(i,c);
					String s=temp.toString();
                    if(s.equals(endWord)) return l+1;
                    if(wordList.contains(s) && !visited.contains(s)){
						// System.out.println(s);
                        Word word =new Word(s,l+1);
						visited.add(s);
                        que.offer(word);
                    }
                }
            }
			
        }
		return 0;
    }
			//     public int ladderLength(String start, String end, Set<String> dict) {
			//         if (start == null || end == null) return 0;
			//         Queue<String> queue = new LinkedList<>();
			//         Set<String> visited = new HashSet<>();
			//         queue.add(start);
			//         queue.add(null);
			//         visited.add(start);
			//         int len = 1;
			//         while (true) {
			//             String str = queue.remove();
			//             if (str == null) {
			//                 if (queue.isEmpty()) {
			//                     return 0;
			//                 }
			//                 queue.add(null);
			//                 len++;
			//                 continue;
			//             } else if (str.equals(end)) {
			//                 return len;
			//             }
			//             for (int i = 0; i < str.length(); i++) {
			//                 char[] charArray = str.toCharArray();
			//                 for (char c = 'a'; c <= 'z'; c++) { // optional if (c != charArray[i]) condition check here
			//                     charArray[i] = c;
			//                     String newStr = new String(charArray);
			//                     if (dict.contains(newStr) && !visited.contains(newStr)) {
			//                         queue.add(newStr);
			//                         visited.add(newStr);
			//                     }
			//                 }
			//
			//             }
			// System.out.println(visited);
			//         }
			//     }
	public static void main(String args[]){
		WordLadder wl=new WordLadder();
		String start="hit";
		String end="cog";
		Set<String> hashset=new HashSet();
		hashset.add("hot");hashset.add("dot");hashset.add("dog");
		hashset.add("lot");hashset.add("log");
		System.out.println(wl.ladderLength(start,end,hashset));
	}
}