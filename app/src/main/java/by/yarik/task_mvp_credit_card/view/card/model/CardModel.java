package by.yarik.task_mvp_credit_card.view.card.model;

import android.text.TextUtils;

public class CardModel {

    private static final int NUMBER_VALID_LENGTH = 16;
    private static final int HOLDER_WORLDS_COUNT = 2;
    private static final String HOLDER_REGEX = "\\s+";
    private static final String DATE_REGEX = "/";
    private static final int DATE_MAX_LENGTH = 5;
    private static final int DATE_MAX_ARRAY_LENGTH = 2;
    private static final int CVV_MAX_LENGTH = 3;

    private String number;
    private String holder;
    private String date;
    private String cvv;

    public CardModel(String number, String holder, String date, String cvv) {
        this.number = number;
        this.holder = holder;
        this.date = date;
        this.cvv = cvv;
    }

    public CardModel() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public boolean isValidNumber() {
        return number.length() == NUMBER_VALID_LENGTH;
    }

    public boolean isValidHolder() {
        return holder.split(HOLDER_REGEX).length == HOLDER_WORLDS_COUNT;
    }

    public boolean isValidDate() {
        try {
            if(TextUtils.isEmpty(date)) return false;
            if(date.length() > DATE_MAX_LENGTH) return false;

            String[] dateArray = date.split(DATE_REGEX);
            if(dateArray.length != DATE_MAX_ARRAY_LENGTH) return false;

            if(date.contains(DATE_REGEX)) {
                int month = Integer.parseInt(dateArray[0]);
                return month >= 1 && month <= 12;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isValidCvv() {
        return cvv.length() == CVV_MAX_LENGTH;
    }
}
