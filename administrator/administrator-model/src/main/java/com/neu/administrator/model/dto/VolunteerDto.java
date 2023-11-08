package com.neu.administrator.model.dto;

import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Volunteer;
import lombok.Data;

@Data
public class VolunteerDto extends Volunteer {

    private Child child;

}
