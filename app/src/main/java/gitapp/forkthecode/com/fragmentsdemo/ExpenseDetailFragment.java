package gitapp.forkthecode.com.fragmentsdemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseDetailFragment extends Fragment {


    public ExpenseDetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expense_detail, container, false);


        Bundle data = getArguments();
        if(data != null){

            String expense = data.getString("expense");

            TextView textView = view.findViewById(R.id.detailTextView);

            textView.setText(expense);

        }



        return view;
    }

}
