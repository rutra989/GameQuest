import model.Step;
import org.junit.jupiter.api.Test;
import repository.JsonQuestRepository;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Objects;

public class JsonQuestRepositoryTest {
    String path = Objects.requireNonNull(getClass().getClassLoader().getResource("quest.json")).getPath();

    @Test
    public void findById() throws IOException {
        JsonQuestRepository jsonQuestRepository = new JsonQuestRepository(path);
        Step step = jsonQuestRepository.findById(5);
        assertNotNull(step);
        assertEquals(5, step.getId());
    }

    @Test
    public void findByIdNotFound() throws IOException {
        JsonQuestRepository jsonQuestRepository = new JsonQuestRepository(path);
        Step step = jsonQuestRepository.findById(15);
        assertNull(step);
    }
}

