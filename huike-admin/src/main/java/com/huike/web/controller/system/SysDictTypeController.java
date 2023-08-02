package com.huike.web.controller.system;

import com.huike.clues.service.ISysDictTypeService;
import com.huike.common.core.controller.BaseController;
import com.huike.common.core.domain.entity.SysDictType;
import com.huike.common.core.page.TableDataInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param dictType
     * @return
     */
    @GetMapping("list")
    public TableDataInfo<List<SysDictType>> list(SysDictType dictType) {
        startPage();
        List<SysDictType> list = iSysDictTypeService.selectDictTypeList(dictType);
        return getDataTable(list);
    }
}
