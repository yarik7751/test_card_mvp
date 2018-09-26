package by.yarik.task_mvp_credit_card.screens.decision;

import android.view.View;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.screens.BaseFragment;

public class DecisionFragment extends BaseFragment<IDecisionPresenter> implements IDecisionView {
    @Override
    public int onLayoutId() {
        return R.layout.fragment_decision;
    }

    @Override
    public View onCreateViewFragment(View view) {
        return view;
    }
}
