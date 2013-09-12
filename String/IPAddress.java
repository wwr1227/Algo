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
