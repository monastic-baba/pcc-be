package com.keep.pcc.model.dto;

import com.keep.pcc.model.entities.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BucketDto {
    private int id;
    private String name;
    private Set<Tag> tags;
}
