package com.dongwoo.SQM.system.repository;

import com.dongwoo.SQM.system.dto.LoginDTO;
import com.dongwoo.SQM.system.dto.MenuDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class LoginRepository {
    private final SqlSessionTemplate sql;

    public int save(LoginDTO loginDTO) {
       // System.out.println("memberDTO = " + loginDTO);
        return sql.insert("Login.save", loginDTO);
    }

    public LoginDTO login(LoginDTO loginDTO) {
        return sql.selectOne("Login.login", loginDTO);
    }

    public List<LoginDTO> findAll() {
        return sql.selectList("Login.findAll");
    }

    public LoginDTO findById(String USER_ID) {
        return sql.selectOne("Login.findById", USER_ID);
    }

    public LoginDTO findByIdUsePass(String USER_ID) {
        return sql.selectOne("Login.findByIdUsePass", USER_ID);
    }

    public void delete(String USER_ID) {
        sql.delete("Login.delete", USER_ID);
    }

    public LoginDTO findByLoginEmail(String loginEmail) {
        return sql.selectOne("Login.findByLoginEmail", loginEmail);
    }

    public Map<String, Object> findDW(String USER_ID, String EMAIL) {
        Map<String, Object> params = new HashMap<>();
        params.put("USER_ID", USER_ID);
        params.put("EMAIL", EMAIL);

        return sql.selectOne("Login.findDW", params);
    }

    public Map<String, Object> findCompanyID(String NAME, String EMAIL) {
        Map<String, Object> params = new HashMap<>();
        params.put("NAME", NAME);
        params.put("EMAIL", EMAIL);

        return sql.selectOne("Login.findCompanyID", params);
    }

    public Map<String, Object> findCompanyPW(String USER_ID, String NAME, String EMAIL) {
        Map<String, Object> params = new HashMap<>();
        params.put("USER_ID", USER_ID);
        params.put("NAME", NAME);
        params.put("EMAIL", EMAIL);

        return sql.selectOne("Login.findCompanyPW", params);
    }

    public void updateUserPWD(int USER_IDX, String USER_PWD) {
        Map<String, Object> params = new HashMap<>();
        params.put("USER_IDX", USER_IDX);
        params.put("USER_PWD", USER_PWD);

        sql.update("Login.updateUserPWD", params);
    }

    public LoginDTO findByLoginName(String loginName) {
        return sql.selectOne("Login.findByLoginName", loginName);
    }

    public LoginDTO findByLoginId(String loginId) {
        return sql.selectOne("Login.findByLoginId", loginId);
    }

    public int update(LoginDTO loginDTO) {
        return sql.update("Login.update", loginDTO);
    }

    public List<MenuDTO>  findUserMenu(LoginDTO loginDTO) {
        return sql.selectList("Login.findUserMenu", loginDTO);
    }

}
