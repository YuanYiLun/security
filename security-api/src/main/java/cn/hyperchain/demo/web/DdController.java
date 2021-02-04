package cn.hyperchain.demo.web;

import cn.hyperchain.demo.util.HttpClientUtils;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiUserGetbyunionidRequest;
import com.dingtalk.api.request.OapiV2UserGetRequest;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiUserGetbyunionidResponse;
import com.dingtalk.api.response.OapiV2UserGetResponse;
import com.taobao.api.ApiException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * File: DdController.java
 * Description:钉钉扫码登录
 * Company:
 *
 * @Author: yyz
 * Datetime: 2021-02-01
 */
@Controller
@RequestMapping("/dd")
public class DdController {

    public final String appId = "dingoamczwzjqsxr8eiqmd";
    public final String appSecurity = "ZEtnCTz5aZH3icfIz84HgQu3P3bOgX3vln5utw8oWOh-p7QVr-A-fpgzodFgtijs";
    public final String redirectUri = "http://4e28d17a.cpolar.io/dd/ddUrl";

    public String BASEURL = "https://oapi.dingtalk.com/connect/qrconnect?appid=%s&response_type=code&scope=snsapi_login&state=STATE&redirect_uri=%s";

    public String userInfoUrl = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?accessKey=%s&timestamp=%s&signature=%s";

    @GetMapping("/getUrl")
    @ResponseBody
    public String getDdUrl() {
        String url = String.format(BASEURL, appId, redirectUri);
        return url;
    }

    @GetMapping("ddUrl")
    @ResponseBody
    public Object callBackUrl(String code) throws ApiException {
        /*DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
        OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
        req.setTmpAuthCode(code);
        OapiSnsGetuserinfoBycodeResponse execute = client.execute(req, appId, appSecurity);

        String unionid = execute.getUserInfo().getUnionid();

        // 根据unionid获取userid
        DingTalkClient clientDingTalkClient = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/user/getbyunionid");
        OapiUserGetbyunionidRequest reqGetbyunionidRequest = new OapiUserGetbyunionidRequest();
        reqGetbyunionidRequest.setUnionid(unionid);
        OapiUserGetbyunionidResponse oapiUserGetbyunionidResponse = clientDingTalkClient.execute(reqGetbyunionidRequest,access_token);

        // 根据userId获取用户信息
        String userid = oapiUserGetbyunionidResponse.getResult().getUserid();
        DingTalkClient clientDingTalkClient2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/get");
        OapiV2UserGetRequest reqGetRequest = new OapiV2UserGetRequest();
        reqGetRequest.setUserid(userid);
        reqGetRequest.setLanguage("zh_CN");
        String access_token= AccessTokenUtil.getToken();
        OapiV2UserGetResponse rspGetResponse = clientDingTalkClient2.execute(reqGetRequest, access_token);
        System.out.println(rspGetResponse.getBody());
        Map<String, Object> map = new HashMap<String,Object>();
        map.put("userInfo", rspGetResponse.getBody());
        return ServiceResult.success(map);*/


        return null;
    }

    private String getString(String code) {
        long timestamp = System.currentTimeMillis();
        String sign = sign(timestamp, appSecurity);
        sign = urlEncode(sign);
        String url = String.format(userInfoUrl, appId, timestamp, sign);
        HashMap<String, String> map = new HashMap<>();
        map.put("tmp_auth_code", code);
        String result = HttpClientUtils.getInstance().sendHttpPost(url, map);
        System.out.println(result);
        return result;
    }

    private String sign(long timestamp, String suiteTicket) {
        String stringToSign = timestamp + "\n" + suiteTicket;
        Mac mac = null;
        try {
            mac = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            mac.init(new SecretKeySpec(appId.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            return new String(Base64.encodeBase64(signData));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    // encoding参数使用utf-8
    public static String urlEncode(String value) {
        String encoding = "UTF-8";
        if (value == null) {
            return "";
        }
        try {
            String encoded = URLEncoder.encode(value, encoding);
            return encoded.replace("+", "%20").replace("*", "%2A")
                    .replace("~", "%7E").replace("/", "%2F");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("FailedToEncodeUri", e);
        }
    }

    public static void main(String[] args) {

        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
        OapiSnsGetuserinfoBycodeRequest req = new OapiSnsGetuserinfoBycodeRequest();
        //req.TmpAuthCode = code;
        // response = client.Execute(req, qrAppId, qrAppSecret);
    }

}
