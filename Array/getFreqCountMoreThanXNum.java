// 给定一个数组，数组中有1个数出现次数大于数组长度的1/4，找出这个数
// 给定一个数组，数组中有三个数出现次数大于数组长度的1/4，找出这三个数
public int[] getFreqMoreThanNum(int[] nums) {
	if (nums == null)
		return null;
	if (nums.length < 4)
		return nums;
	Map<Integer, Integer> list = new HashMap<Integer, Integer>();
	for (int i = 0; i < nums.length; i++) {
		int cur = nums[i];
		if (list.containsKey(cur)) {
			list.put(cur, list.get(cur) + 1);
		} else {
			if (list.size() < 4) {
				list.put(cur, 1);
				continue;
			}
			Set<Entry<Integer, Integer>> entrys = list.entrySet();
			Iterator<Entry<Integer, Integer>> iter = entrys.iterator();
			while (iter.hasNext()) {
				Entry<Integer, Integer> entry = iter.next();
				if (entry.getValue() == 1) {
					iter.remove();
					list.remove(entry.getKey());
					continue; 
				}
				list.put(entry.getKey(), entry.getValue() - 1);
			}
		}
	}
	int[] ans = new int[list.size()];
	int i = 0;
	for (Entry<Integer, Integer> entry : list.entrySet()) {
		ans[i++] = entry.getKey();
	}
	return ans;
}
