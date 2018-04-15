package com.swe.project.controller;


import com.swe.project.entity.Action;
import com.swe.project.service.ShowActionsService;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping( value = "/Action")
public abstract class ActionController {

    ShowActionsService showActionsService;

    @GetMapping(value = "/showActions/{storeId}")
    ResponseEntity<?> showAll(@PathVariable("storeId") Integer storeId){
        Iterable<Action> actions = showActionsService.showActions(storeId);
        if(actions.equals(null)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    ResponseEntity<?> Add(@RequestParam Action action){
        return ResponseEntity.ok().build();
    }

    ResponseEntity<?> remove(@RequestParam Action action){
        return ResponseEntity.ok().build();
    }

}
