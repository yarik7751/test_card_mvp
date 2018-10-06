package by.yarik.task_mvp_credit_card.ui.text.watcher;

import android.text.Editable;
import android.text.TextWatcher;

public class MaskWatcher implements TextWatcher {
    private boolean running = false;
    private boolean deleting = false;
    private final String mask;

    public MaskWatcher(String mask) {
        this.mask = mask;
    }

    public static MaskWatcher buildCpf() {
        return new MaskWatcher("###.###.###-##");
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
        deleting = count > after;
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (running || deleting) return;
        if(editable.length() == 0) return;

        running = true;

        int editableLength = editable.length();
        if (editableLength < mask.length()) {
            if (mask.charAt(editableLength) != '#') {
                editable.append(mask.charAt(editableLength));
            } else if (mask.charAt(editableLength - 1) != '#') {
                editable.insert(editableLength - 1, mask, editableLength - 1, editableLength);
            }
        }

        running = false;
    }
}
