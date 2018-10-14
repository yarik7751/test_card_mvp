package by.yarik.task_mvp_credit_card.components.ui.text.mask;

import android.widget.EditText;

import by.yarik.task_mvp_credit_card.components.ui.text.watcher.MaskWatcher;

public class CardDateMask {

    private static final String FORMAT = "##/##";

    private EditText editText;

    public CardDateMask(EditText editText) {
        this.editText = editText;
        editText.addTextChangedListener(new MaskWatcher(FORMAT));
    }
}
