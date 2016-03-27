import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by gongxijun on 16-3-27.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {


    private static Logger logger;

    static {

        logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);
    }
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        logger.info(String.format("postProcessBeforeInitialization 被创建.... "));
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {

        logger.info(String.format("postProcessAfterInitialization 被创建.... "));
        return o;
    }
}
