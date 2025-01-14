package com.dongwoo.SQM.companyInfo.repository;

import com.dongwoo.SQM.board.dto.BoardDTO;
import com.dongwoo.SQM.board.dto.Criteria;
import com.dongwoo.SQM.companyInfo.dto.CompanyInfoDTO;
import com.dongwoo.SQM.companyInfo.dto.CompanyInfoParamDTO;
import com.dongwoo.SQM.companyInfo.dto.CpCodeDTO;
import com.dongwoo.SQM.siteMgr.dto.BaseCodeDTO;
import com.dongwoo.SQM.siteMgr.dto.UserMgrDTO;
import com.dongwoo.SQM.siteMgr.dto.UserMgrParamDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class CompanyInfoRepository {
    private final SqlSessionTemplate sql;

    //코드 바인딩
    public List<BaseCodeDTO> GetBaseCode(String GROUP_CODE) {
        return sql.selectList("CompanyInfo.GetBaseCode",GROUP_CODE );
    }

    //업체 리스트 검색 2024.11.8
    public List<CompanyInfoDTO> findCompanySearch(CompanyInfoParamDTO companyInfoParamDTO ) {
        //if(Objects.equals(SearchType, "List")) {
        return sql.selectList("CompanyInfo.findCompanyInfo", companyInfoParamDTO);
    }

    //업체 리스트 검색 2024.11.8
    public List<CompanyInfoDTO> approvalCompanySearch(CompanyInfoParamDTO companyInfoParamDTO ) {
        return sql.selectList("CompanyInfo.findCpApprovalList", companyInfoParamDTO);
    }

    //업체 리스트 검색 USeridx
    public List<CompanyInfoDTO> approvalCompanySearchUseridx(CompanyInfoParamDTO companyInfoParamDTO ) {
        return sql.selectList("CompanyInfo.findCpApprovalList", companyInfoParamDTO);
    }

    //업체 거래 사업부
    public List<CompanyInfoDTO> findCompanyCodeWork(CompanyInfoParamDTO companyInfoParamDTO ) {
        return sql.selectList("CompanyInfo.findCompanyCodeWork", companyInfoParamDTO);
    }

    ////업체 회원 ID 검색 확장
    public List<CompanyInfoDTO> findCompanyCodeWorkEx(CompanyInfoParamDTO companyInfoParamDTO ) {
        return sql.selectList("CompanyInfo.findCompanyCodeWorkEx", companyInfoParamDTO);
    }

    //신청정보 조회
    public CompanyInfoDTO findCompanyApprovalID(CompanyInfoParamDTO companyInfoParamDTO ) {
        return sql.selectOne("CompanyInfo.findCompanyApprovalID", companyInfoParamDTO);
    }


    public int save(CpCodeDTO cpCodeDTO) {
        return sql.insert("CompanyInfo.save", cpCodeDTO);
    }
    // 신규저장
    public int insertComCode(CpCodeDTO cpCodeDTO) {
        return sql.insert("CompanyInfo.insertComCode", cpCodeDTO);
    }

    // 수정
    public int updateComCode(CpCodeDTO cpCodeDTO) {
        return sql.insert("CompanyInfo.updateComCode", cpCodeDTO);
    }

    // 신규 저장
    public int insertComCodeWork(CpCodeDTO cpCodeDTO) {
        return sql.insert("CompanyInfo.insertComCodeWork", cpCodeDTO);
    }

    // 삭제
    public int deleteComCodeWork(CpCodeDTO cpCodeDTO) {
        return sql.insert("CompanyInfo.deleteComCodeWork", cpCodeDTO);
    }

    public List<CompanyInfoDTO> findAll() {
        return sql.selectList("CompanyInfo.findAll");
    }

    public List<CompanyInfoDTO> getList(Criteria criteria) {
        return sql.selectList("CompanyInfo.getList", criteria);
    }

    public int getTotal(){
        return sql.selectOne("CompanyInfo.getTotal");
    }

    public CompanyInfoDTO findByCompanyId(String id) {
        return sql.selectOne("CompanyInfo.findByCompanyId", id);
    }

    public void update(CompanyInfoDTO companyInfoDTO) {
        sql.update("CompanyInfo.update", companyInfoDTO);
    }

    public void delete(int id) {
        sql.delete("CompanyInfo.delete", id);
    }

    public List<CompanyInfoDTO> findByCriteria(Map<String, Object> params) {
        return sql.selectList("CompanyInfo.findByCriteria", params);
    }

    public List<CompanyInfoDTO> findSearch(Map<String, Object> params) {
        return sql.selectList("CompanyInfo.findSearch", params);
    }

    public int countByKeyword(Map<String, Object> params) {
        return sql.selectOne("CompanyInfo.countByKeyword", params);
    }

    public List<HashMap> getApiList(Map<String, Object> params) {
        return sql.selectList("CompanyInfo.getApiList", params);
    }



}
