package br.com.alura.aluratrips.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.util.CurrencyUtil;
import br.com.alura.aluratrips.util.DateUtil;
import br.com.alura.aluratrips.util.ResourcesUtil;

public class DetailPurchaseActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_purchase);
        setTitle(APPBAR_TITLE);

        TravelPackage travelPackage = new TravelPackage("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));
        setFields(travelPackage);
    }

    private void setFields(TravelPackage travelPackage) {
        setImage(travelPackage);
        setPlace(travelPackage);
        setPrice(travelPackage);
        setDate(travelPackage);
    }

    private void setDate(TravelPackage travelPackage) {
        TextView date = findViewById(R.id.purchase_detail_date);
        String dateFormatted = DateUtil
                .formatToPeriodText(travelPackage.getDays());
        date.setText(dateFormatted);
    }

    private void setPrice(TravelPackage travelPackage) {
        TextView price = findViewById(R.id.purchase_detail_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(travelPackage.getPrice());
        price.setText(priceFormatted);
    }

    private void setPlace(TravelPackage travelPackage) {
        TextView place = findViewById(R.id.purchase_detail_place);
        place.setText(travelPackage.getPlace());
    }

    private void setImage(TravelPackage travelPackage) {
        ImageView imageBanner = findViewById(R.id.purchase_detail_image_place);
        Drawable travelPackageImage = ResourcesUtil
                .getDrawableByName(this, travelPackage.getImage());
        imageBanner.setImageDrawable(travelPackageImage);
    }
}