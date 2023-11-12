package com.neu.administrator.model.dto;

import com.neu.administrator.model.po.Child;
import com.neu.administrator.model.po.Volunteer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class QualificationsDto {


    private String volId;
    private String  orgId;


}
