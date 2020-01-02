package com.springboot.osgi.springbootosgi.web;

import com.perfma.bridge.SpringBootBridge;


/**
 * @author xinxian
 * @create 2019-12-22 14:36
 **/
public class Result {

    public static Integer getResult() {
        final SpringBootBridge o1 = (SpringBootBridge)SpringBootBridge.getInstance().acquireDelegateReference();
        return (Integer) o1.acquireDelegateReference();
    }
}
