public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> row= new ArrayList<Integer>();
        List<Integer> col= new ArrayList<Integer>();
        for(int i =0 ; i < grid.length;i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        int rowMid=getMedian(row);
        int colMid=getMedian(col);
        int sum = 0;
        for(int i = 0 ; i<row.size();i++){
            sum+=(Math.abs(row.get(i)-rowMid)+Math.abs(col.get(i)-colMid));
        }
        return sum;
    }
    public int getMedian(List<Integer>list){
        Collections.sort(list);
        int length = list.size();
        if(length==0) return 0;
        if(length%2==0)
            return (list.get(length/2-1)+list.get(length/2))/2;
        else return list.get(length/2);
    }
}