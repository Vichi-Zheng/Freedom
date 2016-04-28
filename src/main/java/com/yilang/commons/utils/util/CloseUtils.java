/**
* Created with MyElipse.<br/>
* User: huijun.zheng<br/>
* Date: 2014-3-5<br/>
* Time: 下午3:53:57<br/>
*
* To change this template use File | Settings | File Templates.<br/>
*/
package com.yilang.commons.utils.util;

import java.io.Closeable;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created with MyElipse.<br/>
 * User: huijun.zheng<br/>
 * Date: 2014-3-5<br/>
 * Time: 下午3:53:57<br/>
 *<br/>
 */
public class CloseUtils
{
	/**
	 * 关闭流<br/>
	 * To change this template use File | Settings | File Templates.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2013-8-15<br/>
	 * Time: 上午11:43:08<br/>
	 * @param closeable<br/>
	 */
	public static final void safeClose(Closeable closeable)
	{
		if(null != closeable)
		{
			try
			{
				closeable.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭Socket<br/>
	 * To change this template use File | Settings | File Templates.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2013-8-15<br/>
	 * Time: 上午11:44:19<br/>
	 * @param socket<br/>
	 */
	public static final void safeClose(Socket socket)
	{
		if(null != socket)
		{
			try
			{
				socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 关闭ServerSocket<br/>
	 * To change this template use File | Settings | File Templates.<br/>
	 * User: huijun.zheng<br/>
	 * Date: 2013-8-15<br/>
	 * Time: 上午11:46:14<br/>
	 * @param serverSocket<br/>
	 */
	public static final void safeClose(ServerSocket serverSocket)
	{
		if(null != serverSocket)
		{
			try
			{
				serverSocket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
