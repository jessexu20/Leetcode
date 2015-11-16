/*Shortest Word Distance III
This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “makes”, word2 = “coding”, return 1.
Given word1 = "makes", word2 = "makes", return 3.

*/
public class ShortestWordDistance {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        boolean same=false,flag = true;
        if(word1.equals(word2)) same=true;
        int id1=-1,id2=-1,length=words.length;
        for(int i = 0; i < words.length; i++){
            if(same){
                if(words[i].equals(word1)){
                    if(flag){
                        id1=i;
                    }
                    else id2=i;
                    flag=!flag;
                } 
                else continue;
                if(id1!=-1 && id2!=-1){
                    length=Math.min(Math.abs(id2-id1),length);
                }
            }else{
                if(words[i].equals(word1)) id1=i;
                else if(words[i].equals(word2)) id2=i;
                else continue;
                if(id1!=-1 && id2!=-1){
                    length=Math.min(Math.abs(id2-id1),length);
                }
            }
        }
        return length;
    }
}