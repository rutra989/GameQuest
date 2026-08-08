package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Choice {
    private String text; //текст кнопки
    private Integer nextStepId; // куда ведет выбор ответа

}
