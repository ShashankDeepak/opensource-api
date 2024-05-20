package com.opensource.projects.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JsonService {

    Logger logger = LoggerFactory.getLogger(JsonService.class);
    public String jsonError(String error){
        Map<String,String> map = new HashMap<>();
        map.put("error",error);
        String json = "";
        try{
            json = new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e){
            logger.info(e.getMessage());
        }
        return json;
    }
}
