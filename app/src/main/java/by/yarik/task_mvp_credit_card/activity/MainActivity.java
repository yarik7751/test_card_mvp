package by.yarik.task_mvp_credit_card.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import by.yarik.task_mvp_credit_card.R;
import by.yarik.task_mvp_credit_card.view.card.CardFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null) {
            setCardFragment();
        }
    }

    public void setCurrentFragment(Fragment fragment, boolean add) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if(add) {
            transaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        transaction.commit();
    }

    public void setRootFragment(Fragment fragment) {
        setCurrentFragment(fragment, false);
    }

    public void setCardFragment() {
        setRootFragment(CardFragment.newInstance());
    }
}
