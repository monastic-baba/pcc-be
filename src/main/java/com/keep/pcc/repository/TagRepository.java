package com.keep.pcc.repository;

import com.keep.pcc.model.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    List<Tag> findAllByBucketId(int bucketId);
}
