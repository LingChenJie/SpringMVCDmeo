package com.jiechen.test;

import com.jiechen.dao.ItemsMapper;
import com.jiechen.pojo.Items;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DaoTest {

    private ApplicationContext context;

    @Before
    public void setUp() throws Exception {
        this.context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testQueryItem() {
        // 获取Mapper
        ItemsMapper itemsMapper = this.context.getBean(ItemsMapper.class);

        // 执行查询方法
        List<Items> items = itemsMapper.selectByExampleWithBLOBs(null);
        System.out.println(items.size());
    }

}
