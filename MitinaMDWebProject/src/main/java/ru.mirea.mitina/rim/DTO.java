package ru.mirea.mitina.rim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DTO {
    public void DTO(){}
    public void DTO(List<Episode> episodes){
        this.episodes = episodes;
    }
    @JsonProperty("results")
    private List<Episode> episodes;

    public List<Episode> getEpisodes(){
        return episodes;
    }
}
