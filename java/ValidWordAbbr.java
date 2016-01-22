/*Unique Word Abbreviation
An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example: 
Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
*/

public class ValidWordAbbr {
    HashMap<String,String> map;
    public ValidWordAbbr(String[] dictionary) {
        map= new HashMap<String,String>();
        for(int i =0;i<dictionary.length;i++){
            String t=dictionary[i];
            String key = generateAbbr(t);
            if(map.containsKey(key)) map.put(key,"******");
            else map.put(key,t);
        }
    }
    public boolean isUnique(String word) {
        String abbr=generateAbbr(word);
        if(!map.containsKey(abbr)) return true;
        if(map.containsKey(abbr) && !map.get(abbr).equals("******") && map.get(abbr).equals(word)) return true;
        else return false;
    }
    public String generateAbbr(String word){
        if(word.length()<=2) return word;
        else{
            String s = word.charAt(0)+String.valueOf(word.length()-2)+word.charAt(word.length()-1);
            return s;
        }
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");