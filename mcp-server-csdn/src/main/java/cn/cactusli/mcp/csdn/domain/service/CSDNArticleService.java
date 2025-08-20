package cn.cactusli.mcp.csdn.domain.service;

import cn.cactusli.mcp.csdn.domain.adapter.ICSDNPort;
import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionRequest;
import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Package: cn.cactusli.csdn.domain.service
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/16 17:55
 * @Github https://github.com/lixuanfengs
 */
@Service
@Slf4j
public class CSDNArticleService {

    @Resource
    private ICSDNPort port;

    @Tool(description = "发布文章到CSDN")
    public ArticleFunctionResponse saveArticle(ArticleFunctionRequest request) throws IOException {
        log.info("CSDN发帖，标题:{} 内容:{} 标签:{}", request.getTitle(), request.getMarkdowncontent(), request.getTags());
        return port.writeArticle(request);
    }

}
