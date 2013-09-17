public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution su = new Solution();
		System.out.println(su.findPrimeNumber(100).size() + ":"
				+ su.findPrimeNumber(100));
	}

	public LinkedList<Integer> findPrimeNumberInN(int n) {
		LinkedList<Integer> nums = new LinkedList<Integer>();
		for (int i = 2; i <= n; i++) {
			nums.add(i);
		}
		int i = 2;
		while (i <= n / 2) {
			for (int index = 0; index < nums.size(); index++) {
				if (nums.get(index) != i && nums.get(index) % i == 0)
					nums.remove(index);
			}
			i++;
		}
		return nums;

	}
