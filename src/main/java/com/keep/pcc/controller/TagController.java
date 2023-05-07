package com.keep.pcc.controller;

import com.keep.pcc.service.TagService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {

    TagService tagService;
}
