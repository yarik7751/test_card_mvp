package by.yarik.task_mvp_credit_card.components.pojo;

import by.yarik.task_mvp_credit_card.components.anotation.DecisionType;

public class BoundCardNumberResponse {

    @DecisionType
    int result;

    public BoundCardNumberResponse(int result) {
        this.result = result;
    }

    @DecisionType
    public int getResult() {
        return result;
    }

    public void setResult(@DecisionType int result) {
        this.result = result;
    }
}
