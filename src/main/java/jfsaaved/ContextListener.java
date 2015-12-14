package jfsaaved;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent)  { 
         // TODO Auto-generated method stub
        Connection con = (Connection) servletContextEvent.getServletContext().getAttribute("DBConnection");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
         // TODO Auto-generated method stub
    	 ServletContext ctx = servletContextEvent.getServletContext();
    	 
         String dbURL = ctx.getInitParameter("dbURL");
         String user = ctx.getInitParameter("dbUser");
         String pwd = ctx.getInitParameter("dbPassword");
         
         try {
             DBConnectionManager connectionManager = new DBConnectionManager(dbURL, user, pwd);
             ctx.setAttribute("DBConnection", connectionManager.getConnection());
             System.out.println("DB Connection initialized successfully.");
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
	
}
