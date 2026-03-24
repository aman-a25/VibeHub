package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.response.ServerResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServiceController {

    @GetMapping
    public ResponseEntity<ServerResponseDto> serverStatus() {
        return new ResponseEntity<>(new ServerResponseDto(), HttpStatusCode.valueOf(200));
    }

}
