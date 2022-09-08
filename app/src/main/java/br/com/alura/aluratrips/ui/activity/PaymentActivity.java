package br.com.alura.aluratrips.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.alura.aluratrips.R;

public class PaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APPBAR_TITLE);
    }
}