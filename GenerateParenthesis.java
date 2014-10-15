package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
    	int left=n,right=n;
    	ArrayList<String> list=new ArrayList<String>();
    	genList(left, right,"", list,' ');
		return list;
    }
    public void genList(int l,int r,String str, ArrayList<String>listStrings,char x){
    	str+=x;
    	if (l==0 && r==0){
    		if (str!=null)
    			listStrings.add(str.trim());
    		return;
    	}
    	if (l==r){
    		genList(l-1, r, str,listStrings,'(');
    	}
    	else if(l==0){
    		genList(l, r-1, str, listStrings, ')');
    	}
    	else {
			genList(l-1, r, str, listStrings,'(');
			genList(l, r-1, str, listStrings,')');
		}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis generateParenthesis=new GenerateParenthesis();
		generateParenthesis.generateParenthesis(5);
	}

}
