package com.dongwoo.SQM.partMgmt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PartDetailSvhcDTO {

    @JsonProperty("SVHC_IDX")
    private String SVHC_IDX;
    @JsonProperty("PM_IDX")
    private String PM_IDX;
    @JsonProperty("DATA_GUBUN")
    private String DATA_GUBUN;
    @JsonProperty("CONFIRM_DATE")
    private String CONFIRM_DATE;
    @JsonProperty("FILE_PATH")
    private String FILE_PATH;
    @JsonProperty("FILE_NAME")
    private String FILE_NAME;
    @JsonProperty("APPLICABLE_NO")
    private String APPLICABLE_NO;

    @JsonProperty("WARRANTY_ITEM")
    private String WARRANTY_ITEM;

    @JsonProperty("INFO_FLAG")
    private String INFO_FLAG;


}