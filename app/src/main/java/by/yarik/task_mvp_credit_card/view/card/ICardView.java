package by.yarik.task_mvp_credit_card.view.card;

import android.support.annotation.StringRes;
import android.view.View;

import by.yarik.task_mvp_credit_card.screens.IBaseView;

public interface ICardView extends IBaseView {
    void setNumberError(@StringRes int error);
    void setHolderError(@StringRes int error);
    void setDateError(@StringRes int error);
    void setCvvError(@StringRes int error);
}
