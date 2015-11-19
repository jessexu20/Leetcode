/*Group Shifted Strings
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the ##TODO lexicographic order.
*/

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap();
        List<List<String>> list = new ArrayList();
        for(String str: strings){
            String key = generateCode(str);
            if(map.containsKey(key))
                map.get(key).add(str);
            else{
                List<String> t = new ArrayList();
                t.add(str);
                map.put(key,t);
            }
        }
        for(String key: map.keySet()){
            Collections.sort(map.get(key));
            list.add(map.get(key));
        }
        return list;
    }
    public String generateCode(String str){
        StringBuilder sb = new StringBuilder();
        sb.append('a');
        for(int i = 1; i < str.length();i++){
            int diff = str.charAt(i)-str.charAt(0);
            char c = (char)('a' + (diff+26) %26);
            sb.append(c);
        }
        return sb.toString();
    }
}