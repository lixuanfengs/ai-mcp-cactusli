package cn.cactusli.compute.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.Data;

/**
 * Package: cn.cactusli.compute.model
 * Description:
 *
 * @Author 仙人球⁶ᴳ |
 * @Date 2025/6/16 10:46
 * @Github https://github.com/lixuanfengs
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComputerFunctionRequest {

    @JsonProperty(required = true)
    @JsonPropertyDescription("电脑名称")
    private String computer;

}
