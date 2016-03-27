import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gongxijun on 16-3-27.
 */
public class Main {

    public  static Logger  logger;
    static {

        logger = LoggerFactory.getLogger(Main.class);
    }
    public static void main(String [] args){

        ApplicationContext ac = new ClassPathXmlApplicationContext("/Beans.xml");
        Cat ct = (Cat) ac.getBean("tom");

        
    }

}
