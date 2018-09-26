package by.yarik.task_mvp_credit_card.screens;

public class BasePresenter<T extends IBaseView> {

    protected T view;

    public T getView() {
        return view;
    }
}
