package com.keep.pcc.service;

import com.keep.pcc.model.requestDto.BucketRequestDto;
import com.keep.pcc.model.entities.Bucket;
import com.keep.pcc.model.responseDto.BucketResponseDto;

import java.util.List;

public interface BucketService {
    BucketResponseDto addBucket(Bucket bucket);

    List<BucketResponseDto> getAllBuckets();

    BucketResponseDto getBucket(Integer bucketId);
}
