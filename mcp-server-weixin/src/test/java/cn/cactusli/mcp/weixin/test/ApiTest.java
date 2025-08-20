package cn.cactusli.mcp.weixin.test;

import cn.cactusli.mcp.weixin.infrastructure.gateway.IWeixinApiService;
import cn.cactusli.mcp.weixin.infrastructure.gateway.dto.WeixinTemplateMessageDTO;
import cn.cactusli.mcp.weixin.infrastructure.gateway.dto.WeixinTokenResponseDTO;
import cn.cactusli.mcp.weixin.types.properties.WeiXinApiProperties;
import com.alibaba.fastjson2.JSON;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    @Resource
    private WeiXinApiProperties weiXinApiProperties;
    @Resource
    private IWeixinApiService weixinApiService;

    private String accessToken = "94_BLy_ihr6vpGtLvzokg5iFYQruDZ9mhTdh9L7PxIimCibhqC9lTfA5T9AR6eFYmHlp532p-fwe8xKKlpascxusEuU6E7VxKSDEyBsQ25ujYxc5jIrKgOoYVc5KegZMOcABAQDF";

    @Before
    public void before() throws IOException {
        Call<WeixinTokenResponseDTO> call = weixinApiService.getToken("client_credential", weiXinApiProperties.getAppid(), weiXinApiProperties.getAppsecret());
        WeixinTokenResponseDTO weixinTokenResponseDTO = call.execute().body();
        assert weixinTokenResponseDTO != null;
        accessToken = weixinTokenResponseDTO.getAccess_token();
        log.info("weixin accessToken:{}", accessToken);
    }

    @Test
    public void test_template_message() throws IOException {
        Map<String, Map<String, String>> data = new HashMap<>();
        WeixinTemplateMessageDTO.put(data, WeixinTemplateMessageDTO.TemplateKey.platform, "CSDN");
        WeixinTemplateMessageDTO.put(data, WeixinTemplateMessageDTO.TemplateKey.subject, "互联网大厂Java面试实录：李某某的奇幻面试旅程");
        WeixinTemplateMessageDTO.put(data, WeixinTemplateMessageDTO.TemplateKey.description, "在一个阳光明媚的早晨，李某某走进了某互联网大厂的面试间，准备接受一场关于Java技术的洗礼。坐在他对面的是一位看起来十分严肃的面试官。");

        WeixinTemplateMessageDTO templateMessageDTO = new WeixinTemplateMessageDTO(weiXinApiProperties.getTouser(), weiXinApiProperties.getTemplate_id());
        templateMessageDTO.setUrl("https://blog.csdn.net/qq_34968019/article/details/149120617");
        templateMessageDTO.setData(data);

        Call<Void> call = weixinApiService.sendMessage(accessToken, templateMessageDTO);
        call.execute();

        log.info("请求参数:{}", JSON.toJSONString(templateMessageDTO));
    }

}
