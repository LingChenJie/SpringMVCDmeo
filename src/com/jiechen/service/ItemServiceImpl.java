package com.jiechen.service;

import java.util.Date;
import java.util.List;

import com.jiechen.dao.ItemsMapper;
import com.jiechen.pojo.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 查询商品信息
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Items> queryItemsList() {
        List<Items> items = itemsMapper.selectByExampleWithBLOBs(null);
        System.out.println("items --> " + items.size());
        return items;
    }

    @Override
    public Items queryItemsById(Integer id) {
        return itemsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateItemsById(Items items) {
        items.setCreatetime(new Date());
        itemsMapper.updateByPrimaryKeyWithBLOBs(items);
    }
}
