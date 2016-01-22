/*
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

For example, given s = "++++", after one move, it may become one of the following states:

[
  "--++",
  "+--+",
  "++--"
]
If there is no valid move, return an empty list [].


Flip Game II
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to determine if the starting player can guarantee a win.

For example, given s = "++++", return true. The starting player can guarantee a win by flipping the middle "++" to become "+--+".

Follow up:
Derive your algorithm's runtime complexity.
*/
public class FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<String>();
        if(s.length()<2) return result;
        for(int i =1;i<s.length();i++){
            char c = s.charAt(i);
            if(s.charAt(i)==s.charAt(i-1) && c=='+'){
                StringBuilder sb= new StringBuilder(s);
                sb.setCharAt(i-1,'-');
                sb.setCharAt(i,'-');
                result.add(sb.toString());
            }
        }
        return result;
    }
    public boolean canWin(String s) {
        for(int i = -1 ;(i=s.indexOf("++",i+1))>-1 && i<s.length();){
            String temp = s.substring(0,i)+"--"+s.substring(i+2,s.length());
            // System.out.println(temp);
            if(!canWin(temp)) return true;
        }
        return false;
    }
}