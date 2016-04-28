/**
* Created with Elipse.<br/>
* User: huijun.zheng<br/>
* Date: 2014-9-25<br/>
* Time: 上午10:34:28<br/>
* To change this template use File | Settings | File Templates.<br/>
*/
package com.yilang.commons.utils.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with Elipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2014-9-25<br/>
 * Time: 上午10:34:28<br/><br/>
 */
public class RegexUtil
{
	/**
	 * 
	 * 用指定的字符串，替换特殊的字符串，比方说在文件命名的时候.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2014-9-25<br/>
	 * Time: 上午10:38:09<br/>
	 * @param replace
	 * @param replaceChar
	 * @return<br/>
	 */
	public static String replaceWithSpecifiedChar(String replace,String replaceChar)
	{
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？\"]"; 
	    Pattern   p   =   Pattern.compile(regEx);     
        Matcher   m   =   p.matcher(replace);     
        return   m.replaceAll(replaceChar).trim();  
	}
	
	/**
	 * 
	 * 用指定的字符串，替换原来的字符串，.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2014-9-25<br/>
	 * Time: 下午1:32:43<br/>
	 * @param regex 
	 * 				Regex expression
	 * @param replace 
	 * 				Source string
	 * @param replaceChar
	 * 				The string was replaced after
	 * @return<br/>
	 */
	public static String replaceWithSpecifiedChar(String regEx,String replace,String replaceChar)
	{
	    Pattern p = Pattern.compile(regEx);     
        Matcher m = p.matcher(replace);     
        return m.replaceAll(replaceChar).trim();  
	}
}
