package com.springboot.osgi.springbootosgi.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.descriptor.JspConfigDescriptor;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletRegistration.Dynamic;

/**
 * @author xinxian
 * @create 2019-12-19 11:06
 **/
public class MyContext implements ServletContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyContext.class);

    private String bundlesPath;

    public MyContext(String bundlesPath) {
        this.bundlesPath = bundlesPath;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getContextPath()
     */
    @Override
    public String getContextPath() {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getContext(java.lang.String)
     */
    @Override
    public ServletContext getContext(String uripath) {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getMajorVersion()
     */
    @Override
    public int getMajorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getMinorVersion()
     */
    @Override
    public int getMinorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getEffectiveMajorVersion()
     */
    @Override
    public int getEffectiveMajorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getEffectiveMinorVersion()
     */
    @Override
    public int getEffectiveMinorVersion() {
        // TODO Auto-generated method stub
        return 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getMimeType(java.lang.String)
     */
    @Override
    public String getMimeType(String file) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getResourcePaths(java.lang.String)
     */
    @Override
    public Set<String> getResourcePaths(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getResource(java.lang.String)
     */
    @Override
    public URL getResource(String path) throws MalformedURLException {
        if (!path.startsWith("/") || path.indexOf("launch.ini") == -1) {
            throw new MalformedURLException("Path '" + path + "' does not start with '/'");
        }
        String newDir = bundlesPath + "/eclipse/launch.ini";

        URL url = new File(newDir).toURI().toURL();
        try {
            url.openStream();
        } catch (Throwable t) {
            url = null;
        }
        return url;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getResourceAsStream(java.lang.String)
     */
    @Override
    public InputStream getResourceAsStream(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getRequestDispatcher(java.lang.String)
     */
    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getNamedDispatcher(java.lang.String)
     */
    @Override
    public RequestDispatcher getNamedDispatcher(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServlet(java.lang.String)
     */
    @Override
    public Servlet getServlet(String name) throws ServletException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServlets()
     */
    @Override
    public Enumeration<Servlet> getServlets() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServletNames()
     */
    @Override
    public Enumeration<String> getServletNames() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#log(java.lang.String)
     */
    @Override
    public void log(String msg) {
        LOGGER.info(msg);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#log(java.lang.Exception, java.lang.String)
     */
    @Override
    public void log(Exception exception, String msg) {
        LOGGER.info(msg, exception);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#log(java.lang.String, java.lang.Throwable)
     */
    @Override
    public void log(String message, Throwable throwable) {
        LOGGER.info(message, throwable);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getRealPath(java.lang.String)
     */
    @Override
    public String getRealPath(String path) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServerInfo()
     */
    @Override
    public String getServerInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getInitParameter(java.lang.String)
     */
    @Override
    public String getInitParameter(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getInitParameterNames()
     */
    @Override
    public Enumeration<String> getInitParameterNames() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#setInitParameter(java.lang.String, java.lang.String)
     */
    @Override
    public boolean setInitParameter(String name, String value) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getAttribute(java.lang.String)
     */
    @Override
    public Object getAttribute(String name) {
        LOGGER.info("the parameter is " + name);
        return new File(this.bundlesPath);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getAttributeNames()
     */
    @Override
    public Enumeration<String> getAttributeNames() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#setAttribute(java.lang.String, java.lang.Object)
     */
    @Override
    public void setAttribute(String name, Object object) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#removeAttribute(java.lang.String)
     */
    @Override
    public void removeAttribute(String name) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServletContextName()
     */
    @Override
    public String getServletContextName() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#addServlet(java.lang.String, java.lang.String)
     */
    @Override
    public Dynamic addServlet(String servletName, String className) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#addServlet(java.lang.String, javax.servlet.Servlet)
     */
    @Override
    public Dynamic addServlet(String servletName, Servlet servlet) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#addServlet(java.lang.String, java.lang.Class)
     */
    @Override
    public Dynamic addServlet(String servletName, Class<? extends Servlet> servletClass) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ServletRegistration.Dynamic addJspFile(String s, String s1) {
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#createServlet(java.lang.Class)
     */
    @Override
    public <T extends Servlet> T createServlet(Class<T> c) throws ServletException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServletRegistration(java.lang.String)
     */
    @Override
    public ServletRegistration getServletRegistration(String servletName) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getServletRegistrations()
     */
    @Override
    public Map<String, ? extends ServletRegistration> getServletRegistrations() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#createFilter(java.lang.Class)
     */
    @Override
    public <T extends Filter> T createFilter(Class<T> c) throws ServletException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getFilterRegistration(java.lang.String)
     */
    @Override
    public FilterRegistration getFilterRegistration(String filterName) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getFilterRegistrations()
     */
    @Override
    public Map<String, ? extends FilterRegistration> getFilterRegistrations() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getSessionCookieConfig()
     */
    @Override
    public SessionCookieConfig getSessionCookieConfig() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#setSessionTrackingModes(java.util.Set)
     */
    @Override
    public void setSessionTrackingModes(Set<SessionTrackingMode> sessionTrackingModes) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getDefaultSessionTrackingModes()
     */
    @Override
    public Set<SessionTrackingMode> getDefaultSessionTrackingModes() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getEffectiveSessionTrackingModes()
     */
    @Override
    public Set<SessionTrackingMode> getEffectiveSessionTrackingModes() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#addListener(java.lang.String)
     */
    @Override
    public void addListener(String className) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#addListener(java.util.EventListener)
     */
    @Override
    public <T extends EventListener> void addListener(T t) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#addListener(java.lang.Class)
     */
    @Override
    public void addListener(Class<? extends EventListener> listenerClass) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#createListener(java.lang.Class)
     */
    @Override
    public <T extends EventListener> T createListener(Class<T> c) throws ServletException {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getJspConfigDescriptor()
     */
    @Override
    public JspConfigDescriptor getJspConfigDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getClassLoader()
     */
    @Override
    public ClassLoader getClassLoader() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#declareRoles(java.lang.String[])
     */
    @Override
    public void declareRoles(String... roleNames) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletContext#getVirtualServerName()
     */
    @Override
    public String getVirtualServerName() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getSessionTimeout() {
        return 0;
    }

    @Override
    public void setSessionTimeout(int i) {

    }

    @Override
    public String getRequestCharacterEncoding() {
        return null;
    }

    @Override
    public void setRequestCharacterEncoding(String s) {

    }

    @Override
    public String getResponseCharacterEncoding() {
        return null;
    }

    @Override
    public void setResponseCharacterEncoding(String s) {

    }

    @Override
    public javax.servlet.FilterRegistration.Dynamic addFilter(String filterName, String className) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public javax.servlet.FilterRegistration.Dynamic addFilter(String filterName, Filter filter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public javax.servlet.FilterRegistration.Dynamic addFilter(String filterName, Class<? extends Filter> filterClass) {
        // TODO Auto-generated method stub
        return null;
    }
}
