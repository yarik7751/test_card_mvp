package by.yarik.task_mvp_credit_card.presenter.decision;

import by.yarik.task_mvp_credit_card.components.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.presenter.BasePresenter;
import by.yarik.task_mvp_credit_card.view.decision.IDecisionView;

public class DecisionPresenter extends BasePresenter<IDecisionView> implements IDecisionPresenter {
    public DecisionPresenter(IDecisionView view) {
        super(view);
    }

    @Override
    public void setDecisionInfo(@DecisionType int type) {
        switch (type) {
            case DecisionType.CONFIRM:
                getView().setConfirmInfo();
                break;

            case DecisionType.CANCEL:
                getView().setCancelInfo();
                break;
        }
    }
}
