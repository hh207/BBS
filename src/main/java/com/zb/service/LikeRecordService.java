package com.zb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zb.entity.LikeRecord;

import java.util.List;

/**
*
*/
public interface LikeRecordService extends IService<LikeRecord> {
    int deleteRecord(Integer userId, Integer commentId);

    int insertRecord(LikeRecord likeRecord);

    List<LikeRecord> findById(Integer userId, Integer commentId);

    List<LikeRecord> findByUserId(Integer userId);
}
