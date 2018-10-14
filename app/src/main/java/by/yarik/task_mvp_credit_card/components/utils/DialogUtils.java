package by.yarik.task_mvp_credit_card.components.utils;

import android.content.Context;
import android.widget.Toast;

public class DialogUtils {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
