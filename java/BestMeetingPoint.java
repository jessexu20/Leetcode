/* Best Meeting Point
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and (2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

Hint:

Try to solve it in one dimension first. How can this solution apply to the two dimension case?
*/
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