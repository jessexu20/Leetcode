public class SmallestRectangle {
    public int minArea(char[][] image, int x, int y) {
        if(image.length < 1) return 0;
        int top = search(image,0,x,false,true);
        int bottom = search(image,x+1,image.length-1,false,false);
        int left = search(image,0,y,true,true);
        int right = search(image,y+1,image[0].length-1,true,false);
        return (bottom-top+1)*(right-left+1);
    }
    public int search(char [][]image, int start, int end,boolean isCol,boolean tl){
        //isCol = true -> binary search on col, tl = top left -> return the larger value of binary search.
        while(start <= end){
            int mid = start + (end-start)/2;
            if(check(image,mid,isCol)){
                if(tl) end = mid - 1;
                else start = mid + 1;
            }
            else{
                if(tl) start = mid + 1;
                else end = mid - 1;
            }
        }
        if(tl) return start;
        else return end;
    }
    public boolean check(char [][] image, int index, boolean isCol){
        //isCol = true -> index is a col value;
        //check if it's all zeros...if there is one 1, return true, else false O(n) or O(m)
        if(isCol){
            for(int i = 0;i<image.length;i++){
                if(image[i][index]=='1') return true;
            }
            return false;
        }
        else{
            for(int i = 0;i<image[0].length;i++){
                if(image[index][i]=='1') return true;
            }
            return false;
        }
    }
}