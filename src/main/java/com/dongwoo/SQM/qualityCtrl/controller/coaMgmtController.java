package com.dongwoo.SQM.qualityCtrl.controller;

import com.dongwoo.SQM.config.security.UserCustom;
import com.dongwoo.SQM.qualityCtrl.dto.coaMgmtDTO;
import com.dongwoo.SQM.qualityCtrl.service.coaMgmtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class coaMgmtController {

    private final coaMgmtService coaMgmtService;


    @GetMapping("/admin/qualityCtrl/coaMgmt")
    public String coaList(Model model) {
        //등록일  // 기본값 오늘날짜. sStartDate

        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String sStartDate = today.format(formatter);

        model.addAttribute("sStartDate", sStartDate);
        return "coaMgmt/coaList";
    }


    //COA LIST 검색
    @PostMapping("/admin/qualityCtrl/getCOAList")
    public ResponseEntity<?> getcoaList(@RequestBody coaMgmtDTO coaMgmtdto) {
        try {
            System.out.println("Received scoreMgmtDTO: " + coaMgmtdto);

//            reqParam.put("TOKEN_USER_ID", tokenInfo.get("USER_ID"));
//            reqParam.put("TOKEN_USER_TYPE", tokenInfo.get("USER_TYPE"));
//            reqParam.put("TOKEN_USER_LANG", tokenInfo.get("USER_LANG"));
//            reqParam.put("TOKEN_SITE_ID", tokenInfo.get("SITE_ID"));

            //로그인 사용자 정보
            UserCustom user = (UserCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String user_gubun = user.getUSER_GUBUN();
            String user_id = user.getUsername();


            coaMgmtdto.setTOKEN_USER_TYPE("AU");   //user_gubun :  관리자 , 사용자 권한 구분 확인
            coaMgmtdto.setTOKEN_USER_LANG("KR");   //언어 설정 확인.
            coaMgmtdto.setTOKEN_USER_ID("tykkim@lg.com"); //user_id 유저 매핑 해야됨.   test ===  >   tester  ,tykkim@lg.com


//            String vendorNameStr = (String) reqParam.get("vendorName");
//            List<String> vendorNameList = new ArrayList<String>();
//
//            if (!StringUtils.isEmpty(vendorNameStr)) {
//                if (vendorNameStr.indexOf("|") > -1) {
//                    String[] vendorNameArr = vendorNameStr.split("|");
//                    for (int i = 0 ; i < vendorNameArr.length ; i++) {
//                        vendorNameList.add(vendorNameArr[i]);
//                    }
//                    coaMgmtdto.setvendorNameList(vendorNameList);
//                }
//            }


//            public int deleteCompanyUser(String comCode,int useridx , List<Integer> companyUseridxList) {
//                Map<String, Object> params = new HashMap<>();
//                params.put("COM_CODE", comCode);
//                params.put("USER_IDX", useridx);
//                params.put("list", companyUseridxList);
//                return sql.delete("Member.deleteUserinfoCompanyUser", params);
//            }
//
//             <delete id="deleteUserinfoCompanyUser" parameterType="map">
//                    DELETE FROM SC_USER_INFO_COMPANY_USER
//            WHERE COM_CODE = #{COM_CODE} AND USER_IDX =#{USER_IDX}
//            AND COM_USER_IDX NOT IN
//        <foreach collection="list" item="COM_USER_IDX" open="(" separator="," close=")">
//            #{COM_USER_IDX}
//        </foreach>
//    </delete>


            List<coaMgmtDTO> coaList = coaMgmtService.getCOAList(coaMgmtdto);

            return ResponseEntity.ok(coaList);

        } catch (Exception e) {
            System.out.println("검색 에러!!!: " + e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\": \"서버 오류 발생\"}");
        }
    }













    @GetMapping("/user/qualityCtrl/scoreMgmt")
    public String getMain(Model model) {
        return "scoreMgmt/main";
    }
}