package repository;

import model.Step;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class JsonQuestLoader {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Step> load(String path){
        File file = new File(path);
        return objectMapper.readValue(file,new TypeReference<List<Step>>(){});
    }

}
