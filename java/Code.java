import java.util.*;
// This is the text editor interface. 
// Anything you type or change here will be seen by the other person in real time.
public class Code{
    public static void main(String args[]){
        String cracker = Code.generate();
        // System.out.println(cracker);
		System.out.println(cracker.length());
    }
    public static String generate(){
    	Set <String> visited = new HashSet<>();
    	StringBuilder sb = new StringBuilder("9999");
    	//10 * 10  * 10 * 10 
    	visited.add(sb.toString());
    	while(visited.size() < 10000){
    		for(int i = 0; i < 10; i++){
    			String sub = sb.substring(sb.length()-3,sb.length());
    			if(visited.add(sub+String.valueOf(i))){
    				sb.append(i);
    				break;
                }
            }
        }
        return sb.toString();
    }

}