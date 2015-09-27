public class ZigZag {
    public String convert(String s, int numRows) {
        if(numRows<2)
            return s;
        String [] rows=new String[numRows];
        Arrays.fill(rows,"");
        int gap= 2*numRows-2;
        for(int i=0;i<s.length();i+=gap){
            rows[0]+=s.charAt(i);
            for(int j=1;j<numRows-1;j++){
                if(i+j<s.length())
                    rows[j]+=s.charAt(i+j);
                if(i+gap-j<s.length())
                    rows[j]+=s.charAt(i+gap-j);
            }
            if(i+numRows-1<s.length())
                rows[numRows-1]+=s.charAt(i+numRows-1);
        }
        String res="";
        for(String str:rows){
            res+=str;
        }
        return res;
    }
}