package by.yarik.task_mvp_credit_card.view.card;

import android.support.annotation.StringRes;

import by.yarik.task_mvp_credit_card.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.view.IBaseView;

public interface ICardView extends IBaseView {
    void setNumberError(@StringRes int error);

    void setHolderError(@StringRes int error);

    void setDateError(@StringRes int error);

    void setCvvError(@StringRes int error);

    void openDecisionFragment(@DecisionType int type);
}
