package com.keep.pcc.controller;

import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.dto.BucketDto;
import com.keep.pcc.model.entities.Bucket;
import com.keep.pcc.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/bucket")
public class BucketController {

    BucketService bucketService;

    @Autowired
    public BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @GetMapping(value = "/health")
    public String healthCheck() {
        return "healthy!";
    }

    @Transactional
    @PostMapping(value = "/create")
    public ResponseEntity<BucketDto> addUser(@Validated @RequestBody Bucket bucket) {
        BucketDto newBucket = this.bucketService.addBucket(bucket);
        return ResponseEntity.ok(newBucket);
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<BucketDto>> appUsers() {
        return ResponseEntity.ok(this.bucketService.getAllBuckets());
    }

}
