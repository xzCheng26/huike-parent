package com.huike.clues.mapper;

import com.huike.common.core.domain.entity.SysDictType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 16:16
 */
@Mapper
public interface SysDictTypeMapper {

    /**
     * 分页查询数据字典类型信息
     * @param dictType
     * @return
     */
    List<SysDictType> selectDictTypeList(SysDictType dictType);
}
