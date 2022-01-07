import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.why.common.HttpUtil;
import com.cn.why.common.PictureUtil;
import com.cn.why.entity.ServerChan;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HttpClientTest {

    @Test
    public void testGet() {
        //百度天气的api
        //String url1 = "http://api.map.baidu.com/telematics/v3/weather?location=%E5%8C%97%E4%BA%AC&output=json&ak=W69oaDTCfuGwzNwmtVvgWfGH";
        String url1 = "http://localhost:8080/wechat/test/view2/你好世界";
        String result1 = HttpUtil.sendGet(url1);
        System.out.println(result1);
        //输出{"param":"你好世界"}
    }

    @Test
    public void testPost() throws UnsupportedEncodingException {
        String url = "https://sctapi.ftqq.com/SCT58654TEI9PKAb5Fss8d6d9fk5M7yVP.send";
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "你好世界");
        map.put("desp", "哈哈");
        String result = HttpUtil.sendPost(url, map);
        System.out.println(result);
        //输出结果{"param1":"你好世界","param2":"哈哈"}

    }

    @Test
    public void testPost1() throws UnsupportedEncodingException {
        String url = "https://sctapi.ftqq.com/SCT58654TEI9PKAb5Fss8d6d9fk5M7yVP.send";
        String strs = "123456789";
        String code = PictureUtil.generateVerifyCode(5, strs);
        Map<String, String> map = new HashMap<String, String>();
        String msg = "你的验证码是：" + code + "，有效期十分钟，过期请重新获取";
        System.out.println(msg);
        map.put("title", "中国铁塔");
        map.put("desp", msg);
        String result = HttpUtil.sendPost(url, map);
        System.out.println(result);
        //将数据封装成JSON
        JSONObject data = JSON.parseObject(result).getJSONObject("data");
        //从JSON中获取数据
        Integer pushid = data.getInteger("pushid");
        Object readkey = data.get("readkey");
        //封装到实体中
        ServerChan serverChan = new ServerChan();
        serverChan.setPushid(String.valueOf(pushid));
        serverChan.setReadkey(String.valueOf(readkey));
        serverChan.setCode(code);
        System.out.println(serverChan);

    }

}
