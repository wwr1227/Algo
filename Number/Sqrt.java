public int sqrt(int num) {
	if (num <= 0)
		return 0;
	int lower = 0;
	int upper = num;
	while (lower < upper) {
		int mid = (lower + upper) / 2;
		if (mid == num / mid)
			return mid;
		else if (mid < (num / mid)) {
			lower = mid + 1;
		} else {
			upper = mid - 1;
		}
	}
	if (lower > num / lower)
		return lower - 1;
	return lower;
}

	double exp = 1.5F;
//牛顿开方法 x = (x + a / x) / 2;
public	float newtonSqrt(float a) {
	float x = a;
	for (int i = 1; i <= 10; i++)
		x = (x + a / x) / 2;
	return x;
}
