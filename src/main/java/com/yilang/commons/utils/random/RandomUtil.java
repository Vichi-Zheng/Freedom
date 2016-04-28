/**
 * Created with Elipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2014-9-25<br/>
 * Time: 下午8:44:01<br/>
 * To change this template use File | Settings | File Templates.<br/>
 */
package com.yilang.commons.utils.random;

import java.util.Random;

/**
 * Created with Elipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2014-9-25<br/>
 * Time: 下午8:44:01<br/>
 * <br/>
 */
public class RandomUtil
{
	/**
	 * 
	 * 生成随机的字符串(只包含小写字母).<br/>
	 * 
	 * User: huijun.zheng<br/>
	 * Date: 2014-9-25<br/>
	 * Time: 下午8:44:31<br/>
	 * 
	 * @param num
	 *            生成字符串的长度
	 * @return<br/>
	 */
	public static String getRandomCharacter(int num)
	{
		StringBuilder sb = new StringBuilder(num);

		for (int i = 0; i < num; ++i)
		{
			int index = random.nextInt(26);
			sb.append(character[index]);
		}
		return sb.toString();
	}

	private static final String[] character =
	{ "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
			"E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9" };

	private static Random random = new Random();
}
