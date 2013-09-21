//There are a row of 2n seats in the cinema. The cinema hand out tickets with assigned seats.
//n couples comes to the cinema, and seat on their assigned seats.
//Some of the couples are not sitting next to each other, 
//so they let two people swap seats until every couple are sitting together.
public int coupleSeats(int[] nums) {
	if (nums == null || nums.length == 0 || nums.length % 2 != 0)
		return 0;
	int[][] couple = new int[nums.length / 2][2];
	for (int i = 0; i < nums.length; i += 2) {
		couple[i / 2][0] = nums[i];
		couple[i / 2][1] = nums[i + 1];
	}
	Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	for (int i = 0; i < nums.length / 2; i++) {
		buildAdjacencyList(map, couple[i][0], couple[i][1]);
		buildAdjacencyList(map, couple[i][1], couple[i][0]);
	}
	boolean[] visited = new boolean[nums.length / 2];
	Arrays.fill(visited, false);
	int count = 0;
	for (int i = 1; i <= nums.length / 2; i++) {
		if (visited[i - 1])
			continue;
		count++;
		dfs(map, i, visited);
	}
	return nums.length / 2 - count;
}

public void dfs(Map<Integer, ArrayList<Integer>> map, int cur,
		boolean[] visited) {
	visited[cur - 1] = true;
	ArrayList<Integer> list = map.get(cur);
	for (int i : list) {
		if (!visited[i - 1])
			dfs(map, i, visited);
	}
}

public void buildAdjacencyList(Map<Integer, ArrayList<Integer>> map,
		int head, int add) {
	if (map.containsKey(head)) {
		ArrayList<Integer> list = map.get(head);
		if (!list.contains(add))
			list.add(add);
		map.put(head, list);
	} else {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(add);
		map.put(head, list);
	}
}
