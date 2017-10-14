package gitapp.forkthecode.com.fragmentsdemo;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseListFragment extends Fragment {


    ExpenseListCallback listCallback;

    ListView listView;

    ArrayList<String> titles;

    ArrayAdapter<String> adapter;


    public ExpenseListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            try {
                listCallback = (ExpenseListCallback) context;
            }
            catch (ClassCastException e){
                Log.i("List Fragment","Please implement Callback");
            }

        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_expense_list, container, false);

        titles = Expense.getTitles(10);

        listView = view.findViewById(R.id.listView);

        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,titles);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listCallback.onExpenseSelected(titles.get(i));
            }
        });

        return view;
    }


    public interface ExpenseListCallback {

        void onExpenseSelected(String expense);

    }

}
