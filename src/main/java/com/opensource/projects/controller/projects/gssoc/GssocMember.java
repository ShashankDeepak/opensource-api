package com.opensource.projects.controller.projects.gssoc;

import com.opensource.projects.exceptions.ProjectNotFoundException;
import com.opensource.projects.modal.Error;
import com.opensource.projects.modal.projects.GssocModal;
import com.opensource.projects.modal.projects.Project;
import com.opensource.projects.service.JsonService;
import com.opensource.projects.service.projects.GssocServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.opensource.projects.modal.Error.INVALID_PARAMETERS;
import static com.opensource.projects.modal.Error.PROJECT_NOT_FOUND;

@RestController
@RequestMapping("/gssoc")
public class GssocMember {
    @Autowired
    JsonService jsonService;
    @Autowired
    GssocServiceImpl gssocService;
    @GetMapping("/?id={id}")
    public ResponseEntity getModalById(@PathVariable("id") String id){
        GssocModal modal = new GssocModal();
        try{
            modal = gssocService.getModalById(id);
        } catch (ProjectNotFoundException e){
            ResponseEntity.status(404).contentType(MediaType.APPLICATION_JSON).body(jsonService.jsonError(PROJECT_NOT_FOUND));
        }
        return ResponseEntity.ok(modal);
    }
    @GetMapping("/year={year}")
    public ResponseEntity getModalsByYear(@PathVariable("year") Integer year){
        return ResponseEntity.ok(gssocService.getModalsByYear(year));
    }

    //Example response -> http://localhost:8080/gssoc/page?pageNumber=2&pageSize=20
    //Page number starts from 0.
    @GetMapping("/page")
    public ResponseEntity getModalsByPage(@RequestParam Map<String,String> map, HttpServletRequest request){
        if(!(map.containsKey("pageNumber") && map.containsKey("pageSize"))){
            Map<String,String> payload = new HashMap<>();
            payload.put("expecting","/page?pageNumber=[int]&pageSize=[int]");
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
        return ResponseEntity
                .status(200)
                .contentType(MediaType.APPLICATION_JSON)
                .body(jsonService.jsonPage(gssocService
                        .getModalsByPage(Integer.parseInt(map.get("pageNumber")),Integer.parseInt(map.get("pageSize")))));
    }

}
