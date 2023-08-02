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

    /**
     * 校验字典类型称是否唯一
     * @param dictType
     */
    SysDictType checkDictTypeUnique(String dictType);

    /**
     * 新增保存字典类型信息
     * @param dictType
     * @return
     */
    int insertDictType(SysDictType dictType);

    /**
     * 根据字典类型ID查询信息
     * @param dictId
     * @return
     */
    SysDictType selectDictTypeById(Long dictId);

    /**
     * 修改字典类型信息
     * @param dictType
     * @return
     */
    int updateDictType(SysDictType dictType);


    /**
     * 批量删除字典类型信息
     * @param dictIds
     * @return
     */
    int deleteDictTypeByIds(Long[] dictIds);

    /**
     * 获取字典选择框列表
     * @return
     */
    List<SysDictType> selectDictTypeAll();
}
