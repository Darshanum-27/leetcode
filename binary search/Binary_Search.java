import java.util.*;

class Binary_Search {
    public static void findNumber(ArrayList<Integer> data, int target){
        int low = 0;
        int high = data.size();
        while(low<=high){
            int mid = (low+high)/2;
            if(data.get(mid)==target){
                System.out.println(mid);
                break;
            }
            if(data.get(mid)<target){
                low = mid+1;
            }
            if(data.get(mid)>target){
                high = mid-1;
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        System.out.println(a);
        Binary_Search.findNumber(a,1);
    }
}