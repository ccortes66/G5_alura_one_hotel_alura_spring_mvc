package com.alura.hotelalura.springboottres.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface HCatchaValidation 
{
   Boolean validate(String hcaptaResponse) throws IOException;    
}

@Component
class ValidationHCaptacha implements HCatchaValidation
{  
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Boolean validate(String hcaptaResponse) throws IOException
    {
        
        Map<String,String> params = new HashMap<>();
        params.put("response", hcaptaResponse);
        params.put("secret", System.getenv("secret"));

        URL url = new URL("https://hcaptcha.com/siteverify");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");

        String postData = params.entrySet()
                                .stream()
                                .map(param->param.getKey()+"="+param.getValue())
                                .collect(Collectors.joining("&"));
        
        connection.getOutputStream().write(postData.getBytes());
        JsonNode node = mapper.readTree(connection.getInputStream());

        return node.get("success").asBoolean();
    }


}