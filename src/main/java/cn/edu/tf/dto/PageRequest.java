package cn.edu.tf.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 王俊
 * @date : 2020/1/7 10:41
 **/
public class PageRequest {
    private Integer page;
    private Integer limit;

    /**
     * 排序
     */
    private List<Sort> sortList;


    public static class Sort{
        public Sort() {
        }

        /**
         * 排序字段
         */
        private String clause;
        /**
         * 排序方式
         */
        private String direction;

        public String getClause() {
            return clause;
        }

        public void setClause(String clause) {
            this.clause = clause;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }
    }

    public interface Direction{
        String ASC="ASC";
        String DESC="DESC";
    }

    public PageRequest() {
        sortList=new ArrayList<>();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public List<Sort> getSortList() {
        return sortList;
    }

    public void setSortList(List<Sort> sortList) {
        this.sortList = sortList;
    }


}
