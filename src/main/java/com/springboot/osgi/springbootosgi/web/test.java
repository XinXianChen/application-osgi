package com.springboot.osgi.springbootosgi.web;

import com.perfma.bridge.SpringBootBridge;
import com.springboot.osgi.springbootosgi.service.MyFrameworkLauncher;
import org.eclipse.equinox.servletbridge.CloseableURLClassLoader;
import org.eclipse.equinox.servletbridge.FrameworkLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * @author xinxian
 * @create 2019-12-20 17:38
 **/
@Controller
public class test {

    @Autowired
    private MyFrameworkLauncher myFrameworkLauncher;

    @RequestMapping(value = "/getobj", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> getobj() {
        try {
            final ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println("SpringBootBridge: "+ contextClassLoader);
            ClassLoader frameworkClassLoad = getFrameworkClassLoad(myFrameworkLauncher);
            System.out.println("FrameworkClassLoad: " + frameworkClassLoad);

            Thread.currentThread().setContextClassLoader(frameworkClassLoad);

            final Class bridgeClass = frameworkClassLoad.loadClass("com.perfma.bridge.SpringBootBridge");
            final Field field = bridgeClass.getDeclaredField("instance");
            field.setAccessible(true);
            final Object o1 = field.get(null);
            Thread.currentThread().setContextClassLoader(contextClassLoader);
            return new ResponseEntity<String>(o1.toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<String>("error", HttpStatus.OK);

    }

    public static  Map<String,Object> getObjectToMap(Object t) throws IllegalAccessException {
        Class className = t.getClass();
        Map<String,Object> param=new HashMap<>();
        for(; className != Object.class ; className = className.getSuperclass()) {//获取本身和父级对象
            Field[] fields = className.getDeclaredFields();//获取所有私有字段
            for (Field field : fields) {
                field.setAccessible(true);
                param.put(field.getName(), field.get(t)==null?"":field.get(t));
            }
        }
        return param;
    }

    private CloseableURLClassLoader getFrameworkClassLoad(Object t) {
        Class className = t.getClass().getSuperclass();
        try {
            final Field frameworkClassLoader = className.getDeclaredField("frameworkClassLoader");
            frameworkClassLoader.setAccessible(true);
            return (CloseableURLClassLoader)frameworkClassLoader.get(t);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
