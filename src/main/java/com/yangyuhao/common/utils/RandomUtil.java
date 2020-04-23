package com.yangyuhao.common.utils;

import java.util.HashSet;
import java.util.Random;

/**
 * 随机数工具类
 * @ClassName: RandomUtil 
 * @Description: TODO
 * @author: dell
 * @date: 2020年4月23日 下午2:56:43
 */
public class RandomUtil {
	// 方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
	public static int random(int min,int max){
		if(min>=max){
			throw new RuntimeException("请输入正确的数值");
		}
		Random r = new Random();
		
		//大于等于min nextInt()方法可以返回0 所以在nextInt()后加min
		//小于等于max 所以nextInt()方法返回必须是0-max和min的差值
		//因为nextInt()不包含参数本身，所以+1
		return r.nextInt(max-min+1)+min;
	}	
	
	// 方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。
		// (8分)
		
	public static int[] subRandom(int min,int max,int subs){
		int[] result = new int[subs];
		if(max-min+1<subs){
			throw new RuntimeException("范围不符");
		}
		//hash存放的数据都是非重复的,会过滤重复的数值
		HashSet<Integer> set = new HashSet<Integer>();
		
		while (set.size()!=subs) {
			set.add(RandomUtil.random(min, max));			
		}
		int i = 0;
		for (Integer integer : set) {
			result[i] = integer;
			i++;
		}
		return result;
	}
	
	// 方法3：返回1个  1-9,a-Z之间的随机字符。 (8分)
	public static char randomCharacter(){
		String str = "123456789abcdefghijklmnopqrstuvwxyzQAZWSXEDCRFVTGBYHNUJMIKOLP";
		
		/*Random random = new Random();
		return str.charAt(random.nextInt(str.length()));*/
		return str.charAt(random(0, str.length()-1));
	}
	
	// 方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)

	public static String randomString(int length){
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			sb.append(randomCharacter());
		}
		
		return sb.toString();
	}






}
