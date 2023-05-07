package com.keep.pcc.controller;

import com.keep.pcc.model.requestDto.TagRequestDto;
import com.keep.pcc.model.responseDto.TagResponseDto;
import com.keep.pcc.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(value="/{bucketId}")
    public ResponseEntity<List<TagResponseDto>> getAllTagsForBucket(@PathVariable int bucketId){
        return ResponseEntity.ok(tagService.getAllTagsForBucket(bucketId));
    }

    @PostMapping(value="/create")
    public ResponseEntity<TagResponseDto> createTag(@RequestBody TagRequestDto tagRequestDto){
        return ResponseEntity.ok(tagService.createTag(tagRequestDto));
    }
}
