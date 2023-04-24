package com.keep.pcc.service;

import com.keep.pcc.mapper.AppUserMapper;
import com.keep.pcc.mapper.BucketMapper;
import com.keep.pcc.model.dto.BucketDto;
import com.keep.pcc.model.entities.AppUser;
import com.keep.pcc.model.entities.Bucket;
import com.keep.pcc.repository.AppUserRepository;
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
    public BucketDto addBucket(Bucket bucket) {
        Bucket savedBucket = bucketRepository.save(bucket);
        return bucketMapper.bucketToBucketDto(savedBucket);
    }

    @Override
    public List<BucketDto> getAllBuckets() {
        return bucketRepository.findAll()
                .stream()
                .map( user -> bucketMapper.bucketToBucketDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public BucketDto getBucket(Integer bucketId) {
        Bucket queriedBucket = bucketRepository.findById(bucketId).isPresent()
                ? bucketRepository.findById(bucketId).get() : null;
        return bucketMapper.bucketToBucketDto(queriedBucket);
    }
}
