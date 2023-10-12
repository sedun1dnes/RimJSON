package ru.mirea.mitina.rim;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episode {
    public void Episode(){}
    public void Episode(int id, String name, List<String> characters){
        this.id = id;
        this.name = name;
        this.characters = characters;
    }
    @JsonProperty("id")
    int id;
    @JsonProperty("name")
    String name;
    @JsonProperty("characters")
    List<String> characters;
    public int getId(){ return id; }
    public String getTitle(){return name;}
    public int getAmountOfCharacters(){return characters.size();}
}
