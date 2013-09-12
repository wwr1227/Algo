public boolean validIPAddress(String ip) {
	if (ip == null || ip.length() <= 7)
		return false;
	if (!ip.contains("."))
		return false;
	String[] ipSplit = ip.split("[.]");
	if (ipSplit.length != 4) {
		return false;
	}
	for (int i = 0; i < ipSplit.length; i++) {
		String curIp = ipSplit[i];
		int ipInt = 0;
		for (int j = 0; j < curIp.length(); j++) {
			ipInt *= 10;
			ipInt += Integer.parseInt(String.valueOf(curIp.charAt(j)));
		}
		if (ipInt < 0 || ipInt >= 256)
			return false;
	}
	return true;
}
///////////////////////////////////////////////////////////////////////

/**
 * @param args
 */
public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution su = new Solution();
	String s = "010010";
	System.out.println(su.restoreIpAddresses(s));
}
public ArrayList<String> restoreIpAddresses(String s) {
	// Start typing your Java solution below
	// DO NOT write main() function
	ArrayList<String> ipAdd = new ArrayList<String>();
	String IPstring = "";
	if (s == null || s.length() == 0)
		return ipAdd;
	getIpAddresses(s, ipAdd, IPstring, 0, 0);
	return ipAdd;
}
public void getIpAddresses(String s, ArrayList<String> ipAdd,
		String IPstring, int start, int pos) {
	if (start + 3 * (4 - pos) < s.length())
		return;
	if (start + 1 * (4 - pos) > s.length())
		return;
	if (start > s.length())
		return;
	if (pos > 4)
		return;
	if (start == s.length() && pos == 4) {
		IPstring = IPstring.substring(0, IPstring.length() - 1);
		if (!ipAdd.contains(IPstring))
			ipAdd.add(IPstring);
		return;
	} else {
		for (int i = start; i < s.length(); i++) {
			if (start + 1 <= s.length()
					&& check(s.substring(start, start + 1))) {
				String curIPString = IPstring
						+ s.substring(start, start + 1) + ".";
				getIpAddresses(s, ipAdd, curIPString, start + 1, pos + 1);
			}
			if (start + 2 <= s.length()
					&& check(s.substring(start, start + 2))) {
				String curIPString = IPstring
						+ s.substring(start, start + 2) + ".";
				getIpAddresses(s, ipAdd, curIPString, start + 2, pos + 1);
			}
			if (start + 3 <= s.length()
					&& check(s.substring(start, start + 3))) {
				String curIPString = IPstring
						+ s.substring(start, start + 3) + ".";
				getIpAddresses(s, ipAdd, curIPString, start + 3, pos + 1);
			}
		}
	}

}

private boolean check(String ip) {
	// TODO Auto-generated method stub
	if (ip.length() == 1)
		return 0 <= Integer.parseInt(ip) && Integer.parseInt(ip) <= 9;
	else if (ip.length() == 2)
		return 10 <= Integer.parseInt(ip) && Integer.parseInt(ip) <= 99;
	else if (ip.length() == 3)
		return 100 <= Integer.parseInt(ip) && Integer.parseInt(ip) <= 255;
	else
		return false;
}
