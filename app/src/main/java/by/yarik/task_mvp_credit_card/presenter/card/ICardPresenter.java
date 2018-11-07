package by.yarik.task_mvp_credit_card.presenter.card;

import by.yarik.task_mvp_credit_card.components.pojo.BoundCardNumberResponse;
import by.yarik.task_mvp_credit_card.presenter.IBasePresenter;

public interface ICardPresenter extends IBasePresenter {
    void setCardNumber(String number);

    void setCardHolder(String holder);

    void setCardDate(String date);

    void setCardCvv(String cvv);

    void setCardData(int id, String data);

    void onSend();

    void boundCardNumberResult(BoundCardNumberResponse response);
}
