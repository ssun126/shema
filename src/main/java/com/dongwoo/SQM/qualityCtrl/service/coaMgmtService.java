package com.dongwoo.SQM.qualityCtrl.service;



import com.dongwoo.SQM.qualityCtrl.dto.coaMgmtDTO;
import com.dongwoo.SQM.qualityCtrl.repository.coaMgmtRepository;
import com.dongwoo.SQM.siteMgr.dto.BaseCodeDTO;
import com.dongwoo.SQM.system.dto.ComPanyCodeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class coaMgmtService {
    private final coaMgmtRepository coaMgmtRepository;

    public List<BaseCodeDTO> GetBaseCode(String group_code) {
        return coaMgmtRepository.GetBaseCode(group_code);
    }

    public List<BaseCodeDTO> GetBaseCodePLANT(String group_code) {
        return coaMgmtRepository.GetBaseCodePLANT(group_code);
    }
    public List<HashMap> getUserList(String code, String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("USER_ID", code);
        params.put("USER_NAME", name);
        return coaMgmtRepository.getUserList(params);
    }

    //메인 조회 자재 코드 팝업 ,엑셀 업로드 콤보 리스트
    public List<HashMap> getCoaMaterialList(String code, String name,String vendorId) {
        Map<String, Object> params = new HashMap<>();
        params.put("MATERIAL_ID", code);
        params.put("MATERIAL_NAME", name);
        params.put("VENDOR_ID", vendorId);
        return coaMgmtRepository.getCoaMaterialList(params);
    }


    public List<HashMap> getMaterialFactoryListCoa(String vendorId , String materialId  , String selLang) {
        Map<String, Object> params = new HashMap<>();
        params.put("vendorId", vendorId);
        params.put("materialId", materialId);
        params.put("TOKEN_USER_LANG", selLang);
        return coaMgmtRepository.getMaterialFactoryListCoa(params);
    }

    //COA LIST 검색
    public List<coaMgmtDTO> getCOAList(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.getCOAList(coaMgmtDTO);
    }

    public coaMgmtDTO getCOADetailTitle(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.getCOADetailTitle(coaMgmtDTO);
    }

    public String getCOANumber() {
        return coaMgmtRepository.getCOANumber();
    }


    public List<coaMgmtDTO> getCOADetailSpec(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.getCOADetailSpec(coaMgmtDTO);
    }

    public int updateVendorComment(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.updateVendorComment(coaMgmtDTO);
    }


    public int copyCOAMaster(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.copyCOAMaster(coaMgmtDTO);
    }

    public int copyCOADetail(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.copyCOADetail(coaMgmtDTO);
    }


    public int delCOAMaster(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.delCOAMaster(coaMgmtDTO);
    }

    public int delCOADetail(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.delCOADetail(coaMgmtDTO);
    }

    public coaMgmtDTO regCheck(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.regCheck(coaMgmtDTO);
    }

    public coaMgmtDTO regSpecCheck(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.regSpecCheck(coaMgmtDTO);
    }

    public  Map<String, Object> regCheck(Map<String, Object> parameterMap) {
        return coaMgmtRepository.regCheck(parameterMap);
    }

    public  Map<String, Object> regSpecCheck(Map<String, Object> parameterMap) {
        return coaMgmtRepository.regSpecCheck(parameterMap);
    }


    public String getStatusCOAMasterByPK(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.getStatusCOAMasterByPK(coaMgmtDTO);
    }

    public coaMgmtDTO getMaterial(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.getMaterial(coaMgmtDTO);
    }

    public LinkedHashMap<String,Object> getMaterial(Map<String, Object> parameterMap) {
        return coaMgmtRepository.getMaterial(parameterMap);
    }

    public coaMgmtDTO interfaceLimsCOAMasterData(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.interfaceLimsCOAMasterData(coaMgmtDTO);
    }

    public List<coaMgmtDTO> interfaceLimsCOADetailData(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.interfaceLimsCOADetailData(coaMgmtDTO);
    }



    public int interfaceCOAMaster(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.interfaceCOAMaster(coaMgmtDTO);
    }

    public int interfaceCOADetail(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.interfaceCOADetail(coaMgmtDTO);
    }


    public coaMgmtDTO interfaceDqmsCOAMasterData(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.interfaceDqmsCOAMasterData(coaMgmtDTO);
    }

    public List<coaMgmtDTO> interfaceDqmsCOADetailData(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.interfaceDqmsCOADetailData(coaMgmtDTO);
    }

    public int interfaceCOAProcedure(String DB_LINK_TARGET_APPLY) {
        return coaMgmtRepository.interfaceCOAProcedure(DB_LINK_TARGET_APPLY);
    }

    public int insertCOAListDqms(List<coaMgmtDTO> masterList , List<coaMgmtDTO> detailList ) {
        //테이블 또는 뷰가 존재하지 않습니다
        int testSeq = 0 ;
        for (int i = 0 ; i < masterList.size() ; i ++) {
          //  coaMgmtRepository.interfaceDqmsCOAMaster(masterList.get(i));
            testSeq++;

        }
        //테이블 또는 뷰가 존재하지 않습니다
        for (int i = 0 ; i < detailList.size() ; i ++) {
            //coaMgmtRepository.interfaceDqmsCOADetail(detailList.get(i));

            testSeq++;
        }

        return  testSeq ;
    }


    //메일 발송자 가져오기
    public List<HashMap> getEmailTargetUser(Map<String, Object> params) {
        return coaMgmtRepository.getEmailTargetUser(params);
    }


    public int updateCOAStatus(coaMgmtDTO coaMgmtDTO) {
        return coaMgmtRepository.updateCOAStatus(coaMgmtDTO);
    }


    public int insertCOADFile(Map<String, Object> parameterMap) {
        return coaMgmtRepository.insertCOADFile(parameterMap);
    }

    public List<LinkedHashMap<String,Object>> getSpecList(Map<String, Object> parameterMap) {
        return coaMgmtRepository.getSpecList(parameterMap);
    }


    public int getExistCount(Map<String, Object> parameterMap) {
        return coaMgmtRepository.getExistCount(parameterMap);
    }

    public Object insertCOAMaster(Map<String, Object> parameterMap) {
        return coaMgmtRepository.insertCOAMaster(parameterMap);
    }

    public Object insertCOADetail(Map<String, Object> parameterMap) {
        return coaMgmtRepository.insertCOADetail(parameterMap);
    }

    public String parseDate(String mfDate) {
        return coaMgmtRepository.parseDate(mfDate);
    }

}
