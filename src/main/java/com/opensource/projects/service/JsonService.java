package com.opensource.projects.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensource.projects.modal.Error;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JsonService {

    Logger logger = LoggerFactory.getLogger(JsonService.class);
    public String jsonError(Error error){
        Map<String,String> map = new HashMap<>();
        map.put("error",error.name());
        String json = "";
        try{
            json = new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e){
            logger.info(e.getMessage());
        }
        return json;
    }

    public String jsonError(Error error, Map additioanlValues){
        Map<String,String> map = new HashMap<>();
        map.put("error",error.name());
        map.putAll(additioanlValues);
        String json = "";
        try{
            json = new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e){
            logger.info(e.getMessage());
        }
        return json;
    }

    public String jsonPage(Page page){
        Map<String,Object> map = new HashMap<>();

        map.put("total_pages",page.getTotalPages());
        map.put("pageSize",page.getSize());
        map.put("content",page.getContent());
        String json = "";
        try{
            json = new ObjectMapper().writeValueAsString(map);
        } catch (JsonProcessingException e){
            logger.info(e.getMessage());
        }
        return json;
    }
}
