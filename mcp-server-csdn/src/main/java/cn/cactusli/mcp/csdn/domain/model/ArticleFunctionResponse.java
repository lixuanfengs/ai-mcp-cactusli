package cn.cactusli.mcp.csdn.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Package: cn.cactusli.csdn.domain.model
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/16 17:52
 * @Github https://github.com/lixuanfengs
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArticleFunctionResponse {

    @JsonProperty(required = true, value = "code")
    @JsonPropertyDescription("code")
    private Integer code;

    @JsonProperty(required = true, value = "msg")
    @JsonPropertyDescription("msg")
    private String msg;

    @JsonProperty(required = true, value = "articleData")
    @JsonPropertyDescription("articleData")
    private ArticleData articleData;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ArticleData {
        @JsonProperty(required = true, value = "url")
        @JsonPropertyDescription("url")
        private String url;

        @JsonProperty(required = true, value = "id")
        @JsonPropertyDescription("id")
        private Long id;

        @JsonProperty(required = true, value = "qrcode")
        @JsonPropertyDescription("qrcode")
        private String qrcode;

        @JsonProperty(required = true, value = "title")
        @JsonPropertyDescription("title")
        private String title;

        @JsonProperty(required = true, value = "description")
        @JsonPropertyDescription("description")
        private String description;
    }
}
