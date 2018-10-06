package by.yarik.task_mvp_credit_card.repository;

import by.yarik.task_mvp_credit_card.model.CardModel;

public class CardRepository {

    public static final String TEST_VALUE = "18";

    public boolean boundCardNumber(CardModel cardModel) {
        return cardModel.getNumber().contains(TEST_VALUE);
    }
}
