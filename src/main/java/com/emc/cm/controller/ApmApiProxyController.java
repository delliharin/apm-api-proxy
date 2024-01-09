package com.emc.cm.controller;

import com.emc.cm.service.ApmApiProxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApmApiProxyController {
    @Autowired
    private ApmApiProxyService apmApiProxyService;

    @GetMapping("/apm/{id}")
    public ResponseEntity<String> getApmInfo(@PathVariable String id) {
        String info = apmApiProxyService.findApmById(id);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }
}
