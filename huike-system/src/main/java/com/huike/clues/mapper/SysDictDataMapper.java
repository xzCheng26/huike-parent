package com.huike.clues.mapper;

import com.huike.common.core.domain.entity.SysDictData;
import com.huike.common.core.domain.entity.SysDictType;
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


    /**
     * 查询字典类型详细
     * @param dictId
     * @return
     */
    SysDictType selectDictTypeById(@Param("dictId") Long dictId);

    /**
     * 同步修改字典类型
     * @param oldDictType
     * @param newDictType
     * @return
     */
    int updateDictDataType(@Param("oldDictType") String oldDictType, @Param("newDictType") String newDictType);

    /**
     * 查询字典数据
     * @param dictType
     * @return
     */
    int countDictDataByType(String dictType);
}
