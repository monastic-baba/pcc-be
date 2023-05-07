package com.keep.pcc.model.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppUserRequestDto {

    private int id;
    private String name;
    private String username;
    private String bio;
    private String email;
    private String password;
    private String[] postIds;
    private String[] bucketIds;
    private String[] tagIds;
}
