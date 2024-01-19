class Solution {
    // The main search function that calls the binary search method
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length-1);
    }

    // Binary search algorithm
    public int binary(int a[], int target, int low, int high){
        while(low <= high){   
            // Calculate the middle index correctly
            int mid = low + (high - low) / 2;

            // If the target is found at the middle index, return the index
            if(a[mid] == target){
                return mid;
            }

            // If the target is less than the element at the middle index,
            // update the high index to search in the left half
            if(target < a[mid]){
                high = mid - 1;
            } 
            // If the target is greater than the element at the middle index,
            // update the low index to search in the right half
            else {
                low = mid + 1;
            }
        }

        // If the target is not found, return -1
        return -1;
    }
}
