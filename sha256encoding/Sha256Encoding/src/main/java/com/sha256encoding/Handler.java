package com.sha256encoding;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Handler implements RequestHandler<Map<String, String>, String> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Map<String, String> strValidators = new HashMap<>();

    @Override
    public String handleRequest(Map<String, String> event, Context context) {
        strValidators.put(".{8,}", "String doesn't have 8 characters");
        strValidators.put(".*\\d.*", "String doesn't have at least 1 number");
        strValidators.put(".*[!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*",
            "String doesn't have at least 1 special character");

        LambdaLogger logger = context.getLogger();
        String str = event.get("body");
        for (String s : strValidators.keySet()) {
            if (!validateString(str, s)) {
                System.out.println(strValidators.get(s));
                return "400";
            }
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(
                str.getBytes(StandardCharsets.UTF_8));
            return new String("200 OK");
        } catch (NoSuchAlgorithmException ex) {
            return new String("400");
        }
    }

    public boolean validateString(String str, String regex) {
        System.out.println("str:" + str + ", regex:" + regex);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

}
