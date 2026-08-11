package service;

import model.Choice;
import model.GameState;

public class GameProcess {

    private static final int LOSE_ID = 0;
    private static final int WIN_ID = 99;

    // процесс выбора
    public int processChoice(int nextStepId){
        return nextStepId;
    }

    //проверка на win/lose
    public GameResult checkResult(GameState gameState){
        if (gameState.getCurrentStepId() == LOSE_ID){
            return GameResult.LOSE;
        } else if (gameState.getCurrentStepId() == WIN_ID) {
            return GameResult.WIN;
        }else {
            return GameResult.CONTINUE;
        }
    }

    // обновление состояния
    public void updateState (GameState gameState, int choiceIndex){
    gameState.setCurrentStepId(choiceIndex);
    }
}
