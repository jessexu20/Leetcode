public class Solution {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() < 1)
            return result;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1: 1);
        }
        boolean odd = false;
        String temp = "";
        for(char key: map.keySet()){
            if(map.get(key) % 2 != 0){
                if(odd)
                    return result;
                else{
                    odd = true;
                    temp += key;
                    map.put(key, map.get(key) - 1);
                }
            }
        }
        helper(result, temp, s.length());
        return result;
    }
    public void helper(List<String> result, String temp,len){
        if(temp.length() == len){
            result.add(temp);
            return;
        }
        for(char key: map.keySet()){
            if(map.get(key) > 1){
                map.put(key, map.get(key) - 2);
                helper(result, "" + key + temp + c, len);
                map.put(key, map.get(key) + 2);
            }
        }
    }
}