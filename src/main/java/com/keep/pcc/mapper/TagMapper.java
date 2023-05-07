package com.keep.pcc.mapper;

import com.keep.pcc.model.entities.Tag;
import com.keep.pcc.model.requestDto.TagRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagDtoToTag(TagRequestDto tagRequestDto);
    TagRequestDto tagToTagDto(Tag tag);
}