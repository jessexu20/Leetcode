public class FindWords{
	char [][] matrix = {{'a','b','c','d'},
					  {'e','a','f','d'},
					  {'p','q','s','r'},
					  {'o','r','q','a'}};
	public boolean find(String str){
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(helper(str,0,i,j)) return true;
			}
		}
		return false;
	}
	public boolean helper(String str, int index, int x, int y){
		if(index == str.length()) return true;
		if(x<0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
			return false;
		if(matrix[x][y] == str.charAt(index)){
			matrix[x][y] =(char) (matrix[x][y] ^ '&');
			if(helper(str,index+1,x+1,y) || helper(str,index+1,x,y+1) || helper(str,index+1,x-1,y) || helper(str,index+1,x,y-1))
				return true;
			else{
				matrix[x][y] = (char)(matrix[x][y] ^ '&');
			}
		}
		return false;
	}
	public static void main(String args[]){
		FindWords fw = new FindWords();
		System.out.println(fw.find("abafsra"));
	}
}