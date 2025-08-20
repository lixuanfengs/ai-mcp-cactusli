package cn.cactusli.mcp.csdn.types.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Package: cn.cactusli.csdn.types.properties
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/17 16:18
 * @Github https://github.com/lixuanfengs
 */
@ConfigurationProperties(prefix = "csdn.api")
@Component
public class CSDNApiProperties {

    private String cookie;

    private String categories;

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

}
