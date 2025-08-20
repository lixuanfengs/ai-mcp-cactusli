package cn.cactusli.mcp.csdn.infrastructure.gateway.dto;

import lombok.Data;

/**
 * Package: cn.cactusli.csdn.infrastructure.gateway.dto
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/17 16:17
 * @Github https://github.com/lixuanfengs
 */
@Data
public class ArticleResponseDTO {
    private Integer code;
    private String traceId;
    private ArticleData data;
    private String msg;

    @Data
    public static class ArticleData {
        private String url;
        private Long id;
        private String qrcode;
        private String title;
        private String description;
    }

}
