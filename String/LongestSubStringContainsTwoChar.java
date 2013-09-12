//给一个字符串，找出只包含两种字符的最长子串
	public String getLongestSubStringContainsTwoChar(String src) {
		int subStrStart = 0;
		int subStrLen = 0;
		if (src.length() <= 2)
			return src;
		int firstCharPos = -1;
		char firstChar = ' ';
		int secondCharPos = -1;
		char secondChar = ' ';
		for (int i = 0; i < src.length(); i++) {
			if (firstCharPos == -1) {
				firstChar = src.charAt(i);
				firstCharPos = i;
			} else if (src.charAt(i) != firstChar&&secondCharPos == -1) {
				secondChar = src.charAt(i);
				secondCharPos = i;
			}
			if (secondCharPos != -1 && firstCharPos != -1
					&& src.charAt(i) != firstChar
					&& src.charAt(i) != secondChar) {
				firstChar = src.charAt(secondCharPos);
				firstCharPos = secondCharPos;
				secondChar = src.charAt(i);
				secondCharPos = i;
			}
			int len = i - firstCharPos + 1;
			if (len > subStrLen) {
				subStrStart = firstCharPos;
				subStrLen = len;
			}
		}
		return src.substring(subStrStart, subStrStart + subStrLen);
	}
