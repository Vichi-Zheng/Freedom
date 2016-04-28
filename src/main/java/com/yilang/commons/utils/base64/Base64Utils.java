/**
* @author : huijun.zheng<br/>
* @Date: 2014-12-24<br/>
* @Time: 上午1:01:13<br/>
* To change this template use File | Settings | File Templates.<br/>
*/
package com.yilang.commons.utils.base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.BASE64Decoder;

/**
 *
 * @author : huijun.zheng<br/>
 * @Date: 2014-12-24<br/>
 * @Time: 上午1:01:13<br/><br/>
 */
public class Base64Utils
{
	/**
	 * 
	 * 将base64的字符串，以文件的形式保存到硬盘.<br/>
	 * @author : huijun.zheng<br/>
	 * @Date: 2014-12-24<br/>
	 * @Time: 上午1:04:10<br/>
	 * @param base64Str base64 string
	 * @param file File file
	 * @throws IOException 
	 * @throws Exception<br/>
	 */
	public static void saveBase64Str2Disk(String base64Str,File file) throws IOException
	{
		BASE64Decoder decoder = new BASE64Decoder();
   	 
        FileOutputStream write = new FileOutputStream(file);
        byte[] decoderBytes = decoder.decodeBuffer(base64Str);
        write.write(decoderBytes);
        write.close();
	}
}
