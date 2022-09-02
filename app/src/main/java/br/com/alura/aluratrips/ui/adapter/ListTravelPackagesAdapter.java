package br.com.alura.aluratrips.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.aluratrips.util.CurrencyUtil;
import br.com.alura.aluratrips.util.DaysUtil;
import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.util.ResourcesUtil;
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

        setPlace(viewInflated, travelPackage);
        setImage(viewInflated, travelPackage);
        setDays(viewInflated, travelPackage);
        setPrice(viewInflated, travelPackage);

        return viewInflated;
    }

    private void setPrice(View viewInflated, TravelPackage travelPackage) {
        TextView price = viewInflated.findViewById(R.id.item_package_price);
        String priceFormatted = CurrencyUtil
                .formatToPtBR(travelPackage.getPrice());
        price.setText(priceFormatted);
    }

    private void setDays(View viewInflated, TravelPackage travelPackage) {
        TextView days = viewInflated.findViewById(R.id.item_package_days);
        String daysFormatted = DaysUtil
                .formatToText(travelPackage.getDays());
        days.setText(daysFormatted);
    }

    private void setImage(View viewInflated, TravelPackage travelPackage) {
        ImageView image = viewInflated.findViewById(R.id.item_package_image);
        Drawable travelPackageImage = ResourcesUtil.getDrawableByName(context, travelPackage.getImage());
        image.setImageDrawable(travelPackageImage);
    }

    private void setPlace(View viewInflated, TravelPackage travelPackage) {
        TextView place = viewInflated.findViewById(R.id.item_package_place);
        place.setText(travelPackage.getPlace());
    }
}
