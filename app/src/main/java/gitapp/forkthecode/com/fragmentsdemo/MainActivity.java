package gitapp.forkthecode.com.fragmentsdemo;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ExpenseListFragment.ExpenseListCallback {

    boolean isDualMode;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FrameLayout container =(FrameLayout) findViewById(R.id.container);

        isDualMode = container!=null;

        if(isDualMode){


            Toast.makeText(this,"Dual Mode",Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getSupportFragmentManager();

            ExpenseDetailFragment fragment = (ExpenseDetailFragment) fragmentManager.findFragmentById(R.id.container);

            if(fragment == null){

                fragment = new ExpenseDetailFragment();

                fragmentManager.beginTransaction().add(R.id.container,fragment).commit();
            }

        }


//        if(savedInstanceState == null){
//
//            ExpenseDetailFragment fragment = new ExpenseDetailFragment();
//
//
//            Bundle extras = new Bundle();
//            extras.putString("expense","Expense");
//            fragment.setArguments(extras);
//
//            FragmentManager fragmentManager = getSupportFragmentManager();
//
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//            fragmentTransaction.add(R.id.container,fragment);
//
//            fragmentTransaction.commit();
//
//        }



    }
    public void selectExpense(String expense){

//        Toast.makeText(this,expense,Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("expense",expense);

        if(isDualMode){
            ExpenseDetailFragment detailFragment = new ExpenseDetailFragment();



            detailFragment.setArguments(bundle);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.container,detailFragment);

            fragmentTransaction.commit();


        }
        else {
            Intent intent = new Intent(this,DetailActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }

    @Override
    public void onExpenseSelected(String expense) {
        selectExpense(expense);
    }
}
