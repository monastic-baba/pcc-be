package com.keep.pcc.service;

import com.keep.pcc.model.dto.AppUserDto;
import com.keep.pcc.model.dto.BucketDto;
import com.keep.pcc.model.entities.Bucket;

import java.util.List;

public interface BucketService {
    BucketDto addBucket(Bucket bucket);

    List<BucketDto> getAllBuckets();

    BucketDto getBucket(Integer bucketId);
}
