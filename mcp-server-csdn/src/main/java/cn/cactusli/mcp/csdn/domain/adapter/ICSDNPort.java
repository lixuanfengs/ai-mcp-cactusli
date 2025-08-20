package cn.cactusli.mcp.csdn.domain.adapter;

import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionRequest;
import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionResponse;

import java.io.IOException;

/**
 * Package: cn.cactusli.csdn.domain.adapter
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/16 17:51
 * @Github https://github.com/lixuanfengs
 */
public interface ICSDNPort {

    ArticleFunctionResponse writeArticle(ArticleFunctionRequest request) throws IOException;

}
