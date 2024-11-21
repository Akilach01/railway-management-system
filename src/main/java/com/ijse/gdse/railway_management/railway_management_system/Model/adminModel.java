package com.ijse.gdse.railway_management.railway_management_system.Model;


import com.ijse.gdse.railway_management.railway_management_system.dto.registerAdminDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.SQLException;

public class adminModel {
    public static boolean saveUser(registerAdminDto registerAdminDto) throws SQLException, ClassNotFoundException {
        return crudUtil.execute(
                "insert into admin values (?,?,?,?)",
                registerAdminDto.getUsername(),
                registerAdminDto.getPassword(),
                registerAdminDto.getContact_no(),
                registerAdminDto.getGmail()

        );
    }

}
