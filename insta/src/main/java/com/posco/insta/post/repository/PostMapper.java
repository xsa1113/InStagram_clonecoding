package com.posco.insta.post.repository;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> getPost();
    List<SelectPostJoinUserDto> findPostsByUserId(PostDto postDto);
    int deletePostByUserIdAndId(PostDto postDto);
    List<SelectPostJoinUserDto> findPostsByNotUserId(PostDto postDto);
    int updatePostById(PostDto postDto);
    int insertPost(PostDto postDto);
    SelectPostJoinUserDto getPostsById(PostDto postDto);

    List<SelectPostJoinUserDto> getPostByKey(String key);

    List<SelectPostJoinUserDto> getPostsByMyFollowing(PostDto postDto);
}
