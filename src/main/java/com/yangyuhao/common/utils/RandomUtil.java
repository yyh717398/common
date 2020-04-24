package com.yangyuhao.common.utils;

import java.math.BigDecimal;
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
	
	/**
	 * 功能：提供精确的加法运算。<br>
	 * double d1 = 0.1;  <br>
	 * double d2 = 0.2;   <br>
	 * double d3 = d1 + d2; ==> 0.30000000000000004 导致不精确。<br>
	 * 该工具方法可以纠正上面的问题。<br>
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 两个参数的和
	 */
	public static double add(double d1, double d2){
		BigDecimal bigDecimal1 = new BigDecimal(Double.toString(d1));
		BigDecimal bigDecimal2 = new BigDecimal(Double.toString(d2));
		BigDecimal result = bigDecimal1.add(bigDecimal2);
		return result.doubleValue();
	}
	
	

	/**
	 * 提供精确的减法运算。
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 两个参数的差
	 */
	public static double sub(double v1,double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2).doubleValue();
	}

	
	/**
	 * 提供精确的乘法运算。
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 两个参数的积
	 */
	public static double mul(double v1,double v2){
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2).doubleValue();
	}




	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
	 * 定精度，以后的数字四舍五入。
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1,double v2,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}



	/**
	 * 提供精确的小数位四舍五入处理。
	 * @param v 需要四舍五入的数字
	 * @param scale 小数点后保留几位
	 * @return 四舍五入后的结果
	 */
	public static double round(double v,int scale){
		if(scale<0){
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));
		BigDecimal one = new BigDecimal("1");
		return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}






}
