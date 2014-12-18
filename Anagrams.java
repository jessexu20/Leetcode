import java.util.*;
public class Anagrams{
	public String calStringValue(String str){
		int [] count= new int [26];
		String result="";
		for(int i=0; i<26; i++){
			count[i]=0;
		}
		for(int i=0; i<str.length();i++){
			int num=str.charAt(i)-'a';
			count[num]+=1;
		}
		for(int i=0; i<26; i++){
			if(count[i]<10){
				result=result+"0"+Integer.toString(count[i]);
			}
			else if(count[i]>=100)
				result=result+Integer.toString(count[i]%100);
			else
				result=result+Integer.toString(count[i]);
		}
		return result;
	}
    public List<String> anagrams(String[] strs) {
        HashMap <String,String> hashmap=new HashMap();
		List <String> list=new ArrayList();
		List <String> hash=new ArrayList();
		for(int i=0; i<strs.length;i++){
			String hashcode=calStringValue(strs[i]);
			if(hashmap.containsKey(hashcode)){
				String oldString=hashmap.get(hashcode);
				list.add(strs[i]);
				if(!hash.contains(oldString)){
					hash.add(oldString);
				}
			}
			else{
				hashmap.put(hashcode,strs[i]);
			}
		}
		for(int i=0;i<hash.size();i++){
			list.add(hash.get(i));
		}
		return list;
    }
	public static void main(String args[]){
		Anagrams ag=new Anagrams();
		String []input={"rinses","balm","doer","gush","haydn","rafts","raga","chastens","alva","terracing","dialects","pizazz","luann","posers","ankhs","obsequies","withers","retraces","damien","thickest","coursing","wears","lifers","ringlets","flatcar","severed","heston","dryer","unison","maddens","inset","rifles","grip","croesus","spine","tied","enrico","wee","salesmen","aisled","kramer","males","lives","carmine","brandeis","sumerian","snip","leg","halters","carets","spoke","pooling","saar","strewed","rudest","rape","hums","irksome","bets","trouts","lees","latitude","continued","treatise","scant","ashe","fringes","pleat","orientals","salver","shari","takeout","tacos","lasted","using","bombing","steined","romero","regroup","raped","tsar","usual","brutes","saliva","art","shade","churl","nit","listed","shiver","vazquez","debra","roger","newsed","resumption","raspier","shale","ra","whizz","south","clouts","spared","mortise","spotter","batsman","penalties","west","dean","great","adorn","hank","stab","taster","stakeout","redness","wiled","chaste","cronies","armenian","pointer","pepsi","hustle","roam","note","sobers","ates","hurled","cheers","stifle","configures","lanker","hydra","naivest","odom","resins","lamb","redo","hugs","handy","frats","agra","stanches","lava","retracing","citadels","dizzying","annul","proses","hanks","essequibo","writhes","caterers","median","thickset","sourcing","wares","fliers","sterling","fractal","deserve","honest","ryder","unions","demands","stein","prig","courses","penis","tide","corine","ewe","maleness","ideals","remark","salem","veils","crimean","brandies","aneurism","pins","gel","slather","recast","pokes","looping","sara","wrested","rusted","pear","mush","smokier","best","tutors","eels","altitude","unnoticed","iterates","cants","shea","fingers","petal","relations","slaver","hairs","outtake","tosca","deltas","ginsu","mobbing","destine","roomer","grouper","padre","arts","luaus","tubers","avails","rat","heads","lurch","tin","idlest","shrive","bared","regor","sweden","importunes","rapiers","hales","ar","shout","locust","spread","moister","potters","bantams","palestine","stew","edna","greta","ronda","khan","bast","treats","outtakes","senders","wield","sachet","ericson","annmarie","protein","pipes","sleuth","omar","tone","bosser","sate","hurdle","escher","filets","refocusing","rankle","hardy","vainest","mood"};
		// String[] input={"lactated","bust","ardent","repackage","stiflings","overjoying","tramps","lactated","abuts","ranted","repackage","stiflings","overjoying","tramps"};
		System.out.println(ag.anagrams(input));
	}
}