package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zb.entity.Comment;

import java.util.List;

/**
*
*/

public interface CommentService extends IService<Comment> {

    List<Comment> findAll();

    Comment findByCommentId(Integer commentId);

    int updateByCommentId(Integer likes, Integer userId);
}
