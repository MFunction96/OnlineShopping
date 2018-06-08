package xyz.mfbrain.onlineshopping.utils;

import java.util.List;

/**
 * @program: OnlineShopping
 * @description: 分页工具
 * @author: ChrisYoung
 * @create: 2018-05-24 08:19
 **/

public class PageModle<T> {


    private int totalRecords;  //全部记录数
    private int pageNo=1;  //当前页码
    private int pageSize;  //每页的记录数
    private List<T> list; //每页数据项数组

    public PageModle(int totalRecords, int pageNo, int pageSize, List list){
        this.totalRecords = totalRecords;
        this.pageNo=pageNo;
        this.pageSize=pageSize;
        this.list=list;
    }

    /**
     * 获取总页数
     * @return 总页数
     */
    public int getTotalPages(){
        return (totalRecords+pageSize-1)/pageSize;
    }

    /**
     * 转到第一页
     * @return 第一页
     */
    public int getFirstPage(){
        return 1;
    }

    /**
     * 转到最后一页
     * @return
     */
    public int getLastPage(){
        return getTotalPages();
    }

    public int getPrePage(){
        if(pageNo<=1){
            return 1;
        }else{
            return pageNo-1;
        }
    }

    public int getNextPage(){
        if(pageNo>=getTotalPages()){
            return getTotalPages();
        }else{
            return pageNo+1;
        }
    }


    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
