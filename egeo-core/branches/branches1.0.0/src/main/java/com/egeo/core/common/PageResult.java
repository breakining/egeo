package com.egeo.core.common;

import java.io.Serializable;
import java.util.List;

import com.egeo.core.orm.Pagination;

public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = -5508893650738751862L;

    private int pageNo;

    private int pageSize;

    private int totalSize;

    private int totalPage;

    /**
     * 平台名字
     */
    private String PlatformName;

    private List<T> list;

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

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
    	if(totalSize != 0 || pageSize != 0){
    		this.totalPage = totalSize / pageSize + (totalSize % pageSize == 0 ? 0 : 1);
    	}else{
    		this.totalPage = 0;
    	}
        
        return totalPage;
    }

    public void copy(PageResult<? extends Object> page) {
        this.setPageNo(page.getPageNo());
        this.setPageSize(page.getPageSize());
        this.setTotalSize(page.getTotalSize());
    }

    public void copy(Pagination page) {
        this.setPageNo(page.getPageNo());
        this.setPageSize(page.getPageSize());
    }

    /**
     * 
     * @description
     * 
     *              <pre>
     *              根据页码和每页记录数获取页起始记录
     *              </pre>
     * 
     * @return
     */
    public int getStartItem() {

        int start = (pageNo - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        return start;
    }

    /**
     * 根据页码和每页记录数获取页起始记录
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static int getStartItem(int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        if (start < 0) {
            start = 0;
        }
        return start;
    }

    /**
     * 分页是否已经结束
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public static boolean isFinished(int totalSize, int pageSize, int pageNo) {

        return totalSize >= (pageNo - 1) * pageSize;
    }

    /**
     * 分页是否已经结束
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public boolean isFinished() {

        return this.totalSize >= (this.pageNo - 1) * this.pageSize;
    }

    /**
     * 根据DTO 获取分页信息
     * 
     * @date 2016年8月18日 下午2:36:37
     * @param dto
     * @return
     */
    public static Pagination getPageByDTO(Pagination dto) {
        Pagination page = new Pagination();
        page.setPageNo(dto.getPageNo());
        page.setPageSize(dto.getPageSize());

        page.setLimitStart(getStartItem(dto.getPageNo(), dto.getPageSize()));
        return page;
    }

    public String getPlatformName() {
        return PlatformName;
    }

    public void setPlatformName(String platformName) {
        PlatformName = platformName;
    }

}
