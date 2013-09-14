//给定一个数组和一个target， 找出所有的 三个数之和小于target的 情况的数量
//////////////////////////////////////////////////////////////////////////////////////
public int threeSumSmallerThanTarget(int[]nums, int target){
	if(nums==null||nums.length<3)
		return  0;
	Arrays.sort(nums);
	int count=0;
	for(int i=0;i<nums.length-2;i++){
		int value = nums[i];
		if(value>=target) continue;
		int left=i+1;
		int right=nums.length-1;
		while(left<right){
			int curSum=value+nums[left]+nums[right];
			if(curSum<=target){
				count++;
				left++;
			}else{
				left=i+1;
				right--;
			}
		}
	}
	return count;
}
//////////////////////////////////////////////////////////////////////////////////////
public int threeSumSmallerThanTarget(int[]nums, int target){
	if(nums==null||nums.length<3)
		return  0;
	Arrays.sort(nums);
	int count=0;
	for(int i=0;i<nums.length-2;i++){
		for(int j=i+1;j<nums.length-1;j++){
			int curSum = nums[i]+nums[j];
			if(curSum>=target)
				break;
			int k = binarySearch(nums, j+1, nums.length-1,target-curSum);
			count+=k-j;
			}
	}
	return count;
}
private int binarySearch(int[]nums, int left, int right, int value){
	if(left>right) return;
	while(left<right){
		int mid = left+(right-left)/2;
		if(nums[mid]<=value)
			left=mid;
		else
			right=mid-1;	
	}
	return left;
}
////////////////////////////////////////////////////////////////////////////////
