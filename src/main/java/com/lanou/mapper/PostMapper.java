package com.lanou.mapper;

import com.lanou.domain.Post;

/**
 * Created by dllo on 17/11/9.
 */
public interface PostMapper {
    Post findByDeptID(String postID);
}
