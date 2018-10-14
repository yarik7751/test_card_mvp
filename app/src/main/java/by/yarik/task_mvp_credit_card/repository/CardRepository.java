package by.yarik.task_mvp_credit_card.repository;

import android.os.Handler;

import java.util.concurrent.TimeUnit;

import by.yarik.task_mvp_credit_card.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.view.card.model.CardModel;

public class CardRepository {

    private static final long REQUEST_TEST_DURATION = 5;

    private static CardRepository cardRepository;
    public static CardRepository getInstance() {
        if(cardRepository == null) {
            cardRepository = new CardRepository();
        }
        return cardRepository;
    }

    public static final String TEST_VALUE = "18";

    public void boundCardNumber(CardModel cardModel, Handler handler) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(REQUEST_TEST_DURATION);
                @DecisionType int result = cardModel.getNumber().contains(TEST_VALUE) ?
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
}
