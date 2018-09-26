package by.yarik.task_mvp_credit_card.screens.card;

import android.view.View;
import android.widget.Button;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.screens.BaseFragment;
import by.yarik.task_mvp_credit_card.ui.EditTextView;
import by.yarik.task_mvp_credit_card.ui.text.mask.CardDateMask;

public class CardFragment extends BaseFragment<ICardPresenter> implements ICardView {

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
        initUi(rootView);

        btnSendCardData.setOnClickListener(view -> {

        });

        cardDateMask = new CardDateMask(etCardDate.getEditText());
        return rootView;
    }

    private void initUi(View rootView) {
        etCardNumber = rootView.findViewById(R.id.et_card_number);
        etCardHolder = rootView.findViewById(R.id.et_card_holder);
        etCardDate = rootView.findViewById(R.id.et_card_date);
        etCardCvv = rootView.findViewById(R.id.et_card_cvv);
        btnSendCardData = rootView.findViewById(R.id.btn_send_card_data);
    }
}
