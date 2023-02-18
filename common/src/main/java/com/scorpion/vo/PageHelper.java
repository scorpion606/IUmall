package com.scorpion.vo;

import java.util.List;

/**
 * @author scorpion
 * @date 2021/11/27
 */
public class PageHelper<T> {
    public PageHelper() {
    }

    public PageHelper(Integer count, Integer pageCount, List<T> list) {
        this.count = count;
        this.pageCount = pageCount;
        this.list = list;
    }

    /**
     * 总记录数
     */
    private Integer count;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 分页数据
     */
    private List<T> list;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageHelper{" +
                "count=" + count +
                ", pageCount=" + pageCount +
                ", list=" + list +
                '}';
    }
}
