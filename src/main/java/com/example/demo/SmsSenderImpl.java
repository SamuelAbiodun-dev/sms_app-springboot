package com.example.demo;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("twilio")
public class SmsSenderImpl implements SmsSender{
    private static final Logger LOGGER = LoggerFactory.getLogger(SmsSenderImpl.class);
    private final SmsApplication smsApplication;
    @Autowired
    public SmsSenderImpl(SmsApplication smsApplication) {
        this.smsApplication = smsApplication;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
    if(isPhoneNUmberValid(smsRequest.getPhoneNUmber())) {
    PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNUmber());
    PhoneNumber from = new PhoneNumber(smsApplication.getTrialNumber());
    String message = smsRequest.getMessage();
    MessageCreator creator = Message.creator(to, from, message);
    creator.create();
    LOGGER.info("Send  sms {}" + smsRequest);
}
else{
    throw new IllegalArgumentException("Phone number [" + smsRequest.getPhoneNUmber() + "] " +
            "is not a valid number");
}
    }

    private boolean isPhoneNUmberValid(String phoneNUmber) {
        return true;
    }
}
