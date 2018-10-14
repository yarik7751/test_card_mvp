package by.yarik.task_mvp_credit_card.presenter.decision;

import by.yarik.task_mvp_credit_card.components.anotation.DecisionType;
import by.yarik.task_mvp_credit_card.presenter.IBasePresenter;

public interface IDecisionPresenter extends IBasePresenter {
    void setDecisionInfo(@DecisionType int type);
}
