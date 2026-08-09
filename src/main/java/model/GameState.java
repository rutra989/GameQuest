package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameState {
    private String playerName; // имя пользователя
    private Integer playerId; // идентификатор пользователя
    private Integer currentStepId; // текущее место положении

}
