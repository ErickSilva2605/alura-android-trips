package br.com.alura.aluratrips.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.util.CurrencyUtil;

public class PaymentActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle(APPBAR_TITLE);

        TravelPackage travelPackage = new TravelPackage("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));
        setFields(travelPackage);
    }

    private void setFields(TravelPackage travelPackage) {
        setPrice(travelPackage);
    }

    private void setPrice(TravelPackage travelPackage) {
        TextView price = findViewById(R.id.payment_purchase_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(travelPackage.getPrice());
        price.setText(priceFormatted);
    }
}