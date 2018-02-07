package com.tanyouping.ssm.mapper;

import com.tanyouping.ssm.model.Blog;
import com.tanyouping.ssm.param.BlogQueryParam;

import java.util.List;

public interface BlogMapper {

    List<Blog> selectBlog(BlogQueryParam blog);

    Integer saveBlog(Blog blog);

    Blog getBlog(Integer id);

    void removeBlog(Integer id);

    void updateBlog(Blog blog);
}
