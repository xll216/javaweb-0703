package com.lanou.crm.base;

import java.util.List;

public interface BaseDao<T> {

    /**
     * 添加
     *
     * @param t
     */
    void save(T t);

    /**
     * 更新
     *
     * @param t
     */
    void update(T t);

    /**
     * 保存或更新
     * * 代理主键：如果没有OID将执行save，如果有OID将执行update
     *
     * @param t
     */
    void saveOrUpdate(T t);

    /**
     * 删除
     *
     * @param t
     */
    void delete(T t);

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    T findById(java.io.Serializable id);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();

    /**
     * 带有条件查询所有
     *
     * @param condition 条件语句 （where之后的语句）
     *                  * 格式： and 属性 关键字 ?
     *                  * 例如：and name like ?
     * @param params    条件
     * @return
     */
    List<T> findAll(String condition, Object... params);

    /**
     * 查询总记录数
     *
     * @return
     */
    int getTotalRecord();

    /**
     * 查询分页数据
     *
     * @return
     */
    List<T> findAllByPage(String condition, Object[] params, PageBean<T> pb);

}
