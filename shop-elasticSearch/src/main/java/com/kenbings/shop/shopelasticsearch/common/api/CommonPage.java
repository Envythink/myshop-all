package com.kenbings.shop.shopelasticsearch.common.api;

import com.github.pagehelper.PageInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 分页数据封装类
 */
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将 PageHelper 分页后的list转换为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list){
        CommonPage<T> commonPage = new CommonPage<>();
        PageInfo<T> pageInfo = new PageInfo<>(list);
        commonPage.setPageNum(pageInfo.getPageNum());
        commonPage.setPageSize(pageInfo.getPageSize());
        commonPage.setTotalPage(pageInfo.getPages());
        commonPage.setTotal(pageInfo.getTotal());
        commonPage.setList(pageInfo.getList());
        return commonPage;
    }

    /**
     * 将 SpringData 分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo){
        CommonPage<T> commonPage = new CommonPage<>();
        commonPage.setPageNum(pageInfo.getNumber());
        commonPage.setPageSize(pageInfo.getSize());
        commonPage.setTotalPage(pageInfo.getTotalPages());
        commonPage.setTotal(pageInfo.getTotalElements());
        commonPage.setList(pageInfo.getContent());
        return commonPage;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}