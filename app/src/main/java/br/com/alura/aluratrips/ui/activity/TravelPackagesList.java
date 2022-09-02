package br.com.alura.aluratrips.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import br.com.alura.aluratrips.R;
import br.com.alura.aluratrips.dao.TravelPackageDAO;
import br.com.alura.aluratrips.model.TravelPackage;
import br.com.alura.aluratrips.ui.adapter.ListTravelPackagesAdapter;

public class TravelPackagesList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_packages_list);
        setTitle("Pacotes");

        ListView listTravelPackages = findViewById(R.id.list_travel_package_listview);

        List<TravelPackage> travelPackages = new TravelPackageDAO().get();

        listTravelPackages.setAdapter(new ListTravelPackagesAdapter(travelPackages, this));
    }
}