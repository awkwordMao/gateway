package shiyue.jery.gateway.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Jery
 * @date 2019/9/7
 */
public class TomcatTest {

    private static int PORT = 8080; //端口
    private static String CONTEX_PATH = "/toov5";  //项目访问名称
    private static String SERVLET_NAME = "IndexServet";

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getHost().setAutoDeploy(false);
        StandardContext standardContext = new StandardContext();
        standardContext.setPath(CONTEX_PATH);
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        tomcat.getHost().addChild(standardContext);
        tomcat.addServlet(CONTEX_PATH, SERVLET_NAME, new IndexServlet());
        standardContext.addServletMappingDecoded("/index", SERVLET_NAME);
        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        System.out.println("Tomcat启动成功");
        tomcat.getServer().await();
    }
}
