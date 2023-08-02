package com.huike.clues.service.impl;

import com.huike.clues.mapper.SysDictTypeMapper;
import com.huike.clues.service.ISysDictTypeService;
import com.huike.common.core.domain.entity.SysDictType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 16:14
 */
@Service
public class SysDictTypeServiceImpl implements ISysDictTypeService {


    @Resource
    private SysDictTypeMapper sysDictTypeMapper;

    /**
     * 分页查询数据字典类型信息
     *
     * @param dictType
     * @return
     */
    @Override
    public List<SysDictType> selectDictTypeList(SysDictType dictType) {

        return sysDictTypeMapper.selectDictTypeList(dictType);
    }
}
