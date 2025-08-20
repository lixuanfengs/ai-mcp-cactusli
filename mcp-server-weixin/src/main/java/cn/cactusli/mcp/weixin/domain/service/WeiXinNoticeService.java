package cn.cactusli.mcp.weixin.domain.service;

import cn.cactusli.mcp.weixin.domain.adapter.IWeiXiPort;
import cn.cactusli.mcp.weixin.domain.model.WeiXinNoticeFunctionRequest;
import cn.cactusli.mcp.weixin.domain.model.WeiXinNoticeFunctionResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 微信通知服务接口
 */
@Slf4j
@Service
public class WeiXinNoticeService {

    @Resource
    private IWeiXiPort weiXiPort;

    @Tool(description = "微信公众号消息通知")
    public WeiXinNoticeFunctionResponse weixinNotice(WeiXinNoticeFunctionRequest request) throws IOException {
        log.info("微信消息通知，平台:{} 主题:{} 描述:{}", request.getPlatform(), request.getSubject(), request.getDescription());
        return weiXiPort.weixinNotice(request);
    }

}
