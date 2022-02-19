package com.example.hunter.entity;

import java.io.Serializable;
import java.io.Serializable;
import java.util.List;
public class PageResult implements Serializable {
    private Long total;//總記錄數
    private List rows;//當前頁結果
    public PageResult(Long total, List rows) {
        super();
        this.total = total;
        this.rows = rows;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
}

