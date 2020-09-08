package com.alten.mihaibucur.cronjob;

import com.alten.mihaibucur.service.interfaces.UpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UpdateDataCronjob {

    @Autowired
    UpdateService updateService;

    @Scheduled(cron = "0 0 * * *")
    public void reportCurrentTime() throws URISyntaxException {
        updateService.update();
    }
}
