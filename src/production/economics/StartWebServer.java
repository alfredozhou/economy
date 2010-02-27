package economics;

import org.mortbay.component.AbstractLifeCycle;
import org.mortbay.jetty.webapp.WebAppContext;
import org.mortbay.jetty.handler.ContextHandlerCollection;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;


public class StartWebServer {
    private static int PORT = 8080;

    public static void main(String[] args) {
        if (args.length == 1) PORT = Integer.parseInt(args[0]);
        Server server = new Server(PORT);
        WebAppContext context = new WebAppContext(server, ".", "/");
        context.addServlet(springConfig(), "/*");
        start(server);
    }

    private static ServletHolder springConfig() {
        DispatcherServlet servletDispatcher = new DispatcherServlet();
        servletDispatcher.setContextConfigLocation("classpath:dispatcher-servlet.xml");
        ServletHolder holder = new ServletHolder();
        holder.setServlet(servletDispatcher);
        return holder;
    }

    private static void start(AbstractLifeCycle server) {
        try {
            server.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}