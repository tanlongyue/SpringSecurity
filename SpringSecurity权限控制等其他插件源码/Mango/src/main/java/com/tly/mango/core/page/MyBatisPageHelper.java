package com.tly.mango.core.page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tly.mango.util.*;

import java.lang.reflect.Method;
import java.util.List;

public class MyBatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询,约定查询方法名为findPage
     * */

    public static PageResult findPage(PageRequest pageRequest,Object mapper) throws NoSuchMethodException {
        //这里mapper是对象啊问你是不是实体的，你看看这行代码，他忘球这里了，哈哈

        return findPage(pageRequest,mapper,findPage);
    }

    //findPage
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) throws NoSuchMethodException {
        // 设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        // 利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo((List) result));
    }
    /**
     * 将分页信息封装到统一的接口
     * */
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo){
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}
