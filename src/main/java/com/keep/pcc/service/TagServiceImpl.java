package com.keep.pcc.service;

import com.keep.pcc.mapper.TagMapper;
import com.keep.pcc.model.entities.Tag;
import com.keep.pcc.model.requestDto.TagRequestDto;
import com.keep.pcc.model.responseDto.TagResponseDto;
import com.keep.pcc.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    TagRepository tagRepository;
    TagMapper tagMapper;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository, TagMapper tagMapper) {
        this.tagRepository = tagRepository;
        this.tagMapper = tagMapper;
    }

    @Override
    public TagResponseDto createTag(TagRequestDto tagRequestDto) {
        Tag tagToCreate = tagMapper.tagRequestDtoToTag(tagRequestDto);
        return tagMapper.tagToTagResponseDto(tagRepository.save(tagToCreate));
    }

    @Override
    public List<TagResponseDto> getAllTagsForBucket(int bucketId) {
        return tagRepository.findAllByBucketId(bucketId).stream().map(tag ->
                tagMapper.tagToTagResponseDto(tag)).collect(Collectors.toList());
    }
}
