package com.hellbean.booklord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData {
    @JsonProperty("DataAge")
    private int DataAge;

    @JsonProperty("Metros")
    private List<Metro> Metros;

    public ResponseData() {
    }


    public List<Metro> getMetros() {
        return Metros;
    }

    public void setMetros(List<Metro> metros) {
        Metros = metros;
    }

    public int getDataAge() {
        return DataAge;
    }

    public void setDataAge(int dataAge) {
        DataAge = dataAge;
    }
}
