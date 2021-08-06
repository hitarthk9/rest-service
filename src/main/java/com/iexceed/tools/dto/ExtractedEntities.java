
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
    "id_no",
    "name",
    "nationality"
})
@Generated("jsonschema2pojo")
public class ExtractedEntities {

    @JsonProperty("id_no")
    private List<String> idNo = null;
    @JsonProperty("name")
    private List<Object> name = null;
    @JsonProperty("nationality")
    private List<String> nationality = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id_no")
    public List<String> getIdNo() {
        return idNo;
    }

    @JsonProperty("id_no")
    public void setIdNo(List<String> idNo) {
        this.idNo = idNo;
    }

    @JsonProperty("name")
    public List<Object> getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(List<Object> name) {
        this.name = name;
    }

    @JsonProperty("nationality")
    public List<String> getNationality() {
        return nationality;
    }

    @JsonProperty("nationality")
    public void setNationality(List<String> nationality) {
        this.nationality = nationality;
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
