package app.service;

import app.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class UserServiceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private AppConfig appConfig;

    @Autowired
    public UserServiceImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @PostConstruct
    public void init(){
        System.out.println("APPCONFIG = " + appConfig.getAppid());
    }
}
