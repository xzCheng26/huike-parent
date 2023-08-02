package com.huike.clues.service.impl;

import com.huike.clues.mapper.SysDictDataMapper;
import com.huike.clues.mapper.SysDictTypeMapper;
import com.huike.clues.service.ISysDictTypeService;
import com.huike.common.constant.UserConstants;
import com.huike.common.core.domain.entity.SysDictType;
import com.huike.common.exception.BaseException;
import com.huike.common.exception.CustomException;
import com.huike.common.utils.DictUtils;
import com.huike.common.utils.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private SysDictDataMapper sysDictDataMapper;

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

    /**
     * 查询字典类型详细
     *
     * @param dictId
     * @return
     */
    @Override
    public SysDictType selectDictTypeById(Long dictId) {

        return sysDictDataMapper.selectDictTypeById(dictId);
    }

    /**
     * 校验字典类型称是否唯一
     *
     * @param dict
     * @return
     */
    @Override
    public String checkDictTypeUnique(SysDictType dict) {

        Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
        SysDictType dictType = sysDictTypeMapper.checkDictTypeUnique(dict.getDictType());
        // 判断状态
        if (StringUtils.isNotNull(dictType) && dictType.getDictId().longValue() != dictId.longValue()) {
            // 用户状态
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存字典类型信息
     *
     * @param dictType
     * @return
     */
    @Override
    public int insertDictType(SysDictType dictType) {
        int row = sysDictTypeMapper.insertDictType(dictType);
        if (row > 0) {
            // 清空字典缓存
            DictUtils.clearDictCache();
        }
        return row;
    }

    /**
     * 修改保存字典类型信息
     *
     * @param dictType
     * @return
     */
    @Override
    @Transactional
    public int updateDictType(SysDictType dictType) {

        if (dictType.getDictId() <= 124) {
            throw new BaseException("不可修改原始数据");
        }
        // 根据字典类型id查询字典类型
        SysDictType oldDict = sysDictTypeMapper.selectDictTypeById(dictType.getDictId());
        // 同步修改字典
        sysDictDataMapper.updateDictDataType(oldDict.getDictType(), dictType.getDictType());
        // 修改字典类型信息
        int row = sysDictTypeMapper.updateDictType(dictType);
        if (row > 0) {
            DictUtils.clearDictCache();
        }
        return row;
    }

    /**
     * 批量删除字典信息
     *
     * @param dictIds
     * @return
     */
    @Override
    public int deleteDictTypeByIds(Long[] dictIds) {

        for (Long dictId : dictIds) {
            if (dictId <= 124) {
                throw new BaseException("不可以修改原始数据");
            }
            SysDictType dictType = selectDictTypeById(dictId);

            if (sysDictDataMapper.countDictDataByType(dictType.getDictType()) > 0) {
                throw new CustomException(String.format("%1$s已分配,不能删除", dictType.getDictName()));
            }
        }
        int count = sysDictTypeMapper.deleteDictTypeByIds(dictIds);
        if (count > 0) {
            DictUtils.clearDictCache();
        }
        return count;
    }

    /**
     * 清空缓存
     */
    @Override
    public void clearCache() {
        DictUtils.clearDictCache();
    }

    /**
     * 获取字典选择框列表
     *
     * @return
     */
    @Override
    public List<SysDictType> selectDictTypeAll() {
        return sysDictTypeMapper.selectDictTypeAll();
    }
}
