package by.yarik.task_mvp_credit_card.presenter.card;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.model.CardModel;
import by.yarik.task_mvp_credit_card.screens.BasePresenter;
import by.yarik.task_mvp_credit_card.view.card.ICardView;

public class CardPresenter extends BasePresenter<ICardView> implements ICardPresenter {

    private CardModel cardModel;

    public CardPresenter(ICardView view) {
        super(view);
        cardModel = new CardModel();
    }

    @Override
    public void setCardNumber(String number) {
        cardModel.setNumber(number);
        if(!cardModel.isValidNumber()) {
            getView().setNumberError(R.string.default_error);
        }
    }

    @Override
    public void setCardHolder(String holder) {
        cardModel.setHolder(holder);
        if(!cardModel.isValidHolder()) {
            getView().setHolderError(R.string.default_error);
        }
    }

    @Override
    public void setCardDate(String date) {
        cardModel.setDate(date);
        if(!cardModel.isValidDate()) {
            getView().setDateError(R.string.default_error);
        }
    }

    @Override
    public void setCardCvv(String cvv) {
        cardModel.setCvv(cvv);
        if(!cardModel.isValidCvv()) {
            getView().setCvvError(R.string.default_error);
        }
    }

    @Override
    public void setCardData(int id, String data) {
        switch (id) {
            case R.id.et_card_number:
                setCardNumber(data);
                break;

            case R.id.et_card_holder:
                setCardHolder(data);
                break;

            case R.id.et_card_date:
                setCardDate(data);
                break;

            case R.id.et_card_cvv:
                setCardCvv(data);
                break;
        }
    }
}
