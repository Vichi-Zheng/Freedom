/**
* Created with MyElipse.<br/>
* User: huijun.zheng<br/>
* Date: 2014-2-24<br/>
* Time: 下午7:22:38<br/>
*
* To change this template use File | Settings | File Templates.<br/>
*/
package com.yilang.commons.utils.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 *  java日期对象经过Jackson库转换成JSON日期格式化自定义类
 * Created with MyElipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2014-2-24<br/>
 * Time: 下午7:17:16<br/>
 *<br/>
 */
public class JacksonCustomDateSerializer extends JsonSerializer<Date>
{
	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
			JsonProcessingException
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
		String formattedDate = formatter.format(value);
		jgen.writeString(formattedDate);
	}
} 
