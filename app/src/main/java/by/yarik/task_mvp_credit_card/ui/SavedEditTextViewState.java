package by.yarik.task_mvp_credit_card.ui;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

public class SavedEditTextViewState extends View.BaseSavedState {

    private String savedText;

    SavedEditTextViewState(Parcelable superState) {
        super(superState);
    }

    private SavedEditTextViewState(Parcel in) {
        super(in);
        this.savedText = in.readString();
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        super.writeToParcel(out, flags);
        out.writeString(savedText);
    }

    public String getSavedText() {
        return savedText;
    }

    public void setSavedText(String savedText) {
        this.savedText = savedText;
    }

    public static final Parcelable.Creator<SavedEditTextViewState> CREATOR =
            new Parcelable.Creator<SavedEditTextViewState>() {
                public SavedEditTextViewState createFromParcel(Parcel in) {
                    return new SavedEditTextViewState(in);
                }

                public SavedEditTextViewState[] newArray(int size) {
                    return new SavedEditTextViewState[size];
                }
            };


}
