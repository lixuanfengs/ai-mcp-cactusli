package cn.cactusli.mcp.csdn;

import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionRequest;
import cn.cactusli.mcp.csdn.domain.model.ArticleFunctionResponse;
import cn.cactusli.mcp.csdn.domain.service.CSDNArticleService;
import cn.cactusli.mcp.csdn.infrastructure.gateway.ICSDNService;
import cn.cactusli.mcp.csdn.infrastructure.gateway.dto.ArticleRequestDTO;
import cn.cactusli.mcp.csdn.infrastructure.gateway.dto.ArticleResponseDTO;
import cn.cactusli.mcp.csdn.types.utils.MarkdownConverter;
import com.alibaba.fastjson.JSON;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.Collections;

@RunWith(SpringRunner.class)
@SpringBootTest
class McpServerCsdnApplicationTests {

    private final Logger log = LoggerFactory.getLogger(McpServerCsdnApplicationTests.class);

    @Resource
    private ICSDNService csdnService;

    @Resource
    private CSDNArticleService csdnArticleService;

    @Test
    public void test_saveArticle() throws IOException {
        // 1. 构建请求对象
        ArticleRequestDTO request = new ArticleRequestDTO();
        request.setTitle("测试文章标题01");
        request.setMarkdowncontent("# 测试文章内容\n这是一篇测试文章");
        request.setContent("<h1>测试文章内容</h1><p>这是一篇测试文章</p>");
        request.setReadType("public");
        request.setLevel("0");
        request.setTags("测试,文章");
        request.setStatus(0);
        request.setCategories("后端");
        request.setType("original");
        request.setOriginal_link("");
        request.setAuthorized_status(true);
        request.setDescription("这是一篇测试文章的描述");
        request.setResource_url("");
        request.setNot_auto_saved("0");
        request.setSource("pc_mdeditor");
        request.setCover_images(Collections.emptyList());
        request.setCover_type(0);
        request.setIs_new(1);
        request.setVote_id(0);
        request.setResource_id("");
        request.setPubStatus("draft");
        request.setSync_git_code(0);

        // 2. 调用接口
        String cookie = "--csdn.api.cookie=fid=20_95694695194-1730769983778-635923; UN=qq_34968019; c_dl_um=-; _ga=GA1.1.2071491512.1733277741; FCNEC=%5B%5B%22AKsRol8AdP6bfWpBpz5I9ld762Zf6MuZei2K81lgeALVMQ88BG34Ycx8Ju789Ovtzk1kRKK34ii7CZPSJBnkzD5wUsNqxe7_5XBDgVxEJZnaKEanezrVWLxr4VLTijwZsZZKxJ2HKC6WXzvBnUwEDM4EUN6Je6DaKQ%3D%3D%22%5D%5D; _ga_7W1N0GEY1P=GS1.1.1736845961.2.1.1736846449.30.0.0; p_uid=U010000; csdn_newcert_qq_34968019=1; uuid_tt_dd=11_35382635629-1747631943915-480579; UserName=qq_34968019; UserInfo=2fbddb9c02a5489eb064d5d00bec42fc; UserToken=2fbddb9c02a5489eb064d5d00bec42fc; UserNick=%E6%9D%91%E9%9C%B8s1; AU=8BF; BT=1748585497988; c_dl_prid=1741675507865_920713; c_dl_rid=1749714376829_578099; c_dl_fref=https://bbs.csdn.net/topics/617032024; c_dl_fpage=/download/realwangpu/88102880; c_ab_test=1; _clck=74lgyo%7C2%7Cfx1%7C0%7C1772; __gads=ID=ee91fc3e9df730d3:T=1730948688:RT=1750740893:S=ALNI_MYGebfqnV5_b_FOlkKISjRbDV1e6g; __gpi=UID=00000a69633c82cf:T=1730948688:RT=1750740893:S=ALNI_MYh0_hu2ghTTaqqRhZk-YbpuuQU6A; __eoi=ID=984e6ab8fb3cf3da:T=1750740893:RT=1750740893:S=AA-AfjasPQd5zxiOpfdJZwT7Vveo; c_segment=3; dc_sid=62ab008dd5b775735e67b500686dbf9d; c_first_ref=default; dc_session_id=10_1750990609460.857301; c-sidebar-collapse=0; c_first_page=https%3A//mpbeta.csdn.net/; c_dsid=11_1750990775785.821100; creative_btn_mp=3; Hm_lvt_6bcd52f51e9b3dce32bec4a3997715ac=1750740892,1750990776; HMACCOUNT=83D5852CBDF508C4; Hm_lpvt_6bcd52f51e9b3dce32bec4a3997715ac=1750990793; creativeSetApiNew=%7B%22toolbarImg%22%3A%22https%3A//img-home.csdnimg.cn/images/20230921102607.png%22%2C%22publishSuccessImg%22%3A%22https%3A//img-home.csdnimg.cn/images/20240229024608.png%22%2C%22articleNum%22%3A1%2C%22type%22%3A2%2C%22oldUser%22%3Atrue%2C%22useSeven%22%3Afalse%2C%22oldFullVersion%22%3Atrue%2C%22userName%22%3A%22qq_34968019%22%7D; c_pref=https%3A//mpbeta.csdn.net/mp_blog/manage/article%3Fspm%3D1011.2480.3001.8124; c_ref=https%3A//mpbeta.csdn.net/; c_page_id=default; log_Id_pv=9; log_Id_view=197; dc_tos=syhudo; log_Id_click=9";
        Call<ArticleResponseDTO> call = csdnService.saveArticle(request, cookie);
        Response<ArticleResponseDTO> response = call.execute();

        System.out.println("\r\n测试结果" + JSON.toJSONString(response));

        // 3. 验证结果
        if (response.isSuccessful()) {
            ArticleResponseDTO articleResponseDTO = response.body();
            log.info("发布文章成功 {}", articleResponseDTO);
        }
    }

    @Test
    public void test_md2html() {
        System.out.println(MarkdownConverter.convertToHtml("**关于DDD是什么，在维基百科有一个明确的定义。\"Domain-driven design (DDD) is a major software design approach.\" 也就是说DDD是一种主要的软件设计方法。而软件设计涵盖了；范式、模型、框架、方法论。**\n" +
                "\n" +
                "- 范式（paradigm）指的是一种编程思想。\n" +
                "- 模型（model）指的是对现实世界或者问题的抽象描述。\n" +
                "- 框架（framework）指的是提供了一系列通用功能和结构的软件工具。\n" +
                "- 方法论（methodology）指的是一种系统的、有组织的解决问题的方法。\n" +
                "\n" +
                "所以，DDD不只是只有指导思想，伴随的DDD的还包括框架结构分层。但说到底，这些仍然是理论讨论。在没有一个DDD落地项目物参考下，其实大部分码农是没法完成DDD开发的。所以小傅哥今年花费了5个月假期/周末的时间，完成的《DDD简明开发教程》，帮助大家落地DDD编码。"));
    }

    @Test
    public void test_domain_saveArticle() throws IOException {
        String json = "{\"content\":\"<h2>场景：</h2>\\n<p>在一间高科技公司的会议室，一位经验丰富的面试官正准备提问，而对面坐着一位略显紧张但试图保持自信的应聘者小李。</p>\\n<p><strong>面试官</strong>：我们先来谈谈Python核心知识。第一个问题，Python中的垃圾回收机制是如何工作的？</p>\\n<p><strong>应聘者小李</strong>：嗯，这个简单！垃圾回收就像一个智能的清洁工，把没用的东西扫走，呃……然后就……清理干净？</p>\\n<p><strong>面试官</strong>：好的，第二个问题，请讲解一下Python中列表和元组的区别。</p>\\n<p><strong>应聘者小李</strong>：列表嘛，就像一个可以随便加菜的菜单，元组就像……呃，定好的套餐，改不了？</p>\\n<p><strong>面试官</strong>：第三个问题，能否说明Django和Flask的区别？</p>\\n<p><strong>应聘者小李</strong>：Django就像……一个全能的厨房，Flask是轻便的烧烤架，哈哈……</p>\\n<p><strong>面试官</strong>：好，今天的面试到此结束。请回去等候通知。</p>\\n<h2>答案解析：</h2>\\n<ol>\\n<li>\\n<p><strong>Python垃圾回收</strong>：Python使用引用计数和循环垃圾回收机制，自动管理内存，释放不再使用的对象。</p>\\n</li>\\n<li>\\n<p><strong>列表与元组区别</strong>：列表是可变的动态序列，支持增删改；元组是不可变的固定序列，通常用于数据保护。</p>\\n</li>\\n<li>\\n<p><strong>Django与Flask区别</strong>：Django是一个功能全面的Web框架，适合快速开发大型项目；Flask是一个轻量级框架，灵活性更高。</p>\\n</li>\\n</ol>\\n\",\"cover_images\":[],\"cover_type\":0,\"description\":\"在高科技公司的面试中，面试官与幽默的应聘者展开了一场妙趣横生的对话。面试官提出了Python垃圾回收、列表与元组、Django与Flask等问题，应聘者以风趣的方式回答。本文展现了轻松的面试氛围，并提供详细的技术答案解析，帮助读者深入理解相关知识。\",\"is_new\":1,\"level\":\"0\",\"markdowncontent\":\"## 场景：\\n\\n在一间高科技公司的会议室，一位经验丰富的面试官正准备提问，而对面坐着一位略显紧张但试图保持自信的应聘者小李。\\n\\n**面试官**：我们先来谈谈Python核心知识。第一个问题，Python中的垃圾回收机制是如何工作的？\\n\\n**应聘者小李**：嗯，这个简单！垃圾回收就像一个智能的清洁工，把没用的东西扫走，呃……然后就……清理干净？\\n\\n**面试官**：好的，第二个问题，请讲解一下Python中列表和元组的区别。\\n\\n**应聘者小李**：列表嘛，就像一个可以随便加菜的菜单，元组就像……呃，定好的套餐，改不了？\\n\\n**面试官**：第三个问题，能否说明Django和Flask的区别？\\n\\n**应聘者小李**：Django就像……一个全能的厨房，Flask是轻便的烧烤架，哈哈……\\n\\n**面试官**：好，今天的面试到此结束。请回去等候通知。\\n\\n## 答案解析：\\n\\n1. **Python垃圾回收**：Python使用引用计数和循环垃圾回收机制，自动管理内存，释放不再使用的对象。\\n\\n2. **列表与元组区别**：列表是可变的动态序列，支持增删改；元组是不可变的固定序列，通常用于数据保护。\\n\\n3. **Django与Flask区别**：Django是一个功能全面的Web框架，适合快速开发大型项目；Flask是一个轻量级框架，灵活性更高。\",\"not_auto_saved\":\"0\",\"pubStatus\":\"draft\",\"readType\":\"public\",\"resource_id\":\"\",\"resource_url\":\"\",\"source\":\"pc_mdeditor\",\"status\":0,\"sync_git_code\":0,\"tags\":\"Python,面试,科技公司,程序员,Django,Flask,垃圾回收,列表,元组\",\"title\":\"科技公司Python面试：专业面试官与幽默应聘者的对话\",\"vote_id\":0}";
        ArticleFunctionRequest request = JSON.parseObject(json, ArticleFunctionRequest.class);
        ArticleFunctionResponse response = csdnArticleService.saveArticle(request);
        log.info("测试结果:{}", JSON.toJSONString(response));
    }




}
