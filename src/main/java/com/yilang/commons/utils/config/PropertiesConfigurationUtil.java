package com.yilang.commons.utils.config;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesConfigurationUtil
{
	private static final Logger log = LoggerFactory.getLogger(PropertiesConfigurationUtil.class);
	
	private static final String fileName = "config.properties"; 
	
	private static final ReentrantLock lock = new ReentrantLock();
	
	private static final Map<String,PropertiesConfiguration> pcMap= new ConcurrentHashMap<String,PropertiesConfiguration>();
	
	private static PropertiesConfigurationUtil instance;

	private PropertiesConfiguration config;

	private PropertiesConfigurationUtil()
	{
		try
		{
			this.config = new PropertiesConfiguration(fileName);
			pcMap.put(fileName, config);
		}
		catch (Exception e)
		{
			log.error("Unable to load the configuration from the File:"+fileName, e);
		}
	}
	
	public static PropertiesConfigurationUtil getInstance()
	{
		if (instance == null)
		{
			synchronized (PropertiesConfigurationUtil.class)
			{
				if (instance == null) instance = new PropertiesConfigurationUtil();
			}
		}
		return instance;
	}
	

	public int getIntegerVal(String key)
	{
		return config.getInt(key,0);
	}
	
	public int getIntegerVal(String key,String propName)
	{
		return this.getConfiguration(propName).getInt(key,0);
	}

	public Long getLongVal(String key)
	{
		return config.getLong(key,0);
	}
	
	public Long getLongVal(String key,String propName)
	{
		return this.getConfiguration(propName).getLong(key, 0);
	}

	public Boolean getBooleanVal(String key)
	{
		return config.getBoolean(key, false);
	}
	
	public Boolean getBooleanVal(String key,String propName)
	{
		return this.getConfiguration(propName).getBoolean(key, false);
	}
	
	public String getStringVal(String key)
	{
		return config.getString(key,"");
	}
	
	public String getStringVal(String key,String propName)
	{
		return this.getConfiguration(propName).getString(key);
	}
	
	public String[] getStringArrayVal(String key)
	{
		return config.getStringArray(key);
	}
	
	public String[] getStringArrayVal(String key,String propName)
	{
		return this.getConfiguration(propName).getStringArray(key);
	}
	
	
	public String getStringValByUTF8Encoding(String key)
	{
		return getStringValByEncoding(key,"UTF-8");
	}
	
	public String getStringValByEncoding(String key,String encoding)
	{
		try
		{
			return new String(getStringVal(key).getBytes("ISO8859-1"),encoding);
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	private PropertiesConfiguration getConfiguration(String propName)
	{
		lock.lock();
		try
		{
			if(!pcMap.containsKey(propName))
			{
				PropertiesConfiguration pc;
				try
				{
					pc = new PropertiesConfiguration(propName);
					pcMap.put(propName,pc);
				}
				catch (ConfigurationException e)
				{
					e.printStackTrace();
					pc = config;
				}
				return pc;
			}
			return pcMap.get(propName);
		}
		finally
		{
			lock.unlock();
		}
	}
}
