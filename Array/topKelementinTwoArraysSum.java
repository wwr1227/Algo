//1.两个长度为n的有序数组,每个数组中各取一个相加,求和的前n大

public int topKelementinTwoArraysSum(int[] nums1, int[] nums, int k){
	if(nums1.length==0||nums2.lengt=0||k<=0)
		return -1;
	int len1=nums1.length;
	int len2=nums2.length;
	Arrays.sort(nums1);
	Arrays.sort(nums2);
	int min=nums1[0]+nums2[0];
	int max=nums[len1-1]+nums[len2-1];
	int ans = min;
	while(min<=max){
		int mid = min+(max-min)/2;
		int pos = findMidInTwoArraySum(nums1,nums2,mid);
		if(pos>=k){
			ans=mid;
			max=mid-1;
		}else
			min=mid+1;
	}
	return ans;
}
public int findMidInTwoArraySum(int[] nums1,int[]nums2, int value){
	int len1=nums1.length;
	int len2=nums2.length;
	int count = 0;
	for(int i=0;i<len1;i++){
		int j=0;
		while(j<len2&&nums[i]+nums[j]<=value)
			j++;
		count+=j;
	}
	return count;
}
