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

    /**
     * 查询字典类型详细
     * @param dictId
     * @return
     */
    SysDictType selectDictTypeById(Long dictId);

    /**
     * 校验字典类型称是否唯一
     * @param dict
     * @return
     */
    String checkDictTypeUnique(SysDictType dict);

    /**
     * 新增保存字典类型信息
     * @param dict
     * @return
     */
    int insertDictType(SysDictType dict);

    /**
     * 修改保存字典类型信息
     * @param dictType
     * @return
     */
    int updateDictType(SysDictType dictType);

    /**
     * 批量删除字典信息
     * @param dictIds
     * @return
     */
    int deleteDictTypeByIds(Long[] dictIds);

    /**
     * 清空缓存
     */
    void clearCache();

    /**
     * 获取字典选择框列表
     * @return
     */
    List<SysDictType> selectDictTypeAll();
}
