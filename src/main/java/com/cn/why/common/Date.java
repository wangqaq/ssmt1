package com.cn.why.common;

import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;
import org.apache.commons.net.ntp.TimeStamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Date {
    private static final Logger logger = LoggerFactory.getLogger(Date.class);
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
            formedTime= dateFormat.format(date);
            logger.info(formedTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return formedTime;
    }
}
