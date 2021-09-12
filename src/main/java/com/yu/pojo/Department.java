package com.yu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 15:43 2021/9/6
 * @Modified By:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
