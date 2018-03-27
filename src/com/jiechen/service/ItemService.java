package com.jiechen.service;

import com.jiechen.pojo.Items;

import java.util.List;


public interface ItemService {

    /**
     * 查询商品列表
     */
    List<Items> queryItemsList();

    /**
     * 根据id查询商品信息
     */
    Items queryItemsById(Integer id);

    /**
     * 更新商品信息
     */
    void updateItemsById(Items items);

}
