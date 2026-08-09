package repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import model.Step;

import java.io.IOException;
import java.util.List;

@Getter
public class JsonQuestRepository implements QuestRepository {

    List<Step> steps;

    public JsonQuestRepository(String path) throws IOException {
        this.steps = new JsonQuestLoader().load(path);
    }

    @Override
    public Step findById(int id) {

        return steps.stream().filter(n ->n.getId() == id).findFirst().orElse(null);
    }
}
