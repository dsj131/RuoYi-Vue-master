package com.ruoyi.web.controller.weather;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.http.HttpUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
public class WeatherController {
    // 天气情况查询接口地址
    public static String API_URL = "https://restapi.amap.com/v3/weather/weatherInfo";
    // 接口请求Key
    public static String API_KEY = "91a550355c6c9289ea780b5118edef6d";
    @GetMapping("/getWeatherByLocalIP")
    public AjaxResult getWeather() throws UnsupportedEncodingException {
        AjaxResult result = AjaxResult.success();
        String localCityName = GetLocationAndIP.getLocalCityName();
        //调用天气API
        String encodeCity = URLEncoder.encode(localCityName, "UTF-8");
        System.out.println(encodeCity);
//        String url = "http://apis.juhe.cn/simpleWeather/query?city=" + encodeCity + "&key=81fe33a6077267b2e4ae2967af47eeb7";
        String url = "https://restapi.amap.com/v3/weather/weatherInfo?city=" + encodeCity + "&key=91a550355c6c9289ea780b5118edef6d" +"&extensions=all";
        String weatherInfo = HttpUtils.sendGet(url);
        result.put("msg", weatherInfo);
        return result;
    }

}