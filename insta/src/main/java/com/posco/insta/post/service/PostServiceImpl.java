package com.posco.insta.post.service;

import com.posco.insta.post.model.PostDto;
import com.posco.insta.post.model.SelectPostJoinUserDto;
import com.posco.insta.user.model.UserDto;
import com.posco.insta.post.repository.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements postService{
    @Autowired
    PostMapper postMapper;

    @Override
    public List<PostDto> findPost() {
        return postMapper.getPost();
    }



    @Override
    public List<SelectPostJoinUserDto> getPostByUserId(PostDto postDto) {
        return postMapper.findPostsByUserId(postDto);
    }

    @Override
    public int deleteMypost(PostDto postDto) {
        return postMapper.deletePostByUserIdAndId(postDto);
    }

    @Override
    public List<SelectPostJoinUserDto> findPostsByNotUserId(PostDto postDto) {
        return postMapper.findPostsByNotUserId(postDto);
    }

    @Override
    public int updatePostById(PostDto postDto) {
        return postMapper.updatePostById(postDto);
    }

    @Override
    public int insertPost(PostDto postDto) {
        return postMapper.insertPost(postDto);
    }

    @Override
    public SelectPostJoinUserDto getPostsById(PostDto postDto) {
        return postMapper.getPostsById(postDto);
    }

    @Override
    public List<SelectPostJoinUserDto> findPostsLikeKey(String key) {
        return postMapper.getPostByKey(key);
    }

    @Override
    public List<SelectPostJoinUserDto> getPostsByMyFollowing(PostDto postDto) {
        return postMapper.getPostsByMyFollowing(postDto);
    }
}
