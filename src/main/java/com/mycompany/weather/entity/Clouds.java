
package com.mycompany.weather.entity;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "all"
})
public class Clouds {

    @JsonProperty("all")
    private Long all;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Clouds() {
    }

    /**
     * 
     * @param all
     */
    public Clouds(Long all) {
        this.all = all;
    }

    /**
     * 
     * @return
     *     The all
     */
    @JsonProperty("all")
    public Long getAll() {
        return all;
    }

    /**
     * 
     * @param all
     *     The all
     */
    @JsonProperty("all")
    public void setAll(Long all) {
        this.all = all;
    }

    public Clouds withAll(Long all) {
        this.all = all;
        return this;
    }

}
