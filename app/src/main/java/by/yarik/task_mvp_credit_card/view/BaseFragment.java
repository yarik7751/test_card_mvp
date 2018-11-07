package by.yarik.task_mvp_credit_card.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.components.anotation.ProgressDialogState;
import by.yarik.task_mvp_credit_card.presenter.IBasePresenter;

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment implements IBaseView {

    private static final String PROGRESS_BAR_STATE = "PROGRESS_BAR_STATE";

    protected ProgressDialog progressDialog;
    protected T presenter;

    public T getPresenter() {
        return presenter;
    }

    public abstract int onLayoutId();

    public abstract View onCreateViewFragment(View view);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(onLayoutId(), container, false);
        view = onCreateViewFragment(view);
        setRetainInstance(true);

        initProgressDialog();
        if(savedInstanceState != null && savedInstanceState.getInt(PROGRESS_BAR_STATE) == ProgressDialogState.SHOW) {
            showProcess();
        }
        return view;
    }

    private void initProgressDialog() {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage(getString(R.string.wait));
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(PROGRESS_BAR_STATE, progressDialog.isShowing() ? ProgressDialogState.SHOW : ProgressDialogState.HIDE);
    }

    @Override
    public void showProcess() {
        progressDialog.show();
    }

    @Override
    public void hideProcess() {
        progressDialog.hide();
    }
}
