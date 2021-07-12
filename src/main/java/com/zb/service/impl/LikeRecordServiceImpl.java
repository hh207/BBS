package com.zb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zb.entity.LikeRecord;
import com.zb.mapper.LikeRecordMapper;
import com.zb.service.LikeRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
*
*/
@Service
public class LikeRecordServiceImpl extends ServiceImpl<LikeRecordMapper, LikeRecord>
implements LikeRecordService {

    @Resource
    private LikeRecordMapper likeRecordMapper;

    @Override
    public int deleteRecord(Integer userId, Integer commentId) {
        LambdaQueryWrapper<LikeRecord> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(LikeRecord::getUserid, userId);
        lambdaQueryWrapper.eq(LikeRecord::getComment, commentId);
        return likeRecordMapper.delete(lambdaQueryWrapper);
    }

    @Override
    public int insertRecord(LikeRecord likeRecord) {
        return likeRecordMapper.insert(likeRecord);
    }

    @Override
    public List<LikeRecord> findById(Integer userId, Integer commentId) {
        LambdaQueryWrapper<LikeRecord> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(LikeRecord::getUserid, userId);
        lambdaQueryWrapper.eq(LikeRecord::getComment, commentId);
        return likeRecordMapper.selectList(lambdaQueryWrapper);
    }

    @Override
    public List<LikeRecord> findByUserId(Integer userId) {
        return likeRecordMapper.findByUserid(userId);
    }
}
