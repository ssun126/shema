package com.dongwoo.SQM.adminPartMgmt.repository;

import com.dongwoo.SQM.adminPartMgmt.dto.AdminPartMgmtDTO;
import com.dongwoo.SQM.partMgmt.dto.PartMgmtDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AdminPartMgmtRepository {
     private final SqlSessionTemplate sql;

    public List<AdminPartMgmtDTO> searchAdminPartMgmt(AdminPartMgmtDTO partMgmtDTO){
        return sql.selectList("adminPartMgmt.searchAdminPartMgmt",partMgmtDTO);
    }

}