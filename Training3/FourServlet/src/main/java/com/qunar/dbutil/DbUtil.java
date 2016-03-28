package com.qunar.dbutil;


import com.google.common.collect.Lists;
import com.qunar.bean.dbBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qunar.bean.PageVistor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.*;
import java.util.List;


/**
 * Created by gongxijun on 16-3-22.
 */
public class DbUtil {

    private static final String CONFIG_PROPERTIES = "classpath:Beans.xml";


    private static dbBean dataBean;
    private static BeanFactory beanFactory;
    static Logger logger = LoggerFactory.getLogger(DbUtil.class);
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    static {
        try {
            beanFactory = new FileSystemXmlApplicationContext(CONFIG_PROPERTIES);

            dataBean = (dbBean) beanFactory.getBean("dbBean");
            Class.forName(dataBean.getDriver());
        } catch (ClassNotFoundException e) {
            logger.info(String.format("sql exception0 : %s", e));
        }
    }


    public List<PageVistor> Query(String sql) {

        List<PageVistor> PageVisitors = Lists.newArrayList();

        try {
            connection = DriverManager.getConnection(dataBean.getUrl(),
                    dataBean.getUsername(), dataBean.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                PageVisitors.add(new PageVistor(0, "", resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            logger.info(String.format("exe inf :%s", e));
        } finally {
            try {
                if (!resultSet.isClosed())
                    resultSet.close();
                if (!preparedStatement.isClosed())
                    preparedStatement.close();
                if (!connection.isClosed())
                    connection.close();

            } catch (SQLException e) {
                logger.info(String.format("sql exception1 : %s", e));
            }
        }
        return PageVisitors;
    }


    public void Update(String sql) {
        try {

            connection = DriverManager.getConnection(dataBean.getUrl(),
                    dataBean.getUsername(), dataBean.getPassword());
            preparedStatement = connection.prepareStatement(sql);

            int var = preparedStatement.executeUpdate();
            if (0 == var) logger.info("UpdateData failure !");

        } catch (SQLException e) {
            logger.info(String.format("sql exception2 : %s", e));

        } finally {
            try {
                if (!preparedStatement.isClosed())
                    preparedStatement.close();
                if (!connection.isClosed())
                    connection.close();

            } catch (SQLException e) {
                logger.info(String.format("sql exception3 : %s", e));
            }
        }
    }
}