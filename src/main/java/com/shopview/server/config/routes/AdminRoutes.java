package com.shopview.server.config.routes;

import com.jfinal.config.Routes;

/**
 * 后台管理请求控制路由
 * @author duhongg
 * @since 2018-06-06
 */
public class AdminRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/admin");
    }
}
