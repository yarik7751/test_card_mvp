package by.yarik.task_mvp_credit_card.presenter;

import by.yarik.task_mvp_credit_card.repository.CardRepository;
import by.yarik.task_mvp_credit_card.view.IBaseView;

public class BasePresenter<T extends IBaseView> {

    protected T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }
}
