package br.com.alura.aluratrips.ui.activity;

import static br.com.alura.aluratrips.ui.activity.TravelPackageConstants.KEY_TRAVEL_PACKAGE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.util.CurrencyUtil;
import br.com.alura.aluratrips.util.DateUtil;
import br.com.alura.aluratrips.util.DaysUtil;
import br.com.alura.aluratrips.util.ResourcesUtil;

public class DetailPackageActivity extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Resumo do pacote";
    private TravelPackage selectedTravelPackage = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_package);
        setTitle(APPBAR_TITLE);
        configureIntent();
        setClick();
    }

    private void setClick() {
        Button buttonMakePayment = findViewById(R.id.detail_package_make_payment);
        buttonMakePayment.setOnClickListener(view -> openPayment());
    }

    private void openPayment() {
        Intent intent = new Intent(DetailPackageActivity.this, PaymentActivity.class);
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
        setImage();
        setPlace();
        setDays();
        setPrice();
        setDate();
    }

    private void setDate() {
        TextView date = findViewById(R.id.detail_package_date);
        String dateFormatted = DateUtil
                .formatToPeriodText(selectedTravelPackage.getDays());
        date.setText(dateFormatted);
    }

    private void setPrice() {
        TextView price = findViewById(R.id.detail_package_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(selectedTravelPackage.getPrice());
        price.setText(priceFormatted);
    }

    private void setDays() {
        TextView days = findViewById(R.id.detail_package_days);
        String daysFormatted = DaysUtil
                .formatToText(selectedTravelPackage.getDays());
        days.setText(daysFormatted);
    }

    private void setPlace() {
        TextView place = findViewById(R.id.detail_package_place);
        place.setText(selectedTravelPackage.getPlace());
    }

    private void setImage() {
        ImageView imageBanner = findViewById(R.id.detail_package_image_banner);
        Drawable travelPackageImage = ResourcesUtil
                .getDrawableByName(this, selectedTravelPackage.getImage());
        imageBanner.setImageDrawable(travelPackageImage);
    }
}