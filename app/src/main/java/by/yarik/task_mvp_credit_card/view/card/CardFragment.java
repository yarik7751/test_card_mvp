package by.yarik.task_mvp_credit_card.view.card;

import android.support.annotation.StringRes;
import android.view.View;
import android.widget.Button;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.activity.MainActivity;
import by.yarik.task_mvp_credit_card.view.decision.DecisionFragment;
import by.yarik.task_mvp_credit_card.presenter.card.CardPresenter;
import by.yarik.task_mvp_credit_card.view.BaseFragment;
import by.yarik.task_mvp_credit_card.presenter.card.ICardPresenter;
import by.yarik.task_mvp_credit_card.ui.EditTextView;
import by.yarik.task_mvp_credit_card.ui.text.mask.CardDateMask;

public class CardFragment extends BaseFragment<ICardPresenter> implements ICardView, EditTextView.OnTextChangeListener {

    protected EditTextView etCardNumber;
    protected EditTextView etCardHolder;
    protected EditTextView etCardDate;
    protected EditTextView etCardCvv;
    protected Button btnSendCardData;

    private CardDateMask cardDateMask;

    public static CardFragment newInstance() {
        CardFragment fragment = new CardFragment();
        return fragment;
    }

    @Override
    public int onLayoutId() {
        return R.layout.fragment_card;
    }

    @Override
    public View onCreateViewFragment(View rootView) {
        presenter = new CardPresenter(this);
        initUi(rootView);
        return rootView;
    }

    private void initUi(View rootView) {
        initViews(rootView);
        setTextListener();

        btnSendCardData.setOnClickListener(view -> {
            getPresenter().onSend();
        });
    }

    private void initViews(View rootView) {
        etCardNumber = rootView.findViewById(R.id.et_card_number);
        etCardHolder = rootView.findViewById(R.id.et_card_holder);
        etCardDate = rootView.findViewById(R.id.et_card_date);
        etCardCvv = rootView.findViewById(R.id.et_card_cvv);
        btnSendCardData = rootView.findViewById(R.id.btn_send_card_data);
    }

    private void setTextListener() {
        etCardNumber.setOnTextChangeListener(this);
        etCardHolder.setOnTextChangeListener(this);
        etCardDate.setOnTextChangeListener(this);
        etCardCvv.setOnTextChangeListener(this);

        cardDateMask = new CardDateMask(etCardDate.getEditText());
    }

    @Override
    public void setNumberError(@StringRes int error) {
        setError(etCardNumber, error);
    }

    @Override
    public void setHolderError(@StringRes int error) {
        setError(etCardHolder, error);
    }

    @Override
    public void setDateError(@StringRes int error) {
        setError(etCardDate, error);
    }

    @Override
    public void setCvvError(@StringRes int error) {
        setError(etCardCvv, error);
    }

    private void setError(EditTextView editTextView, @StringRes int error) {
        if(error == 0) {
            editTextView.setError(null);
        } else {
            editTextView.setError(getString(error));
        }
    }

    @Override
    public void openDecisionFragment(int type) {
        ((MainActivity) getActivity()).setCurrentFragment(DecisionFragment.newInstance(type), true);
    }

    /**
     * EditTextView.OnTextChangeListener - card data
     * @param view
     * @param data
     */
    @Override
    public void onChange(View view, String data) {
        getPresenter().setCardData(view.getId(), data);
    }
}
