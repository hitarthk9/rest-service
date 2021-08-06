
package com.iexceed.tools.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "document_type",
    "user_id",
    "document_id",
    "data_source",
    "data_preprocessed",
    "preprocessed_type",
    "device_type",
    "data_text",
    "data_cord",
    "addtional_param",
    "txn_id",
    "data_format",
    "data_base64"
})
@Generated("jsonschema2pojo")
public class OCRRequest {

    @JsonProperty("document_type")
    private String documentType;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("document_id")
    private String documentId;
    @JsonProperty("data_source")
    private String dataSource;
    @JsonProperty("data_preprocessed")
    private Boolean dataPreprocessed;
    @JsonProperty("preprocessed_type")
    private String preprocessedType;
    @JsonProperty("device_type")
    private String deviceType;
    @JsonProperty("data_text")
    private String dataText;
    @JsonProperty("data_cord")
    private String dataCord;
    @JsonProperty("addtional_param")
    private List<Object> addtionalParam = null;
    @JsonProperty("txn_id")
    private String txnId;
    @JsonProperty("data_format")
    private String dataFormat;
    @JsonProperty("data_base64")
    private String dataBase64;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("document_type")
    public String getDocumentType() {
        return documentType;
    }

    @JsonProperty("document_type")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    @JsonProperty("user_id")
    public String getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonProperty("document_id")
    public String getDocumentId() {
        return documentId;
    }

    @JsonProperty("document_id")
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @JsonProperty("data_source")
    public String getDataSource() {
        return dataSource;
    }

    @JsonProperty("data_source")
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty("data_preprocessed")
    public Boolean getDataPreprocessed() {
        return dataPreprocessed;
    }

    @JsonProperty("data_preprocessed")
    public void setDataPreprocessed(Boolean dataPreprocessed) {
        this.dataPreprocessed = dataPreprocessed;
    }

    @JsonProperty("preprocessed_type")
    public String getPreprocessedType() {
        return preprocessedType;
    }

    @JsonProperty("preprocessed_type")
    public void setPreprocessedType(String preprocessedType) {
        this.preprocessedType = preprocessedType;
    }

    @JsonProperty("device_type")
    public String getDeviceType() {
        return deviceType;
    }

    @JsonProperty("device_type")
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    @JsonProperty("data_text")
    public String getDataText() {
        return dataText;
    }

    @JsonProperty("data_text")
    public void setDataText(String dataText) {
        this.dataText = dataText;
    }

    @JsonProperty("data_cord")
    public String getDataCord() {
        return dataCord;
    }

    @JsonProperty("data_cord")
    public void setDataCord(String dataCord) {
        this.dataCord = dataCord;
    }

    @JsonProperty("addtional_param")
    public List<Object> getAddtionalParam() {
        return addtionalParam;
    }

    @JsonProperty("addtional_param")
    public void setAddtionalParam(List<Object> addtionalParam) {
        this.addtionalParam = addtionalParam;
    }

    @JsonProperty("txn_id")
    public String getTxnId() {
        return txnId;
    }

    @JsonProperty("txn_id")
    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    @JsonProperty("data_format")
    public String getDataFormat() {
        return dataFormat;
    }

    @JsonProperty("data_format")
    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
    }

    @JsonProperty("data_base64")
    public String getDataBase64() {
        return dataBase64;
    }

    @JsonProperty("data_base64")
    public void setDataBase64(String dataBase64) {
        this.dataBase64 = dataBase64;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
