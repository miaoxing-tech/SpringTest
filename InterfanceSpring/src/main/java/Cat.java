import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.w3c.dom.Node;

import javax.annotation.PostConstruct;

/**
 * Created by gongxijun on 16-3-27.
 */
public class Cat implements BeanFactoryAware, InitializingBean, BeanDefinitionDecorator, ApplicationContextAware {


    private static Logger logger;

    static {

        logger = LoggerFactory.getLogger(Cat.class);
    }

    String name;


    public Cat() {
        logger.info(String.format("构造被创建.... "));
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        logger.info(String.format("getName 被调用...."));
        return name;
    }

    public void setName(String name) {
        logger.info(String.format("setName 被调用.... "));
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info(String.format("setBeanFactory 被调用"));
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        logger.info(String.format("afterPropertiesSet 被调用.... "));
    }

    /**
     * 通过注解方式来配置
     */
    @PostConstruct
    public void ainit() {

        logger.info(String.format("ainit 被创建....   ainit通过注解的方式，而非配置的方式"));
    }
    public void init() {

        logger.info(String.format("init 被创建.... "));
    }

    public void destory() {
        logger.info(String.format("destory 被创建 .... "));
    }


    @Override
    public BeanDefinitionHolder decorate(Node node, BeanDefinitionHolder beanDefinitionHolder, ParserContext parserContext) {

        logger.info("BeanDefinitionHolder 被创建....");
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        logger.info(String.format("setApplicationContext 被创建..."));

    }

    public void destroy() {

        logger.info("destroy 被创建.... ");
    }
}
