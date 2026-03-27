package com.myorg.vibehub.controller;

import com.myorg.vibehub.dto.request.PageRequestDto;
import com.myorg.vibehub.dto.response.GenericResponseDto;
import com.myorg.vibehub.dto.response.PageResponseDto;
import com.myorg.vibehub.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        PageResponseDto pageResponseDto = pageService.addPage(pageRequestDto);

        if (pageResponseDto != null) {
            return new ResponseEntity<>(pageResponseDto, HttpStatusCode.valueOf(201));
        }else  {
            return new ResponseEntity<>(HttpStatus.valueOf(400));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponseDto> getPage(@PathVariable Long id) {
        PageResponseDto response = pageService.getPageById(id);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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

        GenericResponseDto response = pageService.removePageById(id);

        if (response.getSuccess()) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


}
