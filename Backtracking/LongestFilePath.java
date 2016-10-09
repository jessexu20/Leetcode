public class LongestFilePath {
    int max = 0;
	int index = 0;
    public int lengthLongestPath(String input) {
		String x = input.replaceAll("    ","\t");
        String [] paths = x.split("\n");
        helper(paths, 0, 0);
        return max;
    }
    public void helper(String [] path, int level, int len ){
        if(index == path.length)
            return;

        while(index < path.length){
			String cur = path[index];
			//
	    	if(!checkLevel(cur, level))
				return;
			System.out.println(cur + "\t" + (len+getLen(cur, level)) + "\t" + level);
	        if(cur.indexOf('.')!=-1){
		    	max = Math.max(max, len + getLen(cur,level));
				// return;
	        }
			index++;
			helper(path, level + 1, len+getLen(cur, level) + 1);
        }
		
    }
	public boolean checkLevel(String str, int level){
		for(int i = 0; i < level;i++){
			if(i == str.length() || str.charAt(i)!='\t')
				return false;
		}
		return true;
	}
	public int getLen(String str, int level){
		int len = 0;
		for(int i = level; i < str.length(); i++){
			if(str.charAt(i) == '\t')
				len+=4;
			else len+=1;
		}
		return len;
	}
	public static void main(String [] args){
		LongestFilePath lfp = new LongestFilePath();
		
		// System.out.println(lfp.lengthLongestPath("a\n\tb1\n\t\tf1.txt\n\taaaaa\n\t\tf2.txt"));
		System.out.println(lfp.lengthLongestPath("skd\n\talskjv\n\t\tlskjf\n\t\t\tklsj.slkj\n\t\tsdlfkj.sdlkjf\n\t\tslkdjf.sdfkj\n\tsldkjf\n\t\tlskdjf\n\t\t\tslkdjf.sldkjf\n\t\t\tslkjf\n\t\t\tsfdklj\n\t\t\tlskjdflk.sdkflj\n\t\t\tsdlkjfl\n\t\t\t\tlskdjf\n\t\t\t\t\tlskdjf.sdlkfj\n\t\t\t\t\tlsdkjf\n\t\t\t\t\t\tsldkfjl.sdlfkj\n\t\t\t\tsldfjlkjd\n\t\t\tsdlfjlk\n\t\t\tlsdkjf\n\t\tlsdkjfl\n\tskdjfl\n\t\tsladkfjlj\n\t\tlskjdflkjsdlfjsldjfljslkjlkjslkjslfjlskjgldfjlkfdjbljdbkjdlkjkasljfklasjdfkljaklwejrkljewkljfslkjflksjfvsafjlgjfljgklsdf.a"));
	}
}