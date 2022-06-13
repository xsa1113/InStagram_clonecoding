package com.posco.insta.follow.controller;

import com.posco.insta.aspect.TokenRequired;
import com.posco.insta.config.SecurityService;
import com.posco.insta.follow.model.FollowDto;
import com.posco.insta.follow.service.FollowService;
import com.posco.insta.follow.service.FollowServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@TokenRequired
@RequestMapping("follow")
public class FollowController {
    @Autowired
    FollowDto followDto;
    @Autowired
    SecurityService securityService;
    @Autowired
    FollowServiceImpl followService;
    @GetMapping("/my/follower")
    @Operation(description = "내꺼 follower를 받아옴")
    public List<FollowDto> getMyFollower(){
        followDto.setFollowing(securityService.getIdAtToken());
        return followService.getFollower(followDto);
    }

    @GetMapping("/follower/{id}")
    @Operation(description = "follower를 받아옴")
    public List<FollowDto> getMyFollowerById(@PathVariable String id){
        followDto.setFollowing(Integer.valueOf(id));
        return followService.getFollower(followDto);
    }

    @GetMapping("/my/following")
    @Operation(description = "내꺼 following를 받아옴")
    public List<FollowDto> getMyFollowing(){
        followDto.setFollowing(securityService.getIdAtToken());
        return followService.getFollowing(followDto);
    }

    @GetMapping("/following/{id}")
    @Operation(description = "following를 받아옴")
    public List<FollowDto> getMyFollowingById(@PathVariable String id){
        followDto.setFollowing(Integer.valueOf(id));
        return followService.getFollowing(followDto);
    }

    @PostMapping("/{id}")
    @Operation(description = "내가 상대방의 following이 됨")
    public Integer postFollow(@PathVariable String id){
        followDto.setFollowing(securityService.getIdAtToken());
        followDto.setFollower(Integer.valueOf(id));
        return followService.insertFollow(followDto);
    }

    @DeleteMapping("/{id}")
    @Operation(description = "내가 상대방의 following이 였는데 삭제함 언팔")
    public Integer deleteFollow(@PathVariable String id){
        followDto.setFollowing(securityService.getIdAtToken());
        followDto.setFollower(Integer.valueOf(id));
        return followService.deleteFollow(followDto);
    }
}
