public class Solution {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSum = new int[nums.length];
      int[] rightSum = new int[nums.length];
      int[] answer = new int[nums.length];
      if(nums.length == 1){
          answer[0] = 0;
      } else {
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;

        for(int i = 1 ; i < nums.length ; i++){
          leftSum[i] = nums[i-1] + leftSum[i-1]; 
        }

        for(int i = nums.length - 2; i >= 0 ; i--){
          rightSum[i] = rightSum[i+1] + nums[i+1];
        }

        for(int i = 0 ; i < nums.length ; i++){
          if(leftSum[i] > rightSum[i]){
            answer[i] = leftSum[i] - rightSum[i];
          }else {
            answer[i] = rightSum[i] - leftSum[i];
          }
        }
      }

      return answer;
    }
} {
    
}
