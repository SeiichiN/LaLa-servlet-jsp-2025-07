package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SetAnswerListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
    	Integer answer = (int)(Math.random() * 100);
    	//                new Random().nextInt(100);
    	ServletContext context = sce.getServletContext();
    	context.setAttribute("answer", answer);
    }
	
}
