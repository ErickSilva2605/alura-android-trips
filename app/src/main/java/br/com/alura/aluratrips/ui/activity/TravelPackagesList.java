package br.com.alura.aluratrips.ui.activity;

import static br.com.alura.aluratrips.ui.activity.TravelPackageConstants.KEY_TRAVEL_PACKAGE;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.dao.TravelPackageDAO;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.ui.adapter.ListTravelPackagesAdapter;

public class TravelPackagesList extends AppCompatActivity {

    public static final String APPBAR_TITLE = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_packages_list);
        setTitle(APPBAR_TITLE);
        configureTravelPackagesListView();
    }

    private void configureTravelPackagesListView() {
        ListView listTravelPackages = findViewById(R.id.list_travel_package_listview);
        List<TravelPackage> travelPackages = new TravelPackageDAO().get();
        listTravelPackages.setAdapter(new ListTravelPackagesAdapter(travelPackages, this));
        configureItemClickListener(listTravelPackages);
    }

    private void configureItemClickListener(ListView listTravelPackages) {
        listTravelPackages.setOnItemClickListener((adapterView, view, position, id) -> {
            TravelPackage selectedTravelPackage = (TravelPackage) adapterView.getItemAtPosition(position);
            openDetailPackage(selectedTravelPackage);
        });
    }

    private void openDetailPackage(TravelPackage selectedTravelPackage) {
        Intent intent = new Intent(TravelPackagesList.this, DetailPackageActivity.class);
        intent.putExtra(KEY_TRAVEL_PACKAGE, selectedTravelPackage);
        startActivity(intent);
    }
}