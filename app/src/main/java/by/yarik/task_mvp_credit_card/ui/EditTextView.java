package by.yarik.task_mvp_credit_card.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import by.yarik.task_mvp_credit_card.R;

public class EditTextView extends LinearLayout {

    private static final int MAX_EDIT_TEXT_LENGTH = 255;

    protected AutoCompleteTextView editText;
    protected TextView errorTextView;

    protected OnTextChangeListener onTextChangeListener;

    private int defaultTextSize;
    private int defaultTextErrorSize;
    private boolean allCaps;

    public EditTextView(Context context) {
        this(context, null);
    }

    public EditTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EditTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public EditTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        defaultTextSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_14);
        defaultTextErrorSize = context.getResources().getDimensionPixelSize(R.dimen.text_size_12);

        View rootView = inflateView(context);
        initUi(rootView);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                getDefaultStylable(),
                0,
                0
        );

        try {
            initEditTextAttrs(context, typedArray);
            initErrorTextViewAttrs(context, typedArray);;
        } finally {
            typedArray.recycle();
        }
    }

    private void initEditTextAttrs(Context context, TypedArray typedArray) {
        editText.setText(typedArray.getText(R.styleable.EditTextViewDeclareStylable_android_text));

        editText.setTextColor(typedArray.getColor(
                R.styleable.EditTextViewDeclareStylable_android_textColor,
                context.getResources().getColor(android.R.color.black)));

        editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(
                R.styleable.EditTextViewDeclareStylable_android_textSize,
                defaultTextSize));

        editText.setInputType(typedArray.getInt(R.styleable.EditTextViewDeclareStylable_android_inputType,
                InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS));

        allCaps = typedArray.getBoolean(R.styleable.EditTextViewDeclareStylable_allCaps, false);
        if(allCaps) {
            editText.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
        }

        if(typedArray.hasValue(R.styleable.EditTextViewDeclareStylable_android_maxLength)) {
            editText.setFilters(getLenghtFilter(
                    typedArray.getInt(R.styleable.EditTextViewDeclareStylable_android_maxLength,
                            MAX_EDIT_TEXT_LENGTH)));
        }

        if(typedArray.hasValue(R.styleable.EditTextViewDeclareStylable_android_digits)) {
            editText.setKeyListener(DigitsKeyListener.getInstance(typedArray.getString(R.styleable.EditTextViewDeclareStylable_android_digits)));
        }

        editText.setGravity(typedArray.getInt(R.styleable.EditTextViewDeclareStylable_textGravity, Gravity.LEFT));
    }

    private InputFilter[] getLenghtFilter(int maxLength) {
        return new InputFilter[] {new InputFilter.LengthFilter(maxLength)};
    }

    private void initErrorTextViewAttrs(Context context, TypedArray typedArray) {
        errorTextView.setText(typedArray.getText(R.styleable.EditTextViewDeclareStylable_textError));

        errorTextView.setTextColor(typedArray.getColor(
                R.styleable.EditTextViewDeclareStylable_textErrorColor,
                context.getResources().getColor(android.R.color.holo_red_light)));

        errorTextView.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(
                R.styleable.EditTextViewDeclareStylable_textErrorSize,
                defaultTextErrorSize));
    }

    private void initUi(View rootView) {
        editText = rootView.findViewById(R.id.edit_text);
        errorTextView = rootView.findViewById(R.id.error_text_view);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(onTextChangeListener != null) {
                    onTextChangeListener.onChange(EditTextView.this, charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    protected int getLayoutId() {
        return R.layout.view_edit_text;
    }

    private View inflateView(Context context) {
        return inflate(context, getLayoutId(), this);
    }

    private int[] getDefaultStylable() {
        return R.styleable.EditTextViewDeclareStylable;
    }

    public interface OnTextChangeListener {
        void onChange(View view, String str);
    }

    public OnTextChangeListener getOnTextChangeListener() {
        return onTextChangeListener;
    }

    public void setText(String text) {
        editText.setText(text);
    }

    public void addText(String text) {
        editText.append(text);
    }

    public String getText() {
        return editText.getText().toString();
    }

    public void setLastSelection() {
        editText.setSelection(editText.getText().length());
    }

    public EditText getEditText() {
        return editText;
    }

    public void setError(String error) {
        if(TextUtils.isEmpty(error)) {
            errorTextView.setVisibility(GONE);
            errorTextView.setText(null);
        } else {
            errorTextView.setVisibility(VISIBLE);
            errorTextView.setText(error);
        }
    }

    public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener) {
        this.onTextChangeListener = onTextChangeListener;
    }
}
