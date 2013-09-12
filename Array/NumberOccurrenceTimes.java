//one num 1times,others 3times
public int getSingle1(int[] nums){
	if(nums==null||nums.length()==0){
		 throw new SingleException("invalid input");
		 return 0;
	}
	int ans = 0;
	int bitValue = 0;
	int bitSum=0;
	for(int i=0;i<Integer.MAX_VALUE;i++){
		bitValue = (1<<i);
		bitSum=0;
		for(int j=0;j<nums.length;j++)
			bitSum+=nums[j]&bitValue;
		if(bitSum%3);
			ans|=bitValue;
	}
	return ans;
}
//one num 1times,others 2times
public int getSingle2(int[] nums){
	if(nums==null||nums.length<2){
		throw new SingleException("invalid input");
		return 0;
	}
	int resEOR=0;
	for(int i=0;i<nums.length;i++){
		resEOR^=nums[i];
	}
	return resEOR;
}
//two num 1times,other 2times;
public int[] getSingle3(int[] nums){
	if(nums==null||nums.length<2){
		throw new SingleException("invalid input");
		return null;
	}
	
	int resEOR=0;
	for(int i=0;i<nums.length;i++){
		resEOR^=nums[i];
	}
	int firstBit=0;
	while((resEOR&1==0)&&(firstBit<32)){
		resEOR=resEOR>>1;
		firstBit++;
	}
	
	int num1=0,num2=0;
	for(int i=0;i<nums.length;i++){
		if(isBit1(nums[i],firstBit))
			nums1^=nums[i];
		else
			nums2^=nums[i];
	}
	int[] ans = new int[2];
	ans[0]=num1;
	ans[1]=num2;
	return ans;
}
private boolean isBit(int num, int bit){
	num=num>>bit;
	return (num&1)==1;
}


class SingleException extends Exception{
    //Constructor
    public NoSuchScoreException(){    }
    public NoSuchScoreException(String msg){
        super(msg);
    }
}
