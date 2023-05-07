package com.keep.pcc.service;

import com.keep.pcc.exception.NotFoundException;
import com.keep.pcc.mapper.BucketMapper;
import com.keep.pcc.model.requestDto.BucketRequestDto;
import com.keep.pcc.model.entities.Bucket;
import com.keep.pcc.model.responseDto.BucketResponseDto;
import com.keep.pcc.repository.BucketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BucketServiceImpl implements BucketService {

    BucketRepository bucketRepository;
    BucketMapper bucketMapper;

    @Autowired
    public BucketServiceImpl(BucketRepository bucketRepository, BucketMapper bucketMapper) {
        this.bucketRepository = bucketRepository;
        this.bucketMapper = bucketMapper;
    }

    @Override
    public BucketResponseDto addBucket(Bucket bucket) {
        Bucket savedBucket = bucketRepository.save(bucket);
        return bucketMapper.bucketToBucketResponseDto(savedBucket);
    }

    @Override
    public List<BucketResponseDto> getAllBuckets() {
        return bucketRepository.findAll()
                .stream()
                .map( user -> bucketMapper.bucketToBucketResponseDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public BucketResponseDto getBucket(Integer bucketId) {
        Bucket queriedBucket = bucketRepository.findById(bucketId).isPresent()
                ? bucketRepository.findById(bucketId).get() : null;
        return bucketMapper.bucketToBucketResponseDto(queriedBucket);
    }
}
