package com.example.quizzapp.ui.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.quizzapp.QuizActivity;
import com.example.quizzapp.R;
import com.example.quizzapp.ui.database.DatabaseFragment;

public class QuizFragment extends Fragment {
    private Button easyButton;
    private Button hardButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        easyButton = view.findViewById(R.id.button6);
        hardButton = view.findViewById(R.id.button7);

        easyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("easy");
            }
        });

        hardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuizActivity("hard");
            }
        });

        return view;
    }

    private void startQuizActivity(String mode) {
        Intent intent = new Intent(getActivity(), QuizActivity.class);
        intent.putExtra("mode", mode);
        startActivity(intent);

        /*

        Code i came up with after feedback.
        However it breaks the app.

        Fragment fragment = new DatabaseFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.quiz_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

         */
    }
}
