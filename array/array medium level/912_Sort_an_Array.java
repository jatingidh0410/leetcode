class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int[] aux = new int[nums.length];
        mergeSort(nums, aux, 0, nums.length - 1);
        return nums;
    }
    
    private void mergeSort(int[] nums, int[] aux, int left, int right) {
        if (left >= right) {
            return;
        }
        
        int mid = left + (right - left) / 2;
        mergeSort(nums, aux, left, mid);
        mergeSort(nums, aux, mid + 1, right);
        merge(nums, aux, left, mid, right);
    }
    
    private void merge(int[] nums, int[] aux, int left, int mid, int right) {
        System.arraycopy(nums, left, aux, left, right - left + 1);
        
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = aux[j++];
            } else if (j > right) {
                nums[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                nums[k] = aux[i++];
            } else {
                nums[k] = aux[j++];
            }
        }
    }
}
