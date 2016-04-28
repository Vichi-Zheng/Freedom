/**
 * @author : huijun.zheng<br/>
 * @Date: 2014-12-19<br/>
 * @Time: 上午3:21:38<br/>
 * To change this template use File | Settings | File Templates.<br/>
 */
package com.yilang.commons.utils.request;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest 工具类
 * 
 * @author : huijun.zheng<br/>
 * @Date: 2014-12-19<br/>
 * @Time: 上午3:21:38<br/>
 * <br/>
 */
public class HttpServletUtils
{
	/**
	 * 
	 * 获得客户端的ip地址 .<br/>
	 * @author : huijun.zheng<br/>
	 * @Date: 2014-12-19<br/>
	 * @Time: 上午3:23:43<br/>
	 * @param request
	 * @return<br/>
	 */
	public static String getIpAddr(HttpServletRequest request)
	{
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("Proxy-Client-IP");
		}
		else
		{
			String[] ips = ip.split(",");
			if(1 < ips.length)
			{
				ip = ips[0];
			}
		}
		
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		{
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
