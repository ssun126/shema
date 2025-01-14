package com.dongwoo.SQM.siteMgr.service;

import com.dongwoo.SQM.siteMgr.dto.LabourItemDTO;
import com.dongwoo.SQM.siteMgr.repository.LabourItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LabourItemService {

    private final LabourItemRepository labourItemRepository;
    public List<LabourItemDTO> findAll(){
        return labourItemRepository.findAll();
    }

    public void deletAll(){
        labourItemRepository.deletAll();
    }

    public void insert_labourBulk(List<LabourItemDTO> labourItemDTOList) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        log.info("test11111111111111111111111");

        try{
            String sql  = "INSERT INTO SC_AUDIT_LABOUR_ITEM(PROVISION,AUDIT_ID,AUDIT_ITEM, AUDIT_DESC,AUDIT_CRITERIA,POINT_CRITERIA) VALUES (?,?,?,?,?,?) ";
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@CO-NB-21-014.covision.co.kr:1521/xe","c##NSQM","12345");
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            log.info("test2222222222222");
            int count = 0;

            for(LabourItemDTO dto : labourItemDTOList){
                log.info("test2-1");
                count++;

                pstmt.setString(1,dto.getPROVISION());
                pstmt.setString(2,dto.getAUDIT_ID());
                pstmt.setString(3,dto.getAUDIT_ITEM());
                pstmt.setString(4,dto.getAUDIT_DESC());
                pstmt.setString(5,dto.getAUDIT_CRITERIA());
                pstmt.setString(6,dto.getPOINT_CRITERIA());
                log.info("test2-2");
                pstmt.addBatch();
                pstmt.clearParameters();

                //100개 로우 쌓일 때마다 insert 시킨다. 메모리에 너무 많이 쌓이면 안됨
                if((count%100)==0){
                    pstmt.executeBatch();
                    pstmt.clearBatch();
                    conn.commit();
                }


            }
            log.info("test33333333333333333");

            pstmt.executeBatch();
            conn.commit();


        }catch (Exception e){
            log.info(e.toString());
            conn.rollback();
        }finally {
            log.info("test55555555555");
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();

        }
    }
}
