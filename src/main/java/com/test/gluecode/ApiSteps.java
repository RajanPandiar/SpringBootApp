package com.test.gluecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.context.TestContext;

@Component
public class ApiSteps {

    private static String API_ENDPOINT;

    public void intialize(){
        API_ENDPOINT = "http://localhost:8080";
    }

    public void lookForBanks() {
        String test = makeAGetCall(API_ENDPOINT+"/banks");
        TestContext.getContext().setResponse(test);

    }
    public void lookForABank(String bankName) {
        makeAGetCall(API_ENDPOINT+"/banks/"+bankName);
    }

    public String makeAGetCall(String endPoint) {
        String response = null;
        try {

            URL url = new URL(endPoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            response = convertInputStreamToString(con.getInputStream());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return response;

    }

    public String convertInputStreamToString(InputStream responseInpStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(responseInpStream));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        ObjectMapper mapper = new ObjectMapper();
        Object jsonObject = mapper.readValue(content.toString(),Object.class);
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
        return json;

    }



}
