class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;

        int n=nums.length;

        for(int i=0;i<n;i++){
            high=Math.max(high,nums[i]);
        }

        while(low<=high){
            int mid=(low+high)/2;

            if(divPossible(nums,threshold,mid)){
                high=mid-1;
                
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

     public static boolean divPossible(int nums[], int threshold,int mid){

        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)mid);

        }

        return sum<=threshold;
    }
}