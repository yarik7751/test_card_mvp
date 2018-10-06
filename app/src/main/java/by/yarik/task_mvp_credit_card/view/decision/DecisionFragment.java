package by.yarik.task_mvp_credit_card.view.decision;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.view.BaseFragment;
import by.yarik.task_mvp_credit_card.presenter.decision.DecisionPresenter;
import by.yarik.task_mvp_credit_card.presenter.decision.IDecisionPresenter;

public class DecisionFragment extends BaseFragment<IDecisionPresenter> implements IDecisionView {

    private static final String ARGS_TYPE = "ARGS_TYPE";

    protected ImageView ivDecisionImage;
    protected TextView tvDecisionText;

    public static DecisionFragment newInstance(int type) {
        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_TYPE, type);

        DecisionFragment fragment = new DecisionFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int onLayoutId() {
        return R.layout.fragment_decision;
    }

    @Override
    public View onCreateViewFragment(View view) {
        initViews(view);
        presenter = new DecisionPresenter(this);

        int type = getArguments().getInt(ARGS_TYPE);
        getPresenter().setDecisionInfo(type);
        return view;
    }

    private void initViews(View view) {
        ivDecisionImage = view.findViewById(R.id.iv_decision_image);
        tvDecisionText = view.findViewById(R.id.tv_decision_text);
    }

    @Override
    public void setConfirmInfo() {
        ivDecisionImage.setImageResource(R.mipmap.ic_ok);
        tvDecisionText.setText(R.string.title_decision_ok);
    }

    @Override
    public void setCancelInfo() {
        ivDecisionImage.setImageResource(R.mipmap.ic_cancel);
        tvDecisionText.setText(R.string.title_decision_cancel);
    }
}
