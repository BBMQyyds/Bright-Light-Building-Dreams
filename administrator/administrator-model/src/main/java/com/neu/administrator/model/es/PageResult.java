package com.neu.administrator.model.es;

import com.neu.administrator.model.po.Child;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class  PageResult<T> {
    private Long total;
    private List<T> objects;

    public PageResult() {
    }

    public PageResult(Long total, List<T> objects) {
        this.total = total;
        this.objects = objects;
    }
}
