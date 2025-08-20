package cn.cactusli.mcp.csdn.infrastructure.adapter;

import cn.cactusli.mcp.csdn.domain.adapter.ICSDNPort;
import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionRequest;
import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionResponse;
import cn.cactusli.mcp.csdn.infrastructure.gateway.ICSDNService;
import cn.cactusli.mcp.csdn.infrastructure.gateway.dto.ArticleRequestDTO;
import cn.cactusli.mcp.csdn.infrastructure.gateway.dto.ArticleResponseDTO;
import cn.cactusli.mcp.csdn.types.properties.CSDNApiProperties;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

/**
 * Package: cn.cactusli.csdn.infrastructure.adapter
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/17 16:14
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@Component
public class CSDNPort implements ICSDNPort {

    @Resource
    private ICSDNService csdnService;

    @Resource
    private CSDNApiProperties csdnApiProperties;

    @Override
    public ArticleFunctionResponse writeArticle(ArticleFunctionRequest request) throws IOException {

        ArticleRequestDTO articleRequestDTO = new ArticleRequestDTO();
        articleRequestDTO.setTitle(request.getTitle());
        articleRequestDTO.setMarkdowncontent(request.getMarkdowncontent());
        articleRequestDTO.setContent(request.getContent());
        articleRequestDTO.setTags(request.getTags());
        articleRequestDTO.setDescription(request.getDescription());
        articleRequestDTO.setCategories(csdnApiProperties.getCategories());

        Call<ArticleResponseDTO> call = csdnService.saveArticle(articleRequestDTO, csdnApiProperties.getCookie());
        Response<ArticleResponseDTO> response = call.execute();

        log.info("请求CSDN发帖 \nreq:{} \nres:{}", JSON.toJSONString(articleRequestDTO), JSON.toJSONString(response));

        if (response.isSuccessful()) {
            ArticleResponseDTO articleResponseDTO = response.body();
            if (null == articleResponseDTO) return null;
            ArticleResponseDTO.ArticleData articleData = articleResponseDTO.getData();

            ArticleFunctionResponse articleFunctionResponse = new ArticleFunctionResponse();
            articleFunctionResponse.setCode(articleResponseDTO.getCode());
            articleFunctionResponse.setMsg(articleResponseDTO.getMsg());
            articleFunctionResponse.setArticleData(ArticleFunctionResponse.ArticleData.builder()
                    .url(articleData.getUrl())
                    .id(articleData.getId())
                    .qrcode(articleData.getQrcode())
                    .title(articleData.getTitle())
                    .description(articleData.getDescription())
                    .build());

            return articleFunctionResponse;
        }
        return null;
    }

}
