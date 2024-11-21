package com.ijse.gdse.railway_management.railway_management_system.Model;


import com.ijse.gdse.railway_management.railway_management_system.dto.trainManagementDto;
import com.ijse.gdse.railway_management.railway_management_system.util.crudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class trainModel {


    public boolean saveTrain(trainManagementDto trainDto) throws SQLException, ClassNotFoundException {
       return true;
    }

    public boolean updateTrain( trainManagementDto dto) throws SQLException, ClassNotFoundException {
        return true;
    }


    public boolean deleteTrain(String trainId) throws SQLException, ClassNotFoundException {
        return crudUtil.execute("delete from train where tr_id=?", trainId);
    }

}



