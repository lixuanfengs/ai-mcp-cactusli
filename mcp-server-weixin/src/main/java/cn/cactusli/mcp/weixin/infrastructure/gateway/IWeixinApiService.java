package cn.cactusli.mcp.weixin.infrastructure.gateway;

import cn.cactusli.mcp.weixin.infrastructure.gateway.dto.WeixinTemplateMessageDTO;
import cn.cactusli.mcp.weixin.infrastructure.gateway.dto.WeixinTokenResponseDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Package: cn.cactusli.mcp.weixin.infrastructure.gateway
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/7/3 10:58
 * @Github https://github.com/lixuanfengs
 */
public interface IWeixinApiService {

    /**
     * 获取 Access token
     * 文档：<a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html">Get_access_token</a>
     *
     * @param grantType 获取access_token填写client_credential
     * @param appId     第三方用户唯一凭证
     * @param appSecret 第三方用户唯一凭证密钥，即appsecret
     * @return 响应结果
     */
    @GET("cgi-bin/token")
    Call<WeixinTokenResponseDTO> getToken(
            @Query("grant_type") String grantType,
            @Query("appid") String appId,
            @Query("secret") String appSecret
    );

    /**
     * 发送微信公众号模板消息
     * 文档：<a href="https://mp.weixin.qq.com/debug/cgi-bin/readtmpl?t=tmplmsg/faq_tmpl">https://mp.weixin.qq.com/debug/cgi-bin/readtmpl?t=tmplmsg/faq_tmpl</a>
     *
     * @param accessToken              getToken 获取的 token 信息
     * @param weixinTemplateMessageDTO 入参对象
     * @return 应答结果
     */
    @POST("cgi-bin/message/template/send")
    Call<Void> sendMessage(@Query("access_token") String accessToken, @Body WeixinTemplateMessageDTO weixinTemplateMessageDTO);

}
