package by.yarik.task_mvp_credit_card.repository.card;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;

import java.util.concurrent.TimeUnit;

import by.yarik.task_mvp_credit_card.components.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.components.anotation.RequestsCode;
import by.yarik.task_mvp_credit_card.components.pojo.BoundCardNumberResponse;
import by.yarik.task_mvp_credit_card.presenter.card.ICardPresenter;
import by.yarik.task_mvp_credit_card.view.card.model.CardModel;

public class CardRepository implements ICardRepository {

    public static final String TEST_VALUE = "18";
    public static final String FIRST_VISA_CHARSET = "4";
    private static final long REQUEST_TEST_DURATION = 5;

    private ICardPresenter presenter;

    public CardRepository(ICardPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void boundCardNumber(String number) {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(REQUEST_TEST_DURATION);
                @DecisionType int result = isVisa(number) ?
                        DecisionType.CONFIRM :
                        DecisionType.CANCEL;


                handler.sendMessage(handler.obtainMessage(RequestsCode.BOUND_CARD_NUMBER, new BoundCardNumberResponse(result)));
            } catch (InterruptedException e) {
                handler.sendMessage(handler.obtainMessage(RequestsCode.BOUND_CARD_NUMBER, new BoundCardNumberResponse(DecisionType.ERROR)));
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private boolean isVisa(String cardNumber) {
        return cardNumber.substring(0, 1).equalsIgnoreCase(FIRST_VISA_CHARSET);
    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case RequestsCode.BOUND_CARD_NUMBER:
                    presenter.boundCardNumberResult((BoundCardNumberResponse) msg.obj);
                    break;
            }
        }
    };
}
