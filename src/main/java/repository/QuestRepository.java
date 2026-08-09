package repository;

import model.Step;

public interface QuestRepository {
    Step findById(int id);
}
