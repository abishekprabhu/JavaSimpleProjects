package Longest_Increasing_Subsequence;

import java.util.Arrays;

public class LIS {
	public static int[] longestIncreasingSubsequence(int[] nums) {
		
		 // Check if input array is empty or null
		if(nums == null || nums.length == 0 ) {
			return null;
		}
		
		 /* Initialize an array dp to store the length of the LIS ending at each index */
		int[] dp = new int[nums.length];
		Arrays.fill(dp,1);// Every element is a LIS of length 1
		
		/* Loop through all the elements of nums, starting from the second element */
		for(int i=1;i<nums.length;i++) {
			 // Loop through all the previous elements of nums
			for(int j=0;j<i;j++) {
        /*If nums[j] < nums[i] extend the LIS ending at index j by appending nums[i]*/
			if(nums[j]<nums[i]) {
				dp[i] = Math.max(dp[i], dp[j] + 1);
				
		     	}			
			}
		}
		 // Find the maximum value in dp
		int maxLength =0;
		for(int i=0;i<dp.length;i++) {
			if(dp[i]>maxLength) {
				maxLength = dp[i];
			}
		}
		
		 // Create an array lis to store the LIS
		int lis[] = new int[maxLength];
		int lisIndex = maxLength - 1;
		
		/* Loop through dp backwards, starting from the last element of nums */
		for(int i=nums.length-1; i>=0;i--) {
			/* If dp[i] is equal to maxLength, nums[i] is part of the LIS */
			if (dp[i] == maxLength) {
				lis[lisIndex] = nums[i];
				lisIndex--;
				maxLength--;
			}
		}
		return lis;
	}

	
	public static void main(String[] args) {
		//initialize random array of list
		int nums[] = {10, 9, 2, 5, 3, 7, 10, 18};
		int lis[] = longestIncreasingSubsequence(nums); //call method
		System.out.print("LongestIncreasingSubsequences =\t");
		System.out.println(Arrays.toString(lis)); //display LIS

	}

}
