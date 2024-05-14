 package com.example.memorygame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainGame extends AppCompatActivity {

    String[][] board;
    ImageView[] ImageViews;
    int count;
    int countPlayer1 = 0 ;
    int countPlayer2 = 0;
    int card1;
    String turn = "counterPlayer1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void onNewGame() {
        board = new String[4][4];
        for (int row = 0; row < 4; row++)
            for (int col = 0; col < 4; col++) {
                board[row][col] = new String();
            }
        count=0;
    }

    private void onNewGame1() {
        ImageView[] imageViews = new ImageView[8];

        // Array of drawable resource IDs
        int[] drawableIds = {
                R.drawable.apple,
                R.drawable.watermelon,
                R.drawable.grape,
                R.drawable.kiwi,
                R.drawable.mango,
                R.drawable.peach,
                R.drawable.pineapple,
                R.drawable.strawberry
        };

        for (int i = 0; i < 8; i++) {
            // Create a new ImageView
            Context context = null;
            ImageView imageView = new ImageView(context);
            // Set the image resource for the ImageView
            imageView.setImageResource(drawableIds[i]);
            // Add the ImageView to the array
            imageViews[i] = imageView;
        }
    }

    public void knock(View view) {
        if (view.getId() == R.id.kiwi1) {
            count++;
            ImageView backImageView = findViewById(R.id.kiwi1);
            backImageView.setImageResource(R.drawable.kiwi);
            turnEnd(view);
        }
        if (view.getId() == R.id.strawberry1) {
            count++;
            ImageView backImageView = findViewById(R.id.strawberry1);
            backImageView.setImageResource(R.drawable.strawberry);
            turnEnd(view);
        }
        if (view.getId() == R.id.mango1){
            count++;
            ImageView backImageView = findViewById(R.id.mango1);
            backImageView.setImageResource(R.drawable.mango);
            turnEnd(view);
        }
        if (view.getId() == R.id.grape1){
            count++;
            ImageView backImageView = findViewById(R.id.grape1);
            backImageView.setImageResource(R.drawable.grape);
            turnEnd(view);
        }
        if (view.getId() == R.id.pineapple1){
            count++;
            ImageView backImageView = findViewById(R.id.pineapple1);
            backImageView.setImageResource(R.drawable.pineapple);
            turnEnd(view);
        }
        if (view.getId() == R.id.watermelon1){
            count++;
            ImageView backImageView = findViewById(R.id.watermelon1);
            backImageView.setImageResource(R.drawable.watermelon);
            turnEnd(view);
        }
        if (view.getId() == R.id.peach1){
            count++;
            ImageView backImageView = findViewById(R.id.peach1);
            backImageView.setImageResource(R.drawable.peach);
            turnEnd(view);
        }
        if (view.getId() == R.id.apple1){
            count++;
            ImageView backImageView = findViewById(R.id.apple1);
            backImageView.setImageResource(R.drawable.apple);
            turnEnd(view);
        }
        if (view.getId() == R.id.kiwi2){
            count++;
            ImageView backImageView = findViewById(R.id.kiwi2);
            backImageView.setImageResource(R.drawable.kiwi);
            turnEnd(view);
        }
        if (view.getId() == R.id.strawberry2){
            count++;
            ImageView backImageView = findViewById(R.id.strawberry2);
            backImageView.setImageResource(R.drawable.strawberry);
            turnEnd(view);
        }
        if (view.getId() == R.id.mango2) {
            count++;
            ImageView backImageView = findViewById(R.id.mango2);
            backImageView.setImageResource(R.drawable.mango);
            turnEnd(view);
        }
        if (view.getId() == R.id.grape2) {
            count++;
            ImageView backImageView = findViewById(R.id.grape2);
            backImageView.setImageResource(R.drawable.grape);
            turnEnd(view);
        }
        if (view.getId() == R.id.pineapple2) {
            count++;
            ImageView backImageView = findViewById(R.id.pineapple2);
            backImageView.setImageResource(R.drawable.pineapple);
            turnEnd(view);
        }
        if (view.getId() == R.id.watermelon2) {
            count++;
            ImageView backImageView = findViewById(R.id.watermelon2);
            backImageView.setImageResource(R.drawable.watermelon);
            turnEnd(view);
        }
        if (view.getId() == R.id.peach2) {
            count++;
            ImageView backImageView = findViewById(R.id.peach2);
            backImageView.setImageResource(R.drawable.peach);
            turnEnd(view);
        }
        if (view.getId() == R.id.apple2) {
            count++;
            ImageView backImageView = findViewById(R.id.apple2);
            backImageView.setImageResource(R.drawable.apple);
            turnEnd(view);
        }
    }
    public void closeCard(int card1, ImageView view){
        ImageView card1Closed = findViewById(card1);
        card1Closed.setImageResource(R.drawable.fruit);
        ImageView card2Closed = findViewById(view.getId());
        card2Closed.setImageResource(R.drawable.fruit);
    }
    public void turnEnd(View view) {
        if (count % 2 != 0){
            card1 = view.getId();
            return;
        }
        if(count % 2 == 0){
            ImageView imageViewCard1 = findViewById(card1);
            Drawable image1 = imageViewCard1.getDrawable();
            Drawable image2 = ((ImageView)view).getDrawable();
            if(image1.getConstantState().equals(image2.getConstantState())){
                if(turn.equals("counterPlayer1")){
                    countPlayer1++;
                    turn  = "counterPlayer2";
                }
                else{
                    countPlayer2++;
                    turn = "counterPlayer1";
                }
            }
            else{
                final Handler handler = new Handler();
                handler.postDelayed(() -> closeCard(card1,((ImageView) view)), 400);
                if(turn.equals("counterPlayer1")){
                    turn  = "counterPlayer2";
                }
                else{
                    turn = "counterPlayer1";
                }
            }
        }
    }


}