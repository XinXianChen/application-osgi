package com.springboot.osgi.springbootosgi.context;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 * @author xinxian
 * @create 2019-12-19 11:06
 **/
public class MyConfig implements ServletConfig {
    private final MyContext myContext;

    public MyConfig(String bundlesPath) {
        myContext = new MyContext(bundlesPath);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletConfig#getServletName()
     */
    @Override
    public String getServletName() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletConfig#getServletContext()
     */
    @Override
    public ServletContext getServletContext() {
        // TODO Auto-generated method stub
        return myContext;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletConfig#getInitParameter(java.lang.String)
     */
    @Override
    public String getInitParameter(String name) {

        return "-console";
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.servlet.ServletConfig#getInitParameterNames()
     */
    @Override
    public Enumeration<String> getInitParameterNames() {
        // TODO Auto-generated method stub
        return null;
    }

}
