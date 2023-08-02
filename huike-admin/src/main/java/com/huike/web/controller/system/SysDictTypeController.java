package com.huike.web.controller.system;

import com.huike.clues.service.ISysDictTypeService;
import com.huike.common.annotation.Log;
import com.huike.common.constant.UserConstants;
import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.AjaxResult;
import com.huike.common.core.domain.entity.SysDictType;
import com.huike.common.core.page.TableDataInfo;
import com.huike.common.enums.BusinessType;
import com.huike.common.utils.SecurityUtils;
import com.huike.common.utils.poi.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xzCheng
 * @CreateDate 2023/8/2 16:13
 * 数据字典类型信息
 */
@RestController
@RequestMapping("/system/dict/type")
public class SysDictTypeController extends BaseController {

    @Resource
    private ISysDictTypeService iSysDictTypeService;


    /**
     * 分页查询数据字典类型信息
     *
     * @param dictType
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:dict:list')")
    @GetMapping("list")
    public TableDataInfo<List<SysDictType>> list(SysDictType dictType) {
        startPage();
        List<SysDictType> list = iSysDictTypeService.selectDictTypeList(dictType);
        return getDataTable(list);
    }

    /**
     * 查询字典类型详细
     *
     * @param dictId
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:dict:query')")
    @GetMapping(value = "/{dictId}")
    public AjaxResult<SysDictType> getInfo(@PathVariable Long dictId) {
        return AjaxResult.success(iSysDictTypeService.selectDictTypeById(dictId));
    }


    /**
     * 新增字典类型
     *
     * @param dict
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:dict:add')")
    @Log(title = "字典类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysDictType dict) {

        if (UserConstants.NOT_UNIQUE.equals(iSysDictTypeService.checkDictTypeUnique(dict))) {
            return AjaxResult.error("新增字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        dict.setCreateBy(SecurityUtils.getUsername());

        return toAjax(iSysDictTypeService.insertDictType(dict));
    }

    /**
     * 修改字典类型
     *
     * @param dict
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:dict:edit')")
    @Log(title = "字典类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDictType dict) {

        if (UserConstants.NOT_UNIQUE.equals(iSysDictTypeService.checkDictTypeUnique(dict))) {
            return AjaxResult.error("修改字典'" + dict.getDictName() + "'失败，字典类型已存在");
        }
        dict.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(iSysDictTypeService.updateDictType(dict));
    }

    /**
     * 删除字典类型
     */
    @PreAuthorize("@ss.hasPermi('system:dict:remove')")
    @Log(title = "字典类型", businessType = BusinessType.DELETE)
    @DeleteMapping("/{dictIds}")
    public AjaxResult remove(@PathVariable Long[] dictIds) {
        return toAjax(iSysDictTypeService.deleteDictTypeByIds(dictIds));
    }

    /**
     * 清空缓存
     */
    @PreAuthorize("@ss.hasPermi('system:dict:remove')")
    @Log(title = "字典类型", businessType = BusinessType.CLEAN)
    @DeleteMapping("/clearCache")
    public AjaxResult clearCache() {
        iSysDictTypeService.clearCache();
        return AjaxResult.success();
    }

    /**
     * 获取字典选择框列表
     */
    @GetMapping("/optionselect")
    public AjaxResult<List<SysDictType>> optionselect() {
        List<SysDictType> dictTypes = iSysDictTypeService.selectDictTypeAll();
        return AjaxResult.success(dictTypes);
    }

    /**
     * 导出数据
     *
     * @param dictType
     * @return
     */
    @Log(title = "字典类型", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:dict:export')")
    @GetMapping("/export")
    public AjaxResult export(SysDictType dictType) {
        List<SysDictType> list = iSysDictTypeService.selectDictTypeList(dictType);
        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
        return util.exportExcel(list, "字典类型");
    }
}
