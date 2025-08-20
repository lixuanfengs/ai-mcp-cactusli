package cn.cactusli.mcp.weixin.infrastructure.gateway.dto;

/**
 * Package: cn.cactusli.mcp.weixin.infrastructure.gateway.dto
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/7/3 11:03
 * @Github https://github.com/lixuanfengs
 */
public class WeixinTokenResponseDTO {

    private String access_token;
    private int expires_in;
    private String errcode;
    private String errmsg;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
