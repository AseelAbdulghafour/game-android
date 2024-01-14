
package com.example.game;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;

        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView, correctTextView, wrongTextView, scoreTextView;
    private Button trueButton, falseButton, nextButton;

    private ArrayList<String> question;
    private ArrayList<Boolean> answers;
    private int currentIndex = 0;

    int grade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionTextView = findViewById(R.id.questionTextView);
        correctTextView = findViewById(R.id.correctTextView);
        wrongTextView = findViewById(R.id.WrongTextView);
        trueButton = findViewById(R.id.trueButton);
        falseButton = findViewById(R.id.falseButton);
        nextButton = findViewById(R.id.nextQ);
        scoreTextView = findViewById(R.id.scoreTextView);


        question = new ArrayList<>();
        answers = new ArrayList<>();


        question.add("All dogs have tails");
        answers.add(false);

        question.add("Bears live in the Arctic");
        answers.add(true);

        question.add("You can see the Great Wall of China from space");
        answers.add(false);

        displayQuestion();

        trueButton.setOnClickListener(view -> checkAnswer(true));
        falseButton.setOnClickListener(view -> checkAnswer(false));
        nextButton.setOnClickListener(view -> nextQuestion());
    }

    private void displayQuestion() {
        questionTextView.setText(question.get(currentIndex));

        scoreTextView.setText(String.valueOf(grade));

        correctTextView.setVisibility(View.INVISIBLE);
        wrongTextView.setVisibility(View.INVISIBLE);
        nextButton.setVisibility(View.INVISIBLE);
        trueButton.setVisibility(View.VISIBLE);
        falseButton.setVisibility(View.VISIBLE);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = answers.get(currentIndex);

        if (userAnswer == correctAnswer) {

            correctTextView.setVisibility(View.VISIBLE);
            wrongTextView.setVisibility(View.INVISIBLE);
            trueButton.setVisibility(View.INVISIBLE);
            falseButton.setVisibility(View.INVISIBLE);
            nextButton.setVisibility(View.VISIBLE);

            TheGrade();
        } else {

            correctTextView.setVisibility(View.INVISIBLE);
            wrongTextView.setVisibility(View.VISIBLE);
            trueButton.setVisibility(View.VISIBLE);
            falseButton.setVisibility(View.VISIBLE);
            nextButton.setVisibility(View.INVISIBLE);
        }
    }

    public void TheGrade() {
        grade++;
        scoreTextView.setText(String.valueOf(grade));
    }

    private void nextQuestion() {
        currentIndex++;
        if (currentIndex < question.size()) {
            displayQuestion();
        } else {

        }
    }
}