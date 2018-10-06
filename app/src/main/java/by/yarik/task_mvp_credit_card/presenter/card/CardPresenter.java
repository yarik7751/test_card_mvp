package by.yarik.task_mvp_credit_card.presenter.card;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.presenter.BasePresenter;
import by.yarik.task_mvp_credit_card.view.card.model.CardModel;
import by.yarik.task_mvp_credit_card.view.card.ICardView;

public class CardPresenter extends BasePresenter<ICardView> implements ICardPresenter {

    private CardModel cardModel;

    public CardPresenter(ICardView view) {
        super(view);
        cardModel = new CardModel();
        enabledButton();
    }

    @Override
    public void setCardNumber(String number) {
        cardModel.setNumber(number);
        if(!cardModel.isValidNumber()) {
            getView().setNumberError(R.string.default_error);
        } else {
            getView().setNumberError(0);
        }
    }

    @Override
    public void setCardHolder(String holder) {
        cardModel.setHolder(holder);
        if(!cardModel.isValidHolder()) {
            getView().setHolderError(R.string.default_error);
        } else {
            getView().setHolderError(0);
        }
    }

    @Override
    public void setCardDate(String date) {
        cardModel.setDate(date);
        if(!cardModel.isValidDate()) {
            getView().setDateError(R.string.default_error);
        } else {
            getView().setDateError(0);
        }
    }

    @Override
    public void setCardCvv(String cvv) {
        cardModel.setCvv(cvv);
        if(!cardModel.isValidCvv()) {
            getView().setCvvError(R.string.default_error);
        } else {
            getView().setCvvError(0);
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
        enabledButton();
    }

    private void enabledButton() {
        if(cardModel.isValid()) {
            getView().activeButton();
        } else {
            getView().disableButton();
        }
    }

    @Override
    public void onSend() {
        @DecisionType int type;
        if(cardRepository.boundCardNumber(cardModel)) {
            type = DecisionType.CONFIRM;
        } else {
            type = DecisionType.CANCEL;
        }
        getView().openDecisionFragment(type);
    }
}
