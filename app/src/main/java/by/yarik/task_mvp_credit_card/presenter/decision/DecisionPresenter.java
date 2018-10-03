package by.yarik.task_mvp_credit_card.presenter.decision;

import by.yarik.task_mvp_credit_card.screens.BasePresenter;
import by.yarik.task_mvp_credit_card.view.decision.IDecisionView;

public class DecisionPresenter extends BasePresenter<IDecisionView> implements IDecisionPresenter {
    public DecisionPresenter(IDecisionView view) {
        super(view);
    }
}
