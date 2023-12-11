class Solution {
    public int findSpecialInteger(int[] arr) {
        int count=1;
        int n=arr.length;
        int qtr =n/4;
        int p=arr[0];

        for(int i=1;i<n;i++){
            if(p==arr[i]){
                count++;
            }else{
                count=1;
            }
            if(count > qtr){
                return arr[i];
            }
            p=arr[i];
        }
        return p;
    }
}