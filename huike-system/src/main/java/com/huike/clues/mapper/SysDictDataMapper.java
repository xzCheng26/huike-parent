package com.huike.clues.mapper;

import com.huike.common.core.domain.entity.SysDictData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 15:10
 * 字典管理
 */
@Mapper
public interface SysDictDataMapper {

    /**
     * 字典列表
     * @param dictData
     * @return
     */
    List<SysDictData> selectDictDataList(SysDictData dictData);


}
