package com.dongwoo.SQM.qualityCtrl.repository;

import com.dongwoo.SQM.qualityCtrl.dto.coaMgmtDTO;
import com.dongwoo.SQM.siteMgr.dto.BaseCodeDTO;
import com.dongwoo.SQM.system.dto.ComPanyCodeDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class coaMgmtRepository {
    private final SqlSessionTemplate sql;

    public List<BaseCodeDTO> GetBaseCode(String GROUP_CODE) {
        return sql.selectList("coaMgmt.GetBaseCode",GROUP_CODE );
    }

    public List<BaseCodeDTO> GetBaseCodePLANT(String GROUP_CODE) {
        return sql.selectList("coaMgmt.GetBaseCodePLANT",GROUP_CODE );
    }
    //사용자 팝업 조회
    public List<HashMap> getUserList(Map<String, Object> params) {
        return sql.selectList("coaMgmt.getUserList", params);
    }
    //자재 팝업 조회 ,엑셀 업로드 콤보 리스트
    public List<HashMap> getCoaMaterialList(Map<String, Object> params) {
        return sql.selectList("coaMgmt.getCoaMaterialList", params);
    }

    //COA 엑셀 등록 팝업 플랜트
    public List<HashMap> getMaterialFactoryListCoa(Map<String, Object> params) {
        return sql.selectList("coaMgmt.getMaterialFactoryListCoa", params);
    }


    public List<coaMgmtDTO> getCOAList(coaMgmtDTO coaMgmtDTO) {
        return sql.selectList("coaMgmt.getCOAList", coaMgmtDTO);
    }

    public coaMgmtDTO getCOADetailTitle(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.getCOADetailTitle", coaMgmtDTO);
    }

    public List<coaMgmtDTO> getCOADetailSpec(coaMgmtDTO coaMgmtDTO) {
        return sql.selectList("coaMgmt.getCOADetailSpec", coaMgmtDTO);
    }

    //엑셀 업로드
    public List<LinkedHashMap<String,Object>> getSpecList(Map<String, Object> parameterMap) {
        return sql.selectList("coaMgmt.getSpecList", parameterMap);
    }



    //업데이트
    public int updateVendorComment(coaMgmtDTO coaMgmtDTO) {
        return sql.update("coaMgmt.updateVendorComment", coaMgmtDTO);
    }


    public String getCOANumber() {
        return sql.selectOne("coaMgmt.getCOANumber");
    }

    public int copyCOAMaster(coaMgmtDTO coaMgmtDTO) {
        return sql.insert("coaMgmt.copyCOAMaster", coaMgmtDTO);
    }

    public int copyCOADetail(coaMgmtDTO coaMgmtDTO) {
        return sql.insert("coaMgmt.copyCOADetail", coaMgmtDTO);
    }

    public int delCOAMaster(coaMgmtDTO coaMgmtDTO) {
        return sql.delete("coaMgmt.delCOAMaster", coaMgmtDTO);
    }

    public int delCOADetail(coaMgmtDTO coaMgmtDTO) {
        return sql.delete("coaMgmt.delCOADetail", coaMgmtDTO);
    }

    public coaMgmtDTO regCheck(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.regCheck", coaMgmtDTO);
    }

    public coaMgmtDTO regSpecCheck(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.regSpecCheck", coaMgmtDTO);
    }

    public LinkedHashMap<String,Object> regCheck(Map<String, Object> parameterMap) {
        return sql.selectOne("coaMgmt.regCheckMap", parameterMap);
    }

    public LinkedHashMap<String,Object> regSpecCheck(Map<String, Object> parameterMap) {
        return sql.selectOne("coaMgmt.regSpecCheckMap", parameterMap);
    }

    public String getStatusCOAMasterByPK(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.getStatusCOAMasterByPK", coaMgmtDTO);
    }



    public coaMgmtDTO getMaterial(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.getMaterial", coaMgmtDTO);
    }

    public LinkedHashMap<String,Object> getMaterial(Map<String, Object> parameterMap) {
        return sql.selectOne("coaMgmt.getMaterialMap", parameterMap);
    }

    public int getExistCount(Map<String, Object> parameterMap) {
        return sql.selectOne("coaMgmt.getExistCount", parameterMap);
    }
    public Object insertCOAMaster(Map<String, Object> parameterMap) {
        return sql.insert("coaMgmt.insertCOAMaster", parameterMap);
    }
    public Object insertCOADetail(Map<String, Object> parameterMap) {
        return sql.insert("coaMgmt.insertCOADetail", parameterMap);
    }


    //interface
    public coaMgmtDTO interfaceLimsCOAMasterData(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.interfaceLimsCOAMasterData", coaMgmtDTO);
    }

    public List<coaMgmtDTO> interfaceLimsCOADetailData(coaMgmtDTO coaMgmtDTO) {
        return sql.selectList("coaMgmt.interfaceLimsCOADetailData", coaMgmtDTO);
    }

    public int interfaceCOAMaster(coaMgmtDTO coaMgmtDTO) {
        return sql.update("coaMgmt.interfaceCOAMaster", coaMgmtDTO);
    }

    public int interfaceCOADetail(coaMgmtDTO coaMgmtDTO) {
        return sql.update("coaMgmt.interfaceCOADetail", coaMgmtDTO);
    }

    public coaMgmtDTO interfaceDqmsCOAMasterData(coaMgmtDTO coaMgmtDTO) {
        return sql.selectOne("coaMgmt.interfaceDqmsCOAMasterData", coaMgmtDTO);
    }

    public List<coaMgmtDTO> interfaceDqmsCOADetailData(coaMgmtDTO coaMgmtDTO) {
        return sql.selectList("coaMgmt.interfaceDqmsCOADetailData", coaMgmtDTO);
    }

    public int interfaceCOAProcedure(String DB_LINK_TARGET_APPLY) {
        return sql.update("coaMgmt.interfaceCOAProcedure", DB_LINK_TARGET_APPLY);
    }


    //CPS
    public int interfaceDqmsCOAMaster(coaMgmtDTO masterList) {
        return sql.insert("coaMgmt.interfaceDqmsCOAMaster", masterList);
    }

    public int interfaceDqmsCOADetail(coaMgmtDTO detailList) {
        return sql.insert("coaMgmt.interfaceDqmsCOADetail", detailList);
    }
    //CPS


    //메일 수신자
    public List<HashMap> getEmailTargetUser(Map<String, Object> params) {
        return sql.selectList("coaMgmt.getEmailTargetUser", params);
    }

    public int updateCOAStatus(coaMgmtDTO coaMgmtDTO) {
        return sql.update("coaMgmt.updateCOAStatus", coaMgmtDTO);
    }

    public int insertCOADFile(Map<String, Object> parameterMap) {
        return sql.update("coaMgmt.insertCOADFile", parameterMap);
    }


    public String parseDate(String param) {
        return sql.selectOne("coaMgmt.parseDate", param);
    }



}
