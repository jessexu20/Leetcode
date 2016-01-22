import java.util.ArrayList;
public class HappyNumber {
    public boolean isHappy(int n) {
        int j=0;
		int num=n;
		while(j<100){
			num=getSum(num);
			if(num!=1){
				num=getSum(num);
			}
			else break;
			j++;
		}
		if(j<100)
			return true;
		else return false;
    }
	public int getSum(int n){
		ArrayList<Integer> list=new ArrayList();
		while(n >=10){
			list.add(n%10);
			n=n/10;
		}
		list.add(n);
		if(list.size()==0)
			return 0;
		int sum=0;
		for(int i:list){
			sum+=i*i;
		}
		return sum;
	}
	public static void main(String args[]){
		HappyNumber hn=new HappyNumber();
		System.out.println(hn.isHappy(19));
	}
}
// public class Solution {
//     public boolean isHappy(int n) {
//         int x = n;
//         int y = n;
//         while(x>1){
//             x = cal(x) ;
//             if(x==1) return true ;
//             y = cal(cal(y));
//             if(y==1) return true ;
//
//             if(x==y) return false;
//         }
//         return true ;
//     }
//     public int cal(int n){
//         int x = n;
//         int s = 0;
//         while(x>0){
//             s = s+(x%10)*(x%10);
//             x = x/10;
//         }
//         return s ;
//     }
// }