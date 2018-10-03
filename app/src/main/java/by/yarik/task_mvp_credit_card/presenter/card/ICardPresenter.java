package by.yarik.task_mvp_credit_card.presenter.card;

import by.yarik.task_mvp_credit_card.screens.IBasePresenter;

public interface ICardPresenter extends IBasePresenter {
    void setCardNumber(String number);
    void setCardHolder(String holder);
    void setCardDate(String date);
    void setCardCvv(String cvv);

    void setCardData(int id, String data);
}
