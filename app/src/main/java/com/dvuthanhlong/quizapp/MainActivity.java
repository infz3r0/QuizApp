package com.dvuthanhlong.quizapp;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Question[] questions;
    private static int q_index;

    TextView txvContent;
    Button btnTrue;
    Button btnFalse;
    Button btnPrev;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvContent = (TextView) findViewById(R.id.txvContent);
        btnTrue = (Button) findViewById(R.id.btnTrue);
        btnFalse = (Button) findViewById(R.id.btnFalse);
        btnPrev = (Button) findViewById(R.id.btnPrev);
        btnNext = (Button) findViewById(R.id.btnNext);

        Resources res = getResources();
        questions = new Question[]

                {
                        new Question(res.getString(R.string.q_0), res.getBoolean(R.bool.a_0)),
                        new Question(res.getString(R.string.q_1), res.getBoolean(R.bool.a_1)),
                        new Question(res.getString(R.string.q_2), res.getBoolean(R.bool.a_2)),
                        new Question(res.getString(R.string.q_3), res.getBoolean(R.bool.a_3)),
                        new Question(res.getString(R.string.q_4), res.getBoolean(R.bool.a_4))
                };
        if (questions.length > 0)
        {
            q_index = 0;
        }
        else
        {
            q_index = -1;
        }

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        ShowQuestion(q_index);
    }

    private void ShowQuestion(int index)
    {
        txvContent.setText(questions[index].getContent());
    }

    private void CheckAnswer(boolean answer)
    {
        if (answer == questions[q_index].getAnswer())
        {
            Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnTrue.getId())
        {
            //btnTrue
            CheckAnswer(true);
        }
        else if (v.getId() == btnFalse.getId())
        {
            //btnFalse
            CheckAnswer(false);
        }
        else if (v.getId() == btnPrev.getId())
        {
            //btnPrev
            q_index -= 1;
            if (q_index < 0)
            {
                q_index = 0;
            }
            ShowQuestion(q_index);
        }
        else if (v.getId() == btnNext.getId())
        {
            //btnNext
            q_index += 1;
            if (q_index > questions.length - 1)
            {
                q_index = questions.length - 1;
            }
            ShowQuestion(q_index);
        }
    }
}
