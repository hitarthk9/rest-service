
package com.iexceed.tools.dto;

import java.util.HashMap;
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
    "error",
    "extracted_entities",
    "extracted_objects",
    "status"
})
@Generated("jsonschema2pojo")
public class OCRResponse {

    @Override
	public String toString() {
		return "OCRResponse [error=" + error + ", extractedEntities=" + extractedEntities + ", extractedObjects="
				+ extractedObjects + ", status=" + status + ", additionalProperties=" + additionalProperties + "]";
	}

	@JsonProperty("error")
    private Error error;
    @JsonProperty("extracted_entities")
    private Object extractedEntities;
    @JsonProperty("extracted_objects")
    private Object extractedObjects;
    @JsonProperty("status")
    private Boolean status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("error")
    public Error getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(Error error) {
        this.error = error;
    }

    @JsonProperty("extracted_entities")
    public Object getExtractedEntities() {
        return extractedEntities;
    }

    @JsonProperty("extracted_entities")
    public void setExtractedEntities(Object extractedEntities) {
        this.extractedEntities = extractedEntities;
    }

    @JsonProperty("extracted_objects")
    public Object getExtractedObjects() {
        return extractedObjects;
    }

    @JsonProperty("extracted_objects")
    public void setExtractedObjects(Object extractedObjects) {
        this.extractedObjects = extractedObjects;
    }

    @JsonProperty("status")
    public Boolean getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Boolean status) {
        this.status = status;
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
