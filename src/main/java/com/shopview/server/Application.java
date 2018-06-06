package com.shopview.server;

import com.jfinal.core.JFinal;
import com.shopview.server.common.util.ApplicationConstant;

/**
 * 项目启动
 */
public class Application {
    public static void main(String[] args) {
        JFinal.start(ApplicationConstant.WEB_APP_DIR, ApplicationConstant.PORT, "/");
    }
}
