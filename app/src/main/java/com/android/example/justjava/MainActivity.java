
package com.android.example.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private final int PRICE_COFFEE = 2500;
    private final int PRICE_WHIP = 500;

    private int mQuantity = 0;

    private TextView mPriceTextView;
    private TextView mQuantityTextView;
    private CheckBox mToppingCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPriceTextView = (TextView) findViewById(R.id.price_text_view);
        mQuantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        mToppingCheckBox = (CheckBox) findViewById(R.id.topping_checkbox);
    }

    /**
     * 주문 버튼 이벤트 처리
     *
     * @param view 이벤트 처리 할 view
     */
    public void submitOrder(View view) {
        String name = "Name : 오준석";
        String topping = "Add whipped cream? " + mToppingCheckBox.isChecked();
        String quantity = "Quantity : " + mQuantity;

        int price = PRICE_COFFEE * mQuantity;

        if (mToppingCheckBox.isChecked()) {
            price += mQuantity * PRICE_WHIP;
        }

        String formattedPrice = "Total : "
                + NumberFormat.getCurrencyInstance().format(price);

        String message = name + "\n" + topping + "\n" + quantity + "\n" + formattedPrice + "\n"
                + "Thank you!";

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
        mQuantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {
        mPriceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message) {
        mPriceTextView.setText(message);
    }

}
