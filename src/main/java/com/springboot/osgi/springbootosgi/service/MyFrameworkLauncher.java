package com.springboot.osgi.springbootosgi.service;

import com.springboot.osgi.springbootosgi.context.MyConfig;
import org.eclipse.equinox.servletbridge.FrameworkLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.jar.Attributes;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

/**
 * @author xinxian
 * @create 2019-12-19 14:07
 **/
@Service
public class MyFrameworkLauncher extends FrameworkLauncher {


    @Value(value = "${osgi.bundles.path}")
    private String bundlesPath;

    /**
     * initialize the osgi framework
     *
     *
     */
    @PostConstruct
    public void initialize() {
        System.setProperty("osgi.bundles.path", bundlesPath);
        this.config = new MyConfig(bundlesPath);
        this.context = config.getServletContext();

//        File servletTemp = (File) this.context.getAttribute("javax.servlet.context.tempdir");
//        File platformDirectory = new File(servletTemp, "eclipse");
//        File plugins = new File(platformDirectory, "plugins");
//        deployBridgeExtensionBundle(plugins);

        this.deploy();
        System.out.println("MyFrameworkLauncher platform directory is located at " + getPlatformDirectory());
        this.start();
    }
    private void deployBridgeExtensionBundle(File plugins){
        File extensionBundle = new File(plugins, "com.perfma.bridge.extensionbundle.jar");
        File extensionBundleDir = new File(plugins, "com.perfma.bridge.extensionbundle");
        if ((extensionBundle.exists()) || ((extensionBundleDir.exists()) && (extensionBundleDir.isDirectory()))) {
            return;
        }
        Manifest mf = new Manifest();
        Attributes attribs = mf.getMainAttributes();
        attribs.putValue("Manifest-Version", "1.0");
        attribs.putValue("Bundle-ManifestVersion", "2");
        attribs.putValue("Bundle-Name", "bridge Extension Bundle");
        attribs.putValue("Bundle-SymbolicName", "com.test.bridge.extensionbundle");
        attribs.putValue("Bundle-Version", "1.0.0");
        attribs.putValue("Fragment-Host", "system.bundle; extension:=framework");
        String packageExports = "com.perfma.bridge";
        attribs.putValue("Export-Package", packageExports);
        try {
            JarOutputStream jos = null;
            try {
                jos = new JarOutputStream(new FileOutputStream(extensionBundle), mf);
                jos.finish();
            } finally {
                if (jos != null) {
                    jos.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error generating extension bundle" + e);
        }
    }

}
