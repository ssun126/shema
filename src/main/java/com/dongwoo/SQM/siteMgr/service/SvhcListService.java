package com.dongwoo.SQM.siteMgr.service;

import com.dongwoo.SQM.siteMgr.dto.SvhcListDTO;
import com.dongwoo.SQM.siteMgr.repository.SvhcListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SvhcListService {

    @Value("${spring.datasource.url}")
    private String jdbcURl;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    private final SvhcListRepository svhcListRepository;
    public List<SvhcListDTO> findAll(){
        return svhcListRepository.findAll();
    }

    public void deletAll(){
        svhcListRepository.deletAll();
    }

    public void insert_svhcBulk(List<SvhcListDTO> svhcListDTOList) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        log.info("test11111111111111111111111");

        try{
            String sql  = "INSERT INTO SC_SVHC_DATA(SVHC_IDX,SVHC_NUM,SVHC_NAME,SVHC_CASNUM, SVHC_EUNUM) VALUES (?,?,?,?,?) ";
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(jdbcURl,username,password);
            conn.setAutoCommit(false);
            pstmt = conn.prepareStatement(sql);
            log.info("test2222222222222");
            int count = 0;

            for(SvhcListDTO dto : svhcListDTOList){
                log.info("test2-1");
                count++;
                pstmt.setInt(1,dto.getSVHC_IDX());
                pstmt.setString(2,dto.getSVHC_NUM());
                pstmt.setString(3,dto.getSVHC_NAME());
                pstmt.setString(4,dto.getSVHC_CASNUM());
                pstmt.setString(5,dto.getSVHC_EUNUM());
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

    public String uploadFileData(String partcode, MultipartFile fileInfo){
        String sUrl = "/"+partcode+"/";
        String filePath = "";

        try{
            String fileName = fileInfo.getOriginalFilename();
            Path path = Paths.get("./uploads"+sUrl+fileName);
            Files.createDirectories((path.getParent()));
            fileInfo.transferTo(path);
            //sampleFileDTOList.add(sampleFileDTO);

            filePath ="./uploads"+sUrl;

        }catch (IOException e){
            e.printStackTrace();
            //model.addAttribute("message","파일업로드중 오류 : " + file.getOriginalFilename());

        }

        return filePath;
    }
}
