package com.keep.pcc.mapper;


import com.keep.pcc.model.requestDto.BucketRequestDto;
import com.keep.pcc.model.entities.Bucket;
import com.keep.pcc.model.responseDto.BucketResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BucketMapper {
    Bucket bucketRequestDtoToBucket(BucketRequestDto bucketRequestDto);
    BucketResponseDto bucketToBucketResponseDto(Bucket bucket);
}
