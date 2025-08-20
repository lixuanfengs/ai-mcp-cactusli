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
 * @Date 2025/6/16 10:48
 * @Github https://github.com/lixuanfengs
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ComputerFunctionResponse {

    @JsonProperty(required = true, value = "osName")
    @JsonPropertyDescription("操作系统名称")
    private String osName;

    @JsonProperty(required = true, value = "osVersion")
    @JsonPropertyDescription("操作系统版本")
    private String osVersion;

    @JsonProperty(required = true, value = "osArch")
    @JsonPropertyDescription("操作系统架构")
    private String osArch;

    @JsonProperty(required = true, value = "userName")
    @JsonPropertyDescription("用户的账户名称")
    private String userName;

    @JsonProperty(required = true, value = "userHome")
    @JsonPropertyDescription("用户的主目录")
    private String userHome;

    @JsonProperty(required = true, value = "userDir")
    @JsonPropertyDescription("用户的当前工作目录")
    private String userDir;

    @JsonProperty(required = true, value = "javaVersion")
    @JsonPropertyDescription("Java 运行时环境版本")
    private String javaVersion;

    @JsonProperty(required = true, value = "osInfo")
    @JsonPropertyDescription("系统信息")
    private String osInfo;

}
