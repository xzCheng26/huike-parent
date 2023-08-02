package com.huike.clues.service.impl;

import com.huike.clues.mapper.SysDictDataMapper;
import com.huike.clues.service.ISysDictDataService;
import com.huike.common.core.domain.entity.SysDictData;
import com.huike.common.exception.BaseException;
import com.huike.common.utils.DictUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 15:09
 */
@Service
public class SysDictDataServiceImpl implements ISysDictDataService {

    @Resource
    private SysDictDataMapper dictDataMapper;


    /**
     * 字典列表
     *
     * @param dictData
     * @return
     */
    @Override
    public List<SysDictData> selectDictDataList(SysDictData dictData) {

        return dictDataMapper.selectDictDataList(dictData);
    }
}
