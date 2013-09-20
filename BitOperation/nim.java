/**
 * 下面是一个二人小游戏：桌子上有M堆扑克牌；每堆牌的数量分别为Ni(i=1…M)；两人轮流进行；每走一步可以任意选择一堆并取走其中的任意张牌；
 * 桌子上的扑克全部取光，则游戏结束；最后一次取牌的人为胜者。 “先手的人如果想赢，第一步有几种选择呢？”
 */
public int nim(int[] nums) {
	int ans = 0;
	if (nums == null || nums.length == 0)
		return ans;
	int exor = 0;
	for (int i = 0; i < nums.length; i++)
		exor ^= nums[i];
	for (int i = 0; i < nums.length; i++)
		if ((exor ^ nums[i]) < nums[i])
			ans++;
	return ans;
}
