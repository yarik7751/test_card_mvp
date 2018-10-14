package by.yarik.task_mvp_credit_card.repository;

import android.os.Handler;

import java.util.concurrent.TimeUnit;

import by.yarik.task_mvp_credit_card.components.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.view.card.model.CardModel;

public class CardRepository {

    public static final String TEST_VALUE = "18";
    public static final String FIRST_VISA_CHARSET = "4";
    private static final long REQUEST_TEST_DURATION = 5;

    private static CardRepository cardRepository;
    public static CardRepository getInstance() {
        if(cardRepository == null) {
            cardRepository = new CardRepository();
        }
        return cardRepository;
    }

    public void boundCardNumber(CardModel cardModel, Handler handler) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(REQUEST_TEST_DURATION);
                @DecisionType int result = isVisa(cardModel.getNumber()) ?
                        DecisionType.CONFIRM :
                        DecisionType.CANCEL;
                handler.sendEmptyMessage(result);
            } catch (InterruptedException e) {
                handler.sendEmptyMessage(DecisionType.ERROR);
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private boolean isVisa(String cardNumber) {
        return cardNumber.substring(0, 1).equalsIgnoreCase(FIRST_VISA_CHARSET);
    }
}
