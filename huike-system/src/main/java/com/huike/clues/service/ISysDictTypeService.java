package com.huike.clues.service;

import com.huike.common.core.domain.entity.SysDictType;

import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 16:14
 */
public interface ISysDictTypeService {
    /**
     * 分页查询数据字典类型信息
     * @param dictType
     * @return
     */
    List<SysDictType> selectDictTypeList(SysDictType dictType);
}
