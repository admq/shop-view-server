package com.shopview.server.config;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;
import com.shopview.server.common.model.Goods;
import com.shopview.server.common.model.Shop;
import com.shopview.server.common.util.ApplicationConstant;
import com.shopview.server.config.routes.AdminRoutes;
import com.shopview.server.config.routes.FrontRoutes;

/**
 * @author duhongg
 * @since 2018-06-06
 */
public class ApplicationConfig extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    @Override
    public void configRoute(Routes me) {
        // 前端请求控制
        me.add(new FrontRoutes());
        // 后台管理请求控制
        me.add(new AdminRoutes());
    }

    @Override
    public void configEngine(Engine me) {
    }

    @Override
    public void configPlugin(Plugins me) {
        PropKit.use(ApplicationConstant.CONFIG_FILE_NAME);
        String url = PropKit.get("db.url");
        String username = PropKit.get("db.username");
        String password = PropKit.get("db.password");

        // 数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(url, username, password);
        me.add(druidPlugin);

        // ActiveRecord插件
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        activeRecordPlugin.setContainerFactory(new PropertyNameContainerFactory());
        activeRecordPlugin.addMapping("t_shop", Shop.class);
        activeRecordPlugin.addMapping("t_goods", Goods.class);
        me.add(activeRecordPlugin);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }
}
