//给n个数,两人轮流取,只能取两端的,目标是自己的和最大.求最优取法下两人之差
//我先手
public int getGap(int[]nums){
	int n = nums.length;
	int[][] dp = new int[n][n]
	for(int i=0;i<n;i++){
		for(int j=n-1;j>=0;j--){
			if((i+n-1-j)%2==1){
				dp[i][j]=Math.max(dp[i+1][j]+nums[i],dp[i][j-1]+nums[j])
			}else{
				dp[i][j]=Math.min(dp[i+1][j]-nums[i],dp[i][j-1]-nums[j])
			}
		}
	}
	return dp[0][n-1];
}
