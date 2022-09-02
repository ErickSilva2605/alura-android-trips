package br.com.alura.aluratrips.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.model.TravelPackage;

public class ListTravelPackagesAdapter extends BaseAdapter {

    private final List<TravelPackage> travelPackages;
    private final Context context;

    public ListTravelPackagesAdapter(List<TravelPackage> travelPackages, Context context){

        this.travelPackages = travelPackages;
        this.context = context;
    }

    @Override
    public int getCount() {
        return travelPackages.size();
    }

    @Override
    public TravelPackage getItem(int position) {
        return travelPackages.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View viewInflated = LayoutInflater.from(context )
                .inflate(R.layout.item_travel_package, parent, false);

        TravelPackage travelPackage = travelPackages.get(position);

        TextView place = viewInflated.findViewById(R.id.item_package_place);
        place.setText(travelPackage.getPlace());

        ImageView image = viewInflated.findViewById(R.id.item_package_image);
        Resources resources = context.getResources();
        int drawableId = resources.getIdentifier(travelPackage.getImage()
                , "drawable", context.getPackageName());
        Drawable travelPackageImage = resources.getDrawable(drawableId);
        image.setImageDrawable(travelPackageImage);

        TextView days = viewInflated.findViewById(R.id.item_package_days);
        int daysCount = travelPackage.getDays();
        String daysText = daysCount > 1 ? daysCount + " dias" : daysCount + " dia";
        days.setText(daysText);

        TextView price = viewInflated.findViewById(R.id.item_package_price);
        BigDecimal travelPackagePrice = travelPackage.getPrice();
        NumberFormat formatBR = DecimalFormat.getCurrencyInstance(
                new Locale("pt", "br"));
        String priceBR = formatBR
                .format(travelPackagePrice)
                .replace("R$", "R$ ");
        price.setText(priceBR);

        return viewInflated;
    }
}
