/**
 * Copyright 2012
 * VAN
 */
package vaidyaa.gwt.gwt_webapp.interceptor;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author vaidyaa
 * 
 */
public class ActionClassLoggingInterceptor implements Interceptor {

	private static final long serialVersionUID = 2152431286125111690L;

	public static Logger LOG = Logger.getLogger("INTERCEPTOR_LOGGER");

	public void destroy() {
		LOG.info("Inside destroy");
	}

	public void init() {
		LOG.info("Inside init");
	}

	public String intercept(ActionInvocation actionInvoke) throws Exception {
		LOG.info("Inside Intercept method ");
		String result = actionInvoke.invoke();
		LOG.info(result);
		return result;
	}

}
