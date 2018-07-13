package com.example.mohan.tictactoe2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView[] boxes = new TextView[9];
    TextView result;
    int counter = 0;
    boolean gameOver= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //boxes
        for (int i = 1; i <= 9; i++) {
            String s = "box"+i;
            int resID =getResources().getIdentifier(s,"id",getPackageName());
            boxes[i - 1] = (TextView) findViewById(resID);
            boxes[i - 1].setOnClickListener(this);
            boxes[i - 1].setTag(i - 1);

        }
        result = findViewById(R.id.result);
    }

    @Override
    public void onClick(View view) {
        counter++;
        TextView box = boxes[Integer.parseInt(view.getTag().toString())];

        if(box.getText().toString().length()==0 && (!gameOver)) {

            if (counter % 2 == 0) {
                box.setText("0");
            } else {
                box.setText("X");
            }
        }else {
            counter--;
        }
        checkWinner();
    }

    public void checkWinner() {


        if (boxes[0].getText().equals(boxes[1].getText()) && boxes[2].getText().equals(boxes[1].getText()) && boxes[1].getText().equals("X")
                ||
                boxes[0].getText().equals(boxes[4].getText()) && boxes[8].getText().equals(boxes[4].getText()) && boxes[0].getText().equals("X")
                ||
                boxes[0].getText().equals(boxes[3].getText()) && boxes[6].getText().equals(boxes[3].getText()) && boxes[0].getText().equals("X")
                ||
                boxes[6].getText().equals(boxes[7].getText()) && boxes[8].getText().equals(boxes[7].getText()) && boxes[6].getText().equals("X")
                ||
                boxes[6].getText().equals(boxes[4].getText()) && boxes[2].getText().equals(boxes[4].getText()) && boxes[6].getText().equals("X")
                ||
                boxes[2].getText().equals(boxes[5].getText()) && boxes[8].getText().equals(boxes[5].getText()) && boxes[5].getText().equals("X")
                ||
                boxes[1].getText().equals(boxes[4].getText()) && boxes[4].getText().equals(boxes[7].getText()) && boxes[7].getText().equals("X")
                ||
                boxes[3].getText().equals(boxes[4].getText()) && boxes[4].getText().equals(boxes[5].getText()) && boxes[5].getText().equals("X")
                ) {
            result.setVisibility(View.VISIBLE);
            result.setText("X wins");
            gameOver=true;
        } else if (
                boxes[0].getText().equals(boxes[1].getText()) && boxes[2].getText().equals(boxes[1].getText()) && boxes[1].getText().equals("0")
                        ||
                        boxes[0].getText().equals(boxes[4].getText()) && boxes[8].getText().equals(boxes[4].getText()) && boxes[0].getText().equals("0")
                        ||
                        boxes[0].getText().equals(boxes[3].getText()) && boxes[6].getText().equals(boxes[3].getText()) && boxes[0].getText().equals("0")
                        ||
                        boxes[6].getText().equals(boxes[7].getText()) && boxes[8].getText().equals(boxes[7].getText()) && boxes[6].getText().equals("0")
                        ||
                        boxes[6].getText().equals(boxes[4].getText()) && boxes[2].getText().equals(boxes[4].getText()) && boxes[6].getText().equals("0")
                        ||
                        boxes[2].getText().equals(boxes[5].getText()) && boxes[8].getText().equals(boxes[5].getText()) && boxes[5].getText().equals("0")
                        ||
                        boxes[1].getText().equals(boxes[4].getText()) && boxes[4].getText().equals(boxes[7].getText()) && boxes[7].getText().equals("0")
                        ||
                        boxes[3].getText().equals(boxes[4].getText()) && boxes[4].getText().equals(boxes[5].getText()) && boxes[5].getText().equals("0")
                ) {
            result.setVisibility(View.VISIBLE);
            result.setText("0 wins");
            gameOver=true;

        }else if (counter==9){
            result.setText("its a tie");
        }

    }

    public void restartGame(View view){


        for(int i=0;i<9;i++){
            boxes[i].setText("");
        }

        result.setText("");
        result.setVisibility(View.INVISIBLE);
        counter=0;

    }

}
