package com.endava.third.task;

import com.endava.third.model.Vote;
import com.endava.third.repository.VoteRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

@Component
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Votes {

    private final VoteRepository voteRepository;

    @Scheduled(fixedRate = 1000 * 60) // one minute
    public void reportCurrentTime() {
//        final String streamAPI = "https://peaceful-tor-90220.herokuapp.com/votes";
        final String streamAPI = "https://peaceful-tor-90220.herokuapp.com/votes?since=23/08/2019%2000:14:04%20441836&until=23/08/2019%2000:45:19%20470852";

        try {
            URL url = new URL(streamAPI);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            Scanner scanner = new Scanner(in);
            StringBuilder abc = new StringBuilder();
            while (scanner.hasNext()) {
                abc.append(scanner.nextLine());
            }
            // need parse
            ObjectMapper objectMapper = new ObjectMapper();
            String answer = abc.toString().replace("}{", "}¡{");

            String[] votes = answer.split("¡");
            for (String vote: votes) {
                Vote voteMapped = objectMapper.readValue(vote, Vote.class);
                voteRepository.save(voteMapped);
            }

        }  catch (Exception e) {
            e.printStackTrace();
        }
    }
}