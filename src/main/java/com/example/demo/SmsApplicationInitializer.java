package com.example.demo;

import com.twilio.Twilio;
import com.twilio.twiml.voice.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsApplicationInitializer {
    private final static Logger LOGGER = LoggerFactory.getLogger(SmsApplicationInitializer.class);
    private final SmsApplication smsApplication;

    @Autowired
    public SmsApplicationInitializer(SmsApplication smsApplication){
        this.smsApplication = smsApplication;
        Twilio.init(smsApplication.getAccountSid(), smsApplication.getAuthToken());
        LOGGER.info("Twilio initialized... with account sid {} ", smsApplication.getAccountSid());
    }
}
