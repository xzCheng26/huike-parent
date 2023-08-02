package com.huike.clues.service;

import com.huike.common.core.domain.entity.SysDictData;

import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 15:08
 * 字典管理
 */
public interface ISysDictDataService {

    /**
     * 字典列表
     * @param dictData
     * @return
     */
    List<SysDictData> selectDictDataList(SysDictData dictData);
}
