// created a array or size nums to store values.
// first for to iterate through i
// second for to compare with i with j
// check condition
// if yes increment the counter
// after the comparison is done with i
// we iniatialize counter zero.
// at the end we return the array
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count=0;
        int[] arr = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    count++;
                }
            }
            arr[i]=count;
            count=0;
        }
        return arr;
    }
}