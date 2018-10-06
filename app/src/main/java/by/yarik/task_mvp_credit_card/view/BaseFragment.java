package by.yarik.task_mvp_credit_card.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import by.yarik.task_mvp_credit_card.presenter.IBasePresenter;

public abstract class BaseFragment<T extends IBasePresenter> extends Fragment {

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
        return view;
    }
}
