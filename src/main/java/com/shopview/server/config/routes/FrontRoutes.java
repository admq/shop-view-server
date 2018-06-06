package com.shopview.server.config.routes;

import com.jfinal.config.Routes;
import com.shopview.server.front.controller.GoodsController;
import com.shopview.server.front.controller.ShopController;

/**
 * 前端请求控制路由
 * @author duhongg
 * @since 2018-06-06
 */
public class FrontRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/front");
        add("/shop", ShopController.class);
        add("/goods", GoodsController.class);
    }
}
