package com.example.jaxrs.app;




import com.example.jaxrs.config.RestConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.servlet.ServletException;
import java.io.File;

/**
 *
 * @since Created at 2022-11-23 15:40
 */
public class Application {

    public static void main(String[] args) throws LifecycleException, ServletException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8086);
        Context context = tomcat.addWebapp("", new File(".").getAbsolutePath());
        ServletContainer servletContainer = new ServletContainer(new RestConfig());
        tomcat.addServlet("", "restConfig", servletContainer);
        context.addServletMappingDecoded("/restapi/*", "restConfig");
        tomcat.start();
        tomcat.getServer().await();

    }
}
