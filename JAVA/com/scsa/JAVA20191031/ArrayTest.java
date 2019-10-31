package com.scsa.JAVA20191031;

public class ArrayTest {
	public static void main(String[] args) {
		int []nums = {1,2,3,4,5};
		
//		System.out.println(nums[5]);	// ArrayIndexOutOfBoundsException	
		System.out.println("nums.length : " + nums.length);
		for (int i = 0; i < nums.length; i++) {
			System.out.println("nums["+i+"] = "+nums[i]);
		}
		System.out.println("===============");
		
		
		int [][]nums2 = {{11,22}, {33, 44, 55}};
		
		System.out.println("nums2.length = "+ nums2.length);
		System.out.println("nums2[0].length = "+ nums2[0].length);
		System.out.println("nums2[1].length = "+ nums2[1].length);
		
		for (int i = 0;  i < nums2.length; i++) {
			for(int j=0; j < nums2[i].length; j++) {
				System.out.println("nums2["+i+"]["+j+"] = "+nums2[i][j]);
			}
		}
		System.out.println("===============");

	}
}