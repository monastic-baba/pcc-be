package com.keep.pcc.mapper;

import com.keep.pcc.model.entities.Tag;
import com.keep.pcc.model.requestDto.TagRequestDto;
import com.keep.pcc.model.responseDto.TagResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagRequestDtoToTag(TagRequestDto tagRequestDto);
    TagResponseDto tagToTagResponseDto(Tag tag);
}