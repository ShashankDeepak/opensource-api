package com.opensource.projects.controller.projects.gsod;

import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.projects.GssocModal;
import com.opensource.projects.modal.projects.gsod.GsodModalNew;
import com.opensource.projects.modal.projects.gsod.GsodModalOld;
import com.opensource.projects.service.JsonService;
import com.opensource.projects.service.projects.GsodServiceNewImpl;
import com.opensource.projects.service.projects.GsodServiceOldImpl;
import com.opensource.projects.service.projects.GssocServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.opensource.projects.modal.Error.INVALID_PARAMETERS;
import static com.opensource.projects.modal.Error.PROJECT_NOT_FOUND;

@RestController
@RequestMapping("/gsod")
public class GsodController {
    @Autowired
    JsonService jsonService;
    @Autowired
    GsodServiceOldImpl gsodServiceOld;

    @Autowired
    GsodServiceNewImpl gsodServiceNew;
    @GetMapping("/year={year}/id={id}")
    public ResponseEntity getModalById(@PathVariable("year") int year , @PathVariable("id") String id){

        try{
            if(year >= 2021){
                GsodModalNew gsodModalNew = gsodServiceNew.getModalById(id);
                return ResponseEntity.ok(gsodModalNew);
            }
            else{
                GsodModalOld gsodModalOld = gsodServiceOld.getModalById(id);
                return ResponseEntity.ok(gsodModalOld);
            }
        } catch (ProjectNotFoundException e){
            return ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(jsonService.jsonError(PROJECT_NOT_FOUND));
        }

    }
    @GetMapping("/year={year}")
    public ResponseEntity getModalsByYear(@PathVariable("year") Integer year){
        if(year >= 2021){
            return  ResponseEntity.ok(gsodServiceNew.getModalsByYear(year));
        }
        else {
            return ResponseEntity.ok(gsodServiceOld.getModalsByYear(year));
        }
    }

    //Example response -> http://localhost:8080/gssoc/page/year=2021?pageNumber=2&pageSize=20
    //Page number starts from 0.
    @GetMapping("/page/year={year}")
    public ResponseEntity getModalsByPage(@PathVariable("year") int year, @RequestParam Map<String,String> map, HttpServletRequest request){
        if(!(map.containsKey("pageNumber") && map.containsKey("pageSize"))){
            Map<String,String> payload = new HashMap<>();
            payload.put("expecting","/page/year="+year+"?pageNumber=[int]&pageSize=[int]");
            String received = request.getServletPath() + "?";
            String[] list = map.keySet().toArray(new String[0]);
            for(int i = 0; i < list.length; i++){
                received += list[i] + "=" + map.get(list[i]);
                if(i != list.length - 1){
                    received += "&";
                }
            }
            payload.put("received",received);
            return ResponseEntity.status(400)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(jsonService.jsonError(INVALID_PARAMETERS,payload));
        }
        try{
            int pageNumber = Integer.parseInt(map.get("pageNumber"));
            int pageSize = Integer.parseInt(map.get("pageSize"));
            if(year >= 2021)
            return ResponseEntity
                    .status(200)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(jsonService.jsonPage(gsodServiceNew
                            .getModalsByPage(pageNumber,pageSize)));
            else {
                return ResponseEntity
                        .status(200)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(jsonService.jsonPage(gsodServiceOld
                                .getModalsByPage(pageNumber,pageSize)));
            }
        } catch (NumberFormatException e){
            Map<String,String> payload = new HashMap<>();
            payload.put("expecting","/page/year="+year+"?pageNumber=[int]&pageSize=[int]");
            String received = request.getServletPath() + "?";
            String[] list = map.keySet().toArray(new String[0]);
            for(int i = 0; i < list.length; i++){
                received += list[i] + "=" + map.get(list[i]);
                if(i != list.length - 1){
                    received += "&";
                }
            }
            payload.put("received",received);
            return ResponseEntity.status(400)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(jsonService.jsonError(INVALID_PARAMETERS,payload));
        }
    }
}
