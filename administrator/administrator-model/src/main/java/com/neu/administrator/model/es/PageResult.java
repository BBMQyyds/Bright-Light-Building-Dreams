package com.neu.administrator.model.es;

import com.neu.administrator.model.po.Child;
import lombok.Data;

import java.util.List;

@Data
public class PageResult {
    private Long total;
    private List<Child> children;

    public PageResult() {
    }

    public PageResult(Long total, List<Child> children) {
        this.total = total;
        this.children = children;
    }
}
