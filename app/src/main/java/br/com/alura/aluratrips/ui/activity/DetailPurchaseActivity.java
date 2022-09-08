package br.com.alura.aluratrips.ui.activity;

import static br.com.alura.aluratrips.ui.activity.TravelPackageConstants.KEY_TRAVEL_PACKAGE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.util.CurrencyUtil;
import br.com.alura.aluratrips.util.DateUtil;
import br.com.alura.aluratrips.util.ResourcesUtil;

public class DetailPurchaseActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo da compra";
    private TravelPackage selectedTravelPackage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_purchase);
        setTitle(APPBAR_TITLE);
        configureIntent();
    }

    private void configureIntent() {
        Intent intentData = getIntent();
        if (intentData.hasExtra(KEY_TRAVEL_PACKAGE)) {
            selectedTravelPackage = (TravelPackage) intentData.getSerializableExtra(KEY_TRAVEL_PACKAGE);
            setFields();
        }
    }

    private void setFields() {
        setImage();
        setPlace();
        setPrice();
        setDate();
    }

    private void setDate() {
        TextView date = findViewById(R.id.purchase_detail_date);
        String dateFormatted = DateUtil
                .formatToPeriodText(selectedTravelPackage.getDays());
        date.setText(dateFormatted);
    }

    private void setPrice() {
        TextView price = findViewById(R.id.purchase_detail_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(selectedTravelPackage.getPrice());
        price.setText(priceFormatted);
    }

    private void setPlace() {
        TextView place = findViewById(R.id.purchase_detail_place);
        place.setText(selectedTravelPackage.getPlace());
    }

    private void setImage() {
        ImageView imageBanner = findViewById(R.id.purchase_detail_image_place);
        Drawable travelPackageImage = ResourcesUtil
                .getDrawableByName(this, selectedTravelPackage.getImage());
        imageBanner.setImageDrawable(travelPackageImage);
    }
}