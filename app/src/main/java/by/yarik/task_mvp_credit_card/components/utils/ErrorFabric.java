package by.yarik.task_mvp_credit_card.components.utils;

import android.content.Context;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.components.exception.NoInternetConnectionException;

public class ErrorFabric {

    public static String getErrorMessage(Context context, Throwable error) {
        String message = "";

        if(error instanceof NoInternetConnectionException) {
            message = context.getString(R.string.no_internet_connection);
        }

        return message;
    }
}
