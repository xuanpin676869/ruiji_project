package com.xuanpin.reggie.utils;
import com.aliyun.tea.*;
public class SampleUtils {
    public static void sendMessage(String param,String phoneNumbers) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                .setAccessKeyId("LTAI5tSo8LAsftNanAUgJ52Y")
                .setAccessKeySecret("4pIGoHxflxsZP0GT5sbyBxDiNHJIQa");
        config.endpoint = "dysmsapi.aliyuncs.com";
        com.aliyun.dysmsapi20170525.Client client = new com.aliyun.dysmsapi20170525.Client(config);
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setSignName("瑞吉外卖")
                .setTemplateCode("SMS_462620380")
                .setTemplateParam("{\"code\":\"" + param + "\"}")
                .setPhoneNumbers(phoneNumbers);
        com.aliyun.teautil.models.RuntimeOptions runtime = new com.aliyun.teautil.models.RuntimeOptions();
        try {
            // 复制代码运行请自行打印 API 的返回值
            client.sendSmsWithOptions(sendSmsRequest, runtime);
        } catch (TeaException error) {
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            com.aliyun.teautil.Common.assertAsString(error.message);
        }
    }
}
