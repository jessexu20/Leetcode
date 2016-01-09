import java.util.*;
public class CSVParser{
	public String[] parse(String input){
		boolean detect = true;
		List<String> list = new ArrayList<>();
		int i = 0 , j = 0;
		while(j < input.length()){
			if(detect && input.charAt(j)==','){
				if(input.substring(i,j).equals("\'\'"))
					list.add("\'->\'");
				else
					list.add(input.substring(i,j));
				i = j+1;
			}
			if(input.charAt(j)=='\'')
				detect = !detect;
			j++;
		}
		list.add(input.substring(i,j));
		String [] result = new String[list.size()];
		for(int k = 0; k < list.size(); k++){
			result[k] = list.get(k);
		}
		return result;
	}
	public static void main(String args[]){
		CSVParser csv = new CSVParser();
		String str = "a,a'b,c,d'c,'',b";
		String [] result = csv.parse(str);
		for(String s: result)
			System.out.print(s+"\t");
		System.out.println();
	}
	
}