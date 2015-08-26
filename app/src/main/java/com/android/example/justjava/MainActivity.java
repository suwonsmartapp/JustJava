
package com.android.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private final int PRICE_COFFEE = 2500;

    private int mQuantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 주문 버튼 이벤트 처리
     *
     * @param view 이벤트 처리 할 view
     */
    public void submitOrder(View view) {
        String price = NumberFormat.getCurrencyInstance().format(PRICE_COFFEE * mQuantity);
        String message = "Total : " + price + "\nThank you!";

        displayMessage(message);
    }

    public void increment(View view) {
        mQuantity++;
        display(mQuantity);
        displayPrice(PRICE_COFFEE * mQuantity);
    }

    public void decrement(View view) {
        mQuantity--;

        if (mQuantity < 0) {
            mQuantity = 0;
        }

        display(mQuantity);
        displayPrice(PRICE_COFFEE * mQuantity);
    }

    /**
     * 수량을 화면에 표시
     *
     * @param number 표시 할 수량
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
