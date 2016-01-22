public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int [] pos = new int [primes.length];
        int [] result = new int [n];
        result[0] = 1;
        for(int i = 1; i<n;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < primes.length;j++){
                list.add(result[pos[j]]*primes[j]);
            }
            int index = findMin(list);
            if(result[i-1]==list.get(index)) i--;
            else result[i] = list.get(index);
            pos[index]++;
        }
        return result[n-1];
    }
    private int findMin(List<Integer> list){
        int min = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i) < list.get(min)){
                min = i;
            }
        }
        return min;
    }
}