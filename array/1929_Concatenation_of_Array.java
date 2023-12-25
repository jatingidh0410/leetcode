/*
 * used a simple for loop to concatenate the array.
 * the task was to copy the original array and print it ahead of original array
 * used ans[] array and used len function to define ts size
 * used a for
 * ans used if else stating the condition that if the size is
 * greater that original array use i-lenght of the original array. 
 */
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] ans = new int[nums.length*2];
        
        for(int i=0;i<ans.length;i++){
            if(i < n){
                ans[i]=nums[i];
            }else{
                ans[i]=nums[i-n];
            }
        }
        return ans;
    }
}