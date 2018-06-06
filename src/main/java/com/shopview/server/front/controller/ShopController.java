package com.shopview.server.front.controller;

import com.jfinal.core.Controller;
import com.shopview.server.common.model.Shop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商家Controller
 * @author duhongg
 * @since 2018-06-06
 */
public class ShopController extends Controller {

    /**
     * 查询商品信息
     */
    public void index() {
//        List<Shop> shops = Shop.dao.find("select * from t_shop");
        Shop byId = Shop.dao.findById("17517a6c69a311e89c13531b8a6766c6");
        renderJson(byId);
    }

    public void add() {

    }

    public void edit() {
        Shop.dao.findById("17517a6c69a311e89c13531b8a6766c6").set("name", "牛逼的电脑").update();
        renderJson("success");
    }

    public void remove() {

    }
}
