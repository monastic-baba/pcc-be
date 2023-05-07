package com.keep.pcc.service;

import com.keep.pcc.model.requestDto.TagRequestDto;
import com.keep.pcc.model.responseDto.TagResponseDto;

import java.util.List;

public interface TagService {
    TagResponseDto createTag(TagRequestDto tagRequestDto);

    List<TagResponseDto> getAllTagsForBucket(int bucketId);
}
