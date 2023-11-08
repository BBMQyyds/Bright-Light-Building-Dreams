package com.neu.administrator.model.dto;

import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Volunteer;
import lombok.Data;

import java.util.List;

@Data
public class TaskDto extends Child {
    private List<Child> children ;

    private List<Volunteer> volunteers;
    private String taskId;

}
