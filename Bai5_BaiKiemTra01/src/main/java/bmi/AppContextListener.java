package bmi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Ứng dụng BMI đã được khởi động.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Ứng dụng BMI đã dừng.");
    }	
}
