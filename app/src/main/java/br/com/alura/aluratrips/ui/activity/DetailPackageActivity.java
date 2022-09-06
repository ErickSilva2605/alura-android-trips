package br.com.alura.aluratrips.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.util.CurrencyUtil;
import br.com.alura.aluratrips.util.DaysUtil;
import br.com.alura.aluratrips.util.ResourcesUtil;

public class DetailPackageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_package);
        setTitle("Resumo do pacote");

        TravelPackage travelPackage = new TravelPackage("São Paulo", "sao_paulo_sp", 2, new BigDecimal(243.99));

        ImageView imageBanner = findViewById(R.id.detail_package_image_banner);
        Drawable travelPackageImage = ResourcesUtil.getDrawableByName(this, travelPackage.getImage());
        imageBanner.setImageDrawable(travelPackageImage);

        TextView place = findViewById(R.id.detail_package_place);
        place.setText(travelPackage.getPlace());

        TextView days = findViewById(R.id.detail_package_days);
        String daysFormatted = DaysUtil
                .formatToText(travelPackage.getDays());
        days.setText(daysFormatted);

        TextView price = findViewById(R.id.detail_package_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(travelPackage.getPrice());
        price.setText(priceFormatted);

        TextView date = findViewById(R.id.detail_package_date);
        Calendar initDate = Calendar.getInstance();
        Calendar finalDate = Calendar.getInstance();
        finalDate.add(Calendar.DATE, travelPackage.getDays());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        String initDateFormatted = dateFormat.format(initDate.getTime());
        String finalDateFormatted = dateFormat.format(finalDate.getTime());
        String dateFormatted = initDateFormatted + " - " + finalDateFormatted + " de " + finalDate.get(Calendar.YEAR);
        date.setText(dateFormatted);
    }
}