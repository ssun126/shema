package com.dongwoo.SQM.system.repository;

import com.dongwoo.SQM.system.dto.BaseCodeDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BaseCodeRepository {
    private final SqlSessionTemplate sql;

    public int save(BaseCodeDTO baseCodeDTO) {
        return sql.insert("BaseCode.save", baseCodeDTO);
    }

    public List<BaseCodeDTO> findAll() {
        return sql.selectList("BaseCode.findAll");
    }

    public BaseCodeDTO findByCodeName(BaseCodeDTO baseCodeDTO) {
        return sql.selectOne("BaseCode.findByCodeName", baseCodeDTO);
    }

    public List<BaseCodeDTO> findByCodeGroup(BaseCodeDTO baseCodeDTO) {
        return sql.selectList("BaseCode.findByCodeGroup", baseCodeDTO);
    }

    public void update(BaseCodeDTO baseCodeDTO) {
        sql.update("BaseCode.update", baseCodeDTO);
    }

    public void delete(int CODEID) {
        sql.delete("BaseCode.delete", CODEID);
    }
}