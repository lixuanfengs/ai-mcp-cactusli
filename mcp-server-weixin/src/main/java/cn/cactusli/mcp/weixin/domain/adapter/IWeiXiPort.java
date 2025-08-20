package cn.cactusli.mcp.weixin.domain.adapter;

import cn.cactusli.mcp.weixin.domain.model.WeiXinNoticeFunctionRequest;
import cn.cactusli.mcp.weixin.domain.model.WeiXinNoticeFunctionResponse;

import java.io.IOException;

public interface IWeiXiPort {

    WeiXinNoticeFunctionResponse weixinNotice(WeiXinNoticeFunctionRequest request) throws IOException;

}
