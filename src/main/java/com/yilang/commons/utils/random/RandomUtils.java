/**
* @author : huijun.zheng<br/>
* @Date: 2014-12-24<br/>
* @Time: 下午10:11:24<br/>
* To change this template use File | Settings | File Templates.<br/>
*/
package com.yilang.commons.utils.random;

import java.util.Random;

/**
 *
 * @author : huijun.zheng<br/>
 * @Date: 2014-12-24<br/>
 * @Time: 下午10:11:24<br/><br/>
 */
public class RandomUtils
{
	private static final Random random = new Random();
	
	private static final String[] characterSmail = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	
	public static String getRandomSmailCharacter(int num)
	{
		StringBuilder sb = new StringBuilder(num);
		
		for(int i=0;i<num;++i)
		{
			int index = random.nextInt(26);
			sb.append(characterSmail[index]);
		}
		return sb.toString();
	}
}
