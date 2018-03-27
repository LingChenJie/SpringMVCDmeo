package com.jiechen.controller;

import com.jiechen.pojo.Item;
import com.jiechen.pojo.Items;
import com.jiechen.pojo.QueryVo;
import com.jiechen.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("item")
public class ItemController2 {

    @Autowired
    private ItemService itemService;

    /**
     * 显示商品信息
     */
    @RequestMapping("/itemlist")
    public ModelAndView queryItemList(HttpServletRequest request) {

        List<Items> list = itemService.queryItemsList();

        ModelAndView mv = new ModelAndView();

        mv.addObject("list", list);

        mv.setViewName("itemList");

        return mv;
    }

    /**
     * 根据id查询商品
     */
    @RequestMapping("/itemEdit")
    public String queryItemList2(Integer id, ModelMap model) {
        // String strId = request.getParameter("id");
        // Integer id = Integer.valueOf(strId);

        Items items = itemService.queryItemsById(id);

        // ModelAndView mv = new ModelAndView();
        // mv.addObject("item", items);
        // mv.setViewName("itemEdit");
        // return mv;

        // 使用 model 代替 modelAndView
        model.addAttribute("item", items);
        return "itemEdit";
    }

    /**
     * value： 参数名字，即入参的请求参数名字，如value=“itemId” 表示请求的参数中的名字为 itemId 的参数的值将传入
     * required：是否必须，默认是true，表示请求中一定要有相应的参数，否则将报错
     * defaultValue：默认值，表示如果请求中没有同名参数时的默认值
     */
    @RequestMapping("/itemEdit2")
    public String queryItemList3(@RequestParam(value = "id", required = true, defaultValue = "1") Integer id, ModelMap model) {
        Items items = itemService.queryItemsById(id);

        // 使用 model 代替 modelAndView
        model.addAttribute("item", items);
        return "itemEdit";
    }

    /**
     * 更新商品，绑定pojo类型
     */
//    @RequestMapping("/updateitem")
//    public String updateItem(Items items) {
//        System.out.println(items.toString());
//        itemService.updateItemsById(items);
//        return "success";
//    }
    @RequestMapping("/queryitem")
    public String queryItem(QueryVo vo) {
        System.out.println(vo.getItem().getId());
        System.out.println(vo.getItem().getName());

        System.out.println(Arrays.toString(vo.getIds()));
        System.out.println(vo.getList());

        return "success";
    }

    @RequestMapping("updateitem")
    public String updateItemById(Items item, MultipartFile pictureFile) throws Exception {
        // 图片上传
        // 设置图片名称，不能重复，可以使用uuid
        String picName = UUID.randomUUID().toString();

        // 获取文件名
        String oriName = pictureFile.getOriginalFilename();
        // 获取图片后缀
        String extName = oriName.substring(oriName.lastIndexOf("."));

        // 开始上传
        pictureFile.transferTo(new File("E:/java/temp/upload/" + picName + extName));

        // 设置图片名到商品中
        item.setPic(picName + extName);
        // ---------------------------------------------
        // 更新商品
        this.itemService.updateItemsById(item);

        return "forward:/itemEdit.action";
    }

    @RequestMapping("/testjson")
    public @ResponseBody
    Items testJson(@RequestBody Items item) {
        System.out.println(item.toString());
        return item;
    }

}
