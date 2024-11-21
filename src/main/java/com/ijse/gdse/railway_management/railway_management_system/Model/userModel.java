package com.ijse.gdse.railway_management.railway_management_system.Model;

import com.ijse.gdse.railway_management.railway_management_system.dto.userDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

public class userModel {


    public String handleRegisterUser(userDto userDto) throws Exception{
        String sql = "insert into user values(?,?,?,?)";
        Boolean resp = crudUtil.execute(sql,userDto.getU_id(),userDto.getName(),userDto.getContact_no(),userDto.getGmail());
        return resp == Boolean.TRUE ? "success" : "fail";
    }
}
