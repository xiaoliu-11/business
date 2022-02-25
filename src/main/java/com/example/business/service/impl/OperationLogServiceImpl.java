package com.example.business.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.entity.OperationLogPO;
import com.example.business.mapper.OperationLogPOMapper;
import com.example.business.service.OperationLogService;
import org.springframework.stereotype.Service;

/**
 * @author: 刘树国
 * @create: 2022-02-18
 */

@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogPOMapper, OperationLogPO> implements OperationLogService {
}
