package model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Step {

    private Integer id; //уникальный идентификатор
    private String question; // текст вопроса/описание локации
    private List<Choice> choices; // список варианта выбора

}
