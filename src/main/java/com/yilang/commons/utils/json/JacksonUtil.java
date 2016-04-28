/**
* Created with MyElipse.<br/>
* User: huijun.zheng<br/>
* Date: 2014-2-24<br/>
* Time: 下午5:18:06<br/>
*
* To change this template use File | Settings | File Templates.<br/>
*/
package com.yilang.commons.utils.json;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;


/**
 * 性能方面jackson >  gson  >  json-lib。
 * 其中gson比json-lib性能略高一点，jacks性能高出json-lib有10倍。
 * Created with MyElipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2013-8-5<br/>
 * Time: 下午4:18:41<br/>
 * <br/>
 */
public class JacksonUtil
{
	private static final String DATA_FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
	/**
	 * java对象的序列化成json对象<br/>
	 * To change this template use File | Settings | File Templates.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2013-8-5<br/>
	 * Time: 下午4:32:31<br/>
	 * @param obj
	 * @return<br/>
	 */
	public  static <T> String bean2Json(T obj)  throws Exception
	{
		ObjectMapper mapper = JacksonFactory.getInstance();  
		StringWriter sw = new StringWriter();  
		JsonGenerator gen = null;
		try
		{
			gen = new JsonFactory().createGenerator(sw);
			mapper.writeValue(gen, obj);  
		}  
		finally
		{
			if(null != gen) gen.close();
		}
		
		return sw.toString();
	}
	
	/**
	 * json对象反序列化成java对象.<br/>
	 * 
	 * User: huijun.zheng<br/>
	 * Date: 2013-8-5<br/>
	 * Time: 下午4:38:30<br/>
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @throws Exception<br/>
	 */
	public static <T> T json2Bean(String jsonStr,Class<T> clazz) throws Exception
	{
		if (null == jsonStr || "".equals(jsonStr)) 
		{
            return null;
        } 
		ObjectMapper mapper = JacksonFactory.getInstance();  
		return mapper.readValue(jsonStr, clazz); 
	}
	
	/**
	 * 
	 * JSON串转换为Java泛型对象，可以是各种类型，此方法最为强大.<br/>
	 * 注意：
		该方法用在1.x版本也就是org.codehaus.jackson包，
		<dependency>
			<groupId>org.codehaus.jackson</groupId>
			<artifactId>jackson-all</artifactId>
			<version>1.8.5</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		而不是2.x版本，com.fasterxml.jackson包开头
		<!-- jackson的依赖 -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.2.3</version>
			<type>jar</type>
			<scope>compile</scope>
		</dependency>
		<!-- jackson的依赖 -->
			
	 * User: huijun.zheng<br/>
	 * Date: 2014-3-27<br/>
	 * Time: 下午2:22:14<br/>
	 * 
	 * @param jsonStr
	 *            JSON字符串
	 * @param typeReference
	 *            TypeReference,例如: 
	 *            	1、new TypeReference<List<对象>>(){}
	 *            	2、new TypeReference<Map<对象>>(){}
	 *            	3、 new TypeReference<自定义的对象<对象>>(){}
	 * @return List对象列表或者Map或者自定义对象 <br/>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Bean(String jsonStr, TypeReference<T> typeReference)
	{
		if (null == jsonStr || "".equals(jsonStr))
		{
			return null;
		}

		try
		{
			ObjectMapper mapper = JacksonFactory.getInstance();
			return (T) mapper.readValue(jsonStr, typeReference);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * JSON串转换为Java集合对象，可以是各种类型.<br/>
	 *注意：	
			该方法用在1.x版本也就是org.codehaus.jackson包，而不是2.x版本，com.fasterxml.jackson包开头
	 
	 * User: huijun.zheng<br/>
	 * Date: 2014-7-31<br/>
	 * Time: 上午11:11:14<br/>
	 * @param jsonStr
	 * @param collectionClass 泛型的Collection  
	 * @param elementClasses 元素类   
	 * @return 集合对象<br/>
	 * 
	 * 用法：
	 * 		JsonUtil.json2Bean(jsonStr,ArrayList.class,Feed.class);
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Bean(String jsonStr,Class<?> collectionClass, Class<?>... elementClasses)
	{
		if (null == jsonStr || "".equals(jsonStr))
		{
			return null;
		}

		try
		{
			ObjectMapper mapper = JacksonFactory.getInstance();
			JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
			return (T) mapper.readValue(jsonStr, javaType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * JSON串转换为Java泛型对象，可以是各种类型.<br/>
	 
	 * 注意：
		该方法用在1.x版本也就是org.codehaus.jackson包，而不是2.x版本，com.fasterxml.jackson包开头
		
	 * User: huijun.zheng<br/>
	 * Date: 2014-3-27<br/>
	 * Time: 下午2:56:02<br/>
	 *
	 * @param jsonStr JSON字符串
	 * @param javaType
	 * 		JavaType javaType = getCollectionType(ArrayList.class, YourBean.class); 
	 *      List<YourBean> lst =  (List<YourBean>)mapper.readValue(jsonString, javaType); 
	 * @return<br/>
	 */
	@SuppressWarnings("unchecked")
	public static <T> T json2Bean(String jsonStr, JavaType javaType)
	{
		if (null == jsonStr || "".equals(jsonStr))
		{
			return null;
		}

		try
		{
			ObjectMapper mapper = JacksonFactory.getInstance();
			return (T) mapper.readValue(jsonStr, javaType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 *java对象的序列化成json对象,并排除不需要序列的属性值.<br/>
	 *	注意：
	 * 		需要在java的类上加上注解 @JsonFilter("excludeFilter")
	 * 
	 * User: huijun.zheng<br/>
	 * Date: 2014-3-5<br/>
	 * Time: 下午2:02:07<br/>
	 *
	 * @param obj
	 * @param propertyArray
	 * @return
	 * @throws Exception<br/>
	 */
	public static String bean2JsonFilterExclude(Object obj,String... propertyArray) throws Exception
	{
		return bean2JsonFilter(obj,true,propertyArray);
	}
	
	/**
	 * 
	 *java对象的序列化成json对象,只序列化包含的属性值.<br/>
	 *	注意：
	 * 		需要在java的类上加上注解 @JsonFilter("includeFilter")
	 * 
	 * User: huijun.zheng<br/>
	 * Date: 2014-3-5<br/>
	 * Time: 下午2:02:07<br/>
	 *
	 * @param obj
	 * @param propertyArray
	 * @return
	 * @throws Exception<br/>
	 */
	public static String bean2JsonFilterInclude(Object obj,String... propertyArray) throws Exception
	{
		return bean2JsonFilter(obj,false,propertyArray);
	}
	
	/**
	 * 
	 *java对象的序列化成json对象<br/>
	 *		如果java的类上有@JsonFilter("excludeFilter")，或者@JsonFilter("includeFilter")的，
	 *		但是有没有想要排除或者只包含的属性时，用次方法.<br/>
	 * 
	 * User: huijun.zheng<br/>
	 * Date: 2014-2-24<br/>
	 * Time: 下午6:17:26<br/>
	 *
	 * @param obj
	 * @param excludePropertyArray
	 * @return
	 * @throws Exception<br/>
	 */
	public static String bean2JsonFilter(Object obj) throws Exception
	{
		
		//定义过滤器，排除字段
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		
		filterProvider.addFilter("excludeFilter", SimpleBeanPropertyFilter.serializeAllExcept(new String[]{}));
		filterProvider.addFilter("includeFilter", SimpleBeanPropertyFilter.serializeAllExcept(new String[]{}));
		
		//获得ObjectMapper的实例
		ObjectMapper mapper = JacksonFactory.getInstance();
		//设定属性是否可以序列化的过滤器
		mapper.setFilters(filterProvider);
		//设定日期的格式化--长格式
		mapper.setDateFormat(new SimpleDateFormat(DATA_FORMAT_LONG));
		
		StringWriter sw = new StringWriter();
		JsonGenerator jgen = null;
		try
		{
			jgen = new JsonFactory().createGenerator(sw);
			mapper.writeValue(jgen, obj);
		}
		finally
		{
			if(null != jgen) jgen.close();
		}
		return sw.toString();
	}
	
	/**
	 * 
	 *java对象的序列化成json对象,并排除不需要序列的属性值或者包含.<br/>
	 * 
	 * 注意：
	 * 		需要在java的类上加上@JsonFilter("executeFilter")，或者@JsonFilter("includeFilter")
	 * User: huijun.zheng<br/>
	 * Date: 2014-2-24<br/>
	 * Time: 下午6:17:26<br/>
	 *
	 * @param obj
	 * @param true 表示排除，false,表示包含
	 * @param excludePropertyArray
	 * @return
	 * @throws Exception<br/>
	 */
	public static String bean2JsonFilter(Object obj,Boolean exclude,String... propertyArray) throws Exception
	{
		if(null == propertyArray)
		{
			throw new IllegalArgumentException("property can not be null");
		}
		
		//定义过滤器，排除字段
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		
		if(true == exclude)
		{
			filterProvider.addFilter("excludeFilter", SimpleBeanPropertyFilter.serializeAllExcept(propertyArray));
		}
		else
		{
			filterProvider.addFilter("includeFilter", SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray));
		}
		//获得ObjectMapper的实例
		ObjectMapper mapper = JacksonFactory.getInstance();
		//设定属性是否可以序列化的过滤器
		mapper.setFilters(filterProvider);
		//设定日期的格式化--长格式
		mapper.setDateFormat(new SimpleDateFormat(DATA_FORMAT_LONG));
		
		StringWriter sw = new StringWriter();
		JsonGenerator jgen = null;
		try
		{
			jgen = new JsonFactory().createGenerator(sw);
			mapper.writeValue(jgen, obj);
		}
		finally
		{
			if(null != jgen) jgen.close();
		}
		
		return sw.toString();
	}
	
	/**
	 * 
	 *获取泛型的Collection Type .<br/>
	 * 用法示例：<br/>
	 * 
	 * 	JavaType javaType = getCollectionType(ArrayList.class, YourBean.class); <br/>
	 *	List<YourBean> lst =  (List<YourBean>)mapper.readValue(jsonString, javaType); 
	 *
	 * User: huijun.zheng<br/>
	 * Date: 2014-3-27<br/>
	 * Time: 下午1:44:53<br/>
	 *
	 * @param mapper ObjectMapper的实例
	 * @param collectionClass 泛型的Collection 
	 * @param elementClasses  元素类   
	 * @return Java类型  <br/>
	 */
	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses)
	{
		//获得ObjectMapper的实例
		ObjectMapper mapper = JacksonFactory.getInstance();
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}
}


/**
 * Jackson用于转换的核心类ObjectMapper无需每次都new一个object，
 * 官网上的一句话：can reuse, share globally
 * Created with MyElipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2013-8-5<br/>
 * Time: 下午6:35:29<br/><br/>
 */
class JacksonFactory
{
	private static final ObjectMapper mapper = new ObjectMapper();

	private JacksonFactory(){}
	
	public static ObjectMapper getInstance()
	{
		return mapper;
	}
}
