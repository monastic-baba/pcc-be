package com.keep.pcc.mapper;


import com.keep.pcc.model.dto.BucketDto;
import com.keep.pcc.model.entities.Bucket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BucketMapper {
    Bucket bucketDtoToBucket(BucketDto bucketDto);
    BucketDto bucketToBucketDto(Bucket bucket);
}
