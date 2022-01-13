package com.cn.why.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Slf4j
public class Date {
    public static String getDate() {
        String formedTime = "";
        try {
            NTPUDPClient timeClient = new NTPUDPClient();
            String timeServerUrl = "time1.aliyun.com";
            InetAddress timeServerAddress = InetAddress.getByName(timeServerUrl);
            TimeInfo timeInfo = timeClient.getTime(timeServerAddress);
            TimeStamp timeStamp = timeInfo.getMessage().getTransmitTimeStamp();
            java.util.Date date = timeStamp.getDate();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            formedTime = dateFormat.format(date);
            log.info(formedTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formedTime;
    }
}
