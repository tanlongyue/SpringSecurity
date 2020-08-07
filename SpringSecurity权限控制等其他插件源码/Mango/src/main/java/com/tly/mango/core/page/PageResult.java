package com.tly.mango.core.page;

import java.util.List;
import lombok.Data;
@Data
public class PageResult {

    /**
     *  当前页码
     * */
    private int pageNum;

    /**
     * 每页数量
     * */
    private int pageSize;

    /**
     * 记录总数
     * */
    private long totalSize;

    /**
     * 页码总数
     * */
    private int totalPages;

    /**
     * 分页数据
     * */
    private List<?> content;
}
