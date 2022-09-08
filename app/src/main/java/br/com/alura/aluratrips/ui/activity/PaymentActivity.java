package br.com.alura.aluratrips.ui.activity;

import static br.com.alura.aluratrips.ui.activity.TravelPackageConstants.KEY_TRAVEL_PACKAGE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.util.CurrencyUtil;

public class PaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pagamento";
    private TravelPackage selectedTravelPackage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APPBAR_TITLE);
        configureIntent();
        setClick();
    }

    private void setClick() {
        Button buttonMakePayment = findViewById(R.id.payment_finalize_purchase);
        buttonMakePayment.setOnClickListener(view -> openDetailPurchase());
    }

    private void openDetailPurchase() {
        Intent intent = new Intent(PaymentActivity.this, DetailPurchaseActivity.class);
        intent.putExtra(KEY_TRAVEL_PACKAGE, selectedTravelPackage);
        startActivity(intent);
    }

    private void configureIntent() {
        Intent intentData = getIntent();
        if (intentData.hasExtra(KEY_TRAVEL_PACKAGE)) {
            selectedTravelPackage = (TravelPackage) intentData.getSerializableExtra(KEY_TRAVEL_PACKAGE);
            setFields();
        }
    }

    private void setFields() {
        setPrice();
    }

    private void setPrice() {
        TextView price = findViewById(R.id.payment_purchase_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(selectedTravelPackage.getPrice());
        price.setText(priceFormatted);
    }
}