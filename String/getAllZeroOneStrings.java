// .给个01?..串,?可以是0或1.求所有原串
	public ArrayList<String> get_all_zero_one_Strings(String str) {
		ArrayList<String> ans = new ArrayList<String>();
		if (str == null || str.length() == 0)
			return ans;
		dfs(str, 0, "", ans);
		return ans;
	}
	public void dfs(String str, int pos, String cur, ArrayList<String> ans) {
		if (pos == str.length()) {
			if (!ans.contains(cur))
				ans.add(cur);
			return;
		}
		if (str.charAt(pos) != '?') {
			cur += str.charAt(pos);
			dfs(str, pos + 1, cur, ans);
			return;
		}
		String changeStr = cur + "0";
		dfs(str, pos + 1, changeStr, ans);
		changeStr = cur + "1";
		dfs(str, pos + 1, changeStr, ans);
	}
