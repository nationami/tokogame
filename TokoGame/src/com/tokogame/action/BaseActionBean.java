/**
 * 
 */
package com.tokogame.action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.LocalizableMessage;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.controller.UrlBinding;
import net.sourceforge.stripes.controller.UrlBindingFactory;
import net.sourceforge.stripes.localization.LocalizationUtility;
import net.sourceforge.stripes.validation.LocalizableError;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrorHandler;
import net.sourceforge.stripes.validation.ValidationErrors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author mardy jonathan
 *
 */
public abstract class BaseActionBean implements ActionBean, ValidationErrorHandler {
	
	private static final Log		log		= LogFactory.getLog(BaseActionBean.class);
	
	protected BaseActionBeanContext	context;
	protected boolean				newData;
	protected static String			currentPageId;
	protected String				targetPage;
	protected int					offset;
	protected int					records;

	

	

	@DefaultHandler
	abstract public Resolution show();

	

	protected void addLocalizableError(String key, String field, Object... params) {
		ValidationErrors errors = getContext().getValidationErrors();
		String[] arrFields = field.split("-");
		for (int i = 0; i < arrFields.length; i++) {
			errors.add(arrFields[i], new LocalizableError(key, params));
		}
	}

	protected void addFieldError(String field, String key, Object... params) {
		getContext().getValidationErrors().add(field, new LocalizableError(key, params));

		ValidationErrors errors = getContext().getValidationErrors();
		StringBuilder message = new StringBuilder();
		for (List<ValidationError> fieldErrors : errors.values()) {
			for (ValidationError error : fieldErrors) {
				log.debug("Msg: " + error.getMessage(this.getContext().getLocale()));
				message.append(error.getMessage(this.getContext().getLocale()));
			}
		}

		errors.addGlobalError(new SimpleError(message.toString()));

		this.getContext().setValidationErrors(errors);
	}

	protected void addGlobalError(String key, Object... params) {
		context.getValidationErrors().addGlobalError(new LocalizableError(key, params));
	}

	protected void addSimpleMessage(String msg, Object... params) {
		context.getMessages().add(new SimpleMessage(msg, params));
	}

	protected void addLocalizeableMessage(String key, Object... params) {
		context.getMessages().add(new LocalizableMessage(key, params));
	}

	protected String getLocalizeableMessage(String key) {
		Locale locale = context.getRequest().getLocale();

		return LocalizationUtility.getErrorMessage(locale, key);
	}

	protected String getRequestParameter(String parameterName, String defaultValue) {
		HttpServletRequest request = context.getRequest();
		String value = request.getParameter(parameterName);
		if (value != null) {
			return value;
		}

		return defaultValue;
	}

	protected int getRequestParameter(String parameterName, int defaultValue) {
		HttpServletRequest request = context.getRequest();
		String value = request.getParameter(parameterName);
		if (value != null) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) { /* ignore */
			}
		}

		return defaultValue;
	}

	protected double getRequestParameter(String parameterName, double defaultValue) {
		HttpServletRequest request = context.getRequest();
		String value = request.getParameter(parameterName);
		if (value != null) {
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException e) { /* ignore */
			}
		}

		return defaultValue;
	}

	public boolean getRequestParameter(String parameterName, boolean defaultValue) {
		HttpServletRequest request = context.getRequest();
		String value = request.getParameter(parameterName);
		if (value != null) {
			return Boolean.parseBoolean(value);
		}

		return defaultValue;
	}

	protected void setRequestAttribute(String parameterName, Object value) {
		HttpServletRequest request = context.getRequest();
		request.setAttribute(parameterName, value);
	}

	protected void setSessionAttribute(String key, Object value) {
		getContext().getRequest().getSession().setAttribute(key, value);
	}

	public Object getSessionAttribute(String key) {
		return (Object) getContext().getRequest().getSession().getAttribute(key);
	}
	
	protected void removeSessionAttribute(String key) {
		getContext().getRequest().getSession().removeAttribute(key);
	}

	public Date getToday() {
		return Calendar.getInstance().getTime();
	}

	public String getUrlBinding() {
		UrlBinding urlBinding = UrlBindingFactory.getInstance().getBindingPrototype(getClass());

		return urlBinding.getPath();
	}

	@SuppressWarnings("unchecked")
	public String getLastUrl() {
		HttpServletRequest req = getContext().getRequest();
		StringBuilder sb = new StringBuilder();

		// Start with the URI and the path
		String uri = (String) req.getAttribute("javax.servlet.forward.request_uri");
		// String path = (String)
		// req.getAttribute("javax.servlet.forward.path_info");
		if (uri == null) {
			uri = req.getRequestURI();
			// path = req.getPathInfo();
		}
		sb.append(uri);
		// if (path != null) { sb.append(path); }

		// Now the request parameters
		sb.append('?');
		Map<String, String[]> map = new HashMap<String, String[]>(req.getParameterMap());

		// Remove previous locale parameter, if present.
		map.remove("locale");

		// Append the parameters to the URL
		for (String key : map.keySet()) {
			String[] values = map.get(key);
			for (String value : values) {
				sb.append(key).append('=').append(value).append('&');
			}
		}
		// Remove the last '&'
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	

	/**
	 * Gets the ActionBeanContext set by Stripes during initialization.
	 */
	public BaseActionBeanContext getContext() {
		return context;
	}

	public void setContext(ActionBeanContext context) {
		this.context = (BaseActionBeanContext) context;
	}

	public String getCurrentPageId() {
		return currentPageId;
	}

	public void setCurrentPageId(String currentPageId) {
		BaseActionBean.currentPageId = currentPageId;
	}

	public boolean isNewData() {
		return newData;
	}

	public void setNewData(boolean newData) {
		this.newData = newData;
	}

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPage() {
		int page = Math.round((offset / 10) + 0.5f);
		return page; // > getPages() ? getPages() : page;
	}

	public int getRecords() {
		return records;
	}

	public void setRecords(int records) {
		this.records = records;
	}

	public int getPages() {
		return Math.round((records / 10) + 0.5f);
	}

	/**
	 * @see
	 * net.sourceforge.stripes.validation.ValidationErrorHandler#handleValidationErrors(net.sourceforge.stripes.validation.ValidationErrors)
	 */
	public Resolution handleValidationErrors(ValidationErrors errors) throws Exception {
		return null;
	}
	
	

}
