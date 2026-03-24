package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.request.PageRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PageResponseDto;
import com.myorg.vibehub.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping()
    public ResponseEntity<PageResponseDto> addPage(@RequestBody PageRequestDto pageRequestDto) {

        return new ResponseEntity<>(pageService.addPage(pageRequestDto), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponseDto> getPage(@PathVariable Long id) {
        return new ResponseEntity<>(pageService.getPageById(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public ResponseEntity<List<PageResponseDto>> getAllPage() {
        return new ResponseEntity<>(pageService.getAllPage(), HttpStatusCode.valueOf(200));
    }

    @PutMapping()
    public ResponseEntity<PageResponseDto> updatePage(@RequestBody PageRequestDto pageRequestDto ,@RequestParam Long id) {

        return new ResponseEntity<>(pageService.updatePage(id , pageRequestDto) ,  HttpStatusCode.valueOf(200));
    }

    @DeleteMapping()
    public ResponseEntity<GenericResponseDto> deletePage(@RequestParam Long id) {

        return new ResponseEntity<>(pageService.removePageById(id), HttpStatusCode.valueOf(200));
    }


}
