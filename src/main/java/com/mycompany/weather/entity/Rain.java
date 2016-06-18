
package com.mycompany.weather.entity;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "1h"
})
public class Rain {

    @JsonProperty("1h")
    private Double _1h;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rain() {
    }

    /**
     * 
     * @param _1h
     */
    public Rain(Double _1h) {
        this._1h = _1h;
    }

    /**
     * 
     * @return
     *     The _1h
     */
    @JsonProperty("1h")
    public Double get1h() {
        return _1h;
    }

    /**
     * 
     * @param _1h
     *     The 1h
     */
    @JsonProperty("1h")
    public void set1h(Double _1h) {
        this._1h = _1h;
    }

    public Rain with1h(Double _1h) {
        this._1h = _1h;
        return this;
    }

}
