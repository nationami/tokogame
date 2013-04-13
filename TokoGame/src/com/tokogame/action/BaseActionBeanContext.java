/**
 * 
 */
package com.tokogame.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.integration.spring.SpringHelper;

/**
 * @author mardy jonathan
 *
 */
public class BaseActionBeanContext extends ActionBeanContext {
    public HttpSession getSession() {
        return getRequest().getSession();
    }

    public void setCurrent(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T getCurrent(String key, T defaultValue) {
        T value = (T) getSession().getAttribute(key);
        if (value == null) {
            value = defaultValue;
            setCurrent(key, value);
        }

        return value;
    }

    /**
     * @see net.sourceforge.stripes.action.ActionBeanContext#setServletContext(javax.servlet.ServletContext)
     */
    public void setServletContext(ServletContext servletContext) {
        SpringHelper.injectBeans(this, servletContext);
        super.setServletContext(servletContext);
    }
    
    
        
}
