package com.example.callbackmethod_send_value_from_fragment_to_activity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    FragmentListener fragmentListener;
    private EditText firstName,lastName,ageEt;
    private Button sendToActivity;

    public DetailFragment() {
        // Required empty public constructor
    }

    public interface FragmentListener{
      void sendValues(String fName,String lName,int age);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof FragmentListener)) throw new AssertionError();
        fragmentListener = (FragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        firstName = view.findViewById(R.id.firstName);
        lastName = view.findViewById(R.id.lastName);
        ageEt = view.findViewById(R.id.age);

        sendToActivity = view.findViewById(R.id.button_sendToActivity);

        sendToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendValues();
            }
        });

        return view;
    }


    public void sendValues(){
        if(fragmentListener == null) {
            throw new AssertionError();
        }
        String fName = firstName.getText().toString();
        String lName = lastName.getText().toString();
        int age = Integer.valueOf(ageEt.getText().toString());

        fragmentListener.sendValues(fName,lName,age);
    }

}
