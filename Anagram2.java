import java.util.*;

public class Anagram2 {
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<>();
		HashMap<String, ArrayList<Integer>> map=new HashMap<>();
		for (int i=0;i<strs.length;i++) {
			char [] str=strs[i].toCharArray();
			Arrays.sort(str);
			String reString=new String(str);
			if (map.get(reString)==null) {
				ArrayList<Integer> position=new ArrayList<>();
				position.add(i);
				map.put(reString, position);
			}
			else {
				map.get(reString).add(i);
			}
		}
		for (ArrayList<Integer> pos : map.values()) {
			if (pos.size()>1) {
				for (Integer integer : pos) {
					result.add(strs[integer]);
				}
			}
		}
		return result;
	}

	public static void main(String args[]) {
		Anagram2 ag = new Anagram2();
		String[] input = { "rinses", "balm", "doer", "gush", "haydn", "rafts",
				"raga", "chastens", "alva", "terracing", "dialects", "pizazz",
				"luann", "posers", "ankhs", "obsequies", "withers", "retraces",
				"damien", "thickest", "coursing", "wears", "lifers",
				"ringlets", "flatcar", "severed", "heston", "dryer", "unison",
				"maddens", "inset", "rifles", "grip", "croesus", "spine",
				"tied", "enrico", "wee", "salesmen", "aisled", "kramer",
				"males", "lives", "carmine", "brandeis", "sumerian", "snip",
				"leg", "halters", "carets", "spoke", "pooling", "saar",
				"strewed", "rudest", "rape", "hums", "irksome", "bets",
				"trouts", "lees", "latitude", "continued", "treatise", "scant",
				"ashe", "fringes", "pleat", "orientals", "salver", "shari",
				"takeout", "tacos", "lasted", "using", "bombing", "steined",
				"romero", "regroup", "raped", "tsar", "usual", "brutes",
				"saliva", "art", "shade", "churl", "nit", "listed", "shiver",
				"vazquez", "debra", "roger", "newsed", "resumption", "raspier",
				"shale", "ra", "whizz", "south", "clouts", "spared", "mortise",
				"spotter", "batsman", "penalties", "west", "dean", "great",
				"adorn", "hank", "stab", "taster", "stakeout", "redness",
				"wiled", "chaste", "cronies", "armenian", "pointer", "pepsi",
				"hustle", "roam", "note", "sobers", "ates", "hurled", "cheers",
				"stifle", "configures", "lanker", "hydra", "naivest", "odom",
				"resins", "lamb", "redo", "hugs", "handy", "frats", "agra",
				"stanches", "lava", "retracing", "citadels", "dizzying",
				"annul", "proses", "hanks", "essequibo", "writhes", "caterers",
				"median", "thickset", "sourcing", "wares", "fliers",
				"sterling", "fractal", "deserve", "honest", "ryder", "unions",
				"demands", "stein", "prig", "courses", "penis", "tide",
				"corine", "ewe", "maleness", "ideals", "remark", "salem",
				"veils", "crimean", "brandies", "aneurism", "pins", "gel",
				"slather", "recast", "pokes", "looping", "sara", "wrested",
				"rusted", "pear", "mush", "smokier", "best", "tutors", "eels",
				"altitude", "unnoticed", "iterates", "cants", "shea",
				"fingers", "petal", "relations", "slaver", "hairs", "outtake",
				"tosca", "deltas", "ginsu", "mobbing", "destine", "roomer",
				"grouper", "padre", "arts", "luaus", "tubers", "avails", "rat",
				"heads", "lurch", "tin", "idlest", "shrive", "bared", "regor",
				"sweden", "importunes", "rapiers", "hales", "ar", "shout",
				"locust", "spread", "moister", "potters", "bantams",
				"palestine", "stew", "edna", "greta", "ronda", "khan", "bast",
				"treats", "outtakes", "senders", "wield", "sachet", "ericson",
				"annmarie", "protein", "pipes", "sleuth", "omar", "tone",
				"bosser", "sate", "hurdle", "escher", "filets", "refocusing",
				"rankle", "hardy", "vainest", "mood" };
		// String[]
		// input={"lactated","bust","ardent","repackage","stiflings","overjoying","tramps","lactated","abuts","ranted","repackage","stiflings","overjoying","tramps"};
		System.out.println(ag.anagrams(input));
	}
}