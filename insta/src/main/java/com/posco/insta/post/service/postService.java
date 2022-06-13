package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.user.model.UserDto;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface postService {

    List<PostDto> findPost();

    List<SelectPostJoinUserDto> getPostByUserId(PostDto postDto);
    int deleteMypost(PostDto postDto);
    List<SelectPostJoinUserDto> findPostsByNotUserId(PostDto postDto);

    int updatePostById(PostDto postDto);

    int insertPost(PostDto postDto);

    SelectPostJoinUserDto getPostsById(PostDto postDto);

    List<SelectPostJoinUserDto> findPostsLikeKey(String key);

    List<SelectPostJoinUserDto> getPostsByMyFollowing(PostDto postDto);
}
