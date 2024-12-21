package com.example.zad11_12;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mEmail;
    private String mName;
    private String mSurname;


    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String email, String name, String surname) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, email);
        args.putString(ARG_PARAM2, name);
        args.putString(ARG_PARAM3, surname);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mEmail = getArguments().getString(ARG_PARAM1);
            mName = getArguments().getString(ARG_PARAM2);
            mSurname = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);

        TextView typedEmail = view.findViewById(R.id.typedEmail);
        TextView typedName = view.findViewById(R.id.typedName);
        TextView typedSurname = view.findViewById(R.id.typedSurname);

        if (getArguments() != null) {
            String email = getArguments().getString(ARG_PARAM1);
            String name = getArguments().getString(ARG_PARAM2);
            String surname = getArguments().getString(ARG_PARAM3);

            typedEmail.setText("Adres e-mail: " + email);
            typedName.setText("Imię: " + name);
            typedSurname.setText("Nazwisko: " + surname);
        }

        return view;
    }
}