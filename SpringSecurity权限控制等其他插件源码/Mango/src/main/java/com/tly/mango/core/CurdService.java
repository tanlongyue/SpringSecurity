package com.tly.mango.core;
import com.tly.mango.core.page.PageRequest;
import com.tly.mango.core.page.PageResult;
import java.util.List;
public interface CurdService<T> {

    /**
     * 对信息的保存
     * */
     int save(T record);


     /**
      * 对信息的删除
      * */
     int delete(T record);

     /**
      * 批量删除的操作
      * */
     int delete(List<T> records);

     /**
      * 根据ID查询
      * */
     T findById(Long id);

     /**
      * 分页查询
      * */
     PageResult findPage(PageRequest pageRequest) throws NoSuchMethodException;
}
