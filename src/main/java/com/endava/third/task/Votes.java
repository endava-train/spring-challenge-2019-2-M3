package com.endava.third.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@Component
@Slf4j
public class Votes {

    @Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        final RestTemplate restTemplate = new RestTemplate();
        final String streamAPI = "https://peaceful-tor-90220.herokuapp.com/votes";

        try {
            URL url = new URL(streamAPI);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            Scanner scanner = new Scanner(in);
            StringBuilder abc = new StringBuilder();
            while (scanner.hasNext()) {
                String a = scanner.nextLine();
                log.info(a);
                abc.append(a);
            }
            log.info("-------------");
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}