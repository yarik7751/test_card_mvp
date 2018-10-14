package by.yarik.task_mvp_credit_card;

import android.app.Application;

import by.yarik.task_mvp_credit_card.repository.CardRepository;

public class CardApplication extends Application {

    @Override
    public void onCreate() {
        CardRepository.getInstance();
        super.onCreate();
    }
}
