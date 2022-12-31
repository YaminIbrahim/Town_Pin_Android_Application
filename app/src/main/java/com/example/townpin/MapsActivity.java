package com.example.townpin;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.townpin.databinding.ActivityMapsBinding;

import java.util.Vector;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        centerlocation = new LatLng(3.0, 101);

        markerOptions = new Vector<>();

        markerOptions.add(marker = new MarkerOptions().title("Machang Town")
                .position(new LatLng(5.7679, 102.2154))
                .snippet("Machang, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Tanah Merah Town")
                .position(new LatLng(5.8089, 102.1471))
                .snippet("Tanah Merah, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Pasir Putih Town")
                .position(new LatLng(5.8362, 102.4077))
                .snippet("Pasir Putih, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("kota Bharu City")
                .position(new LatLng(6.1248, 102.2544))
                .snippet("Kota Bharu, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Kuala Krai Town")
                .position(new LatLng(5.5308, 102.2019))
                .snippet("Kuala Krai, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Pasir Mas Town")
                .position(new LatLng(6.0424, 102.1428))
                .snippet("Pasir Mas, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Bachok Town")
                .position(new LatLng(6.0477, 102.3945))
                .snippet("Bachok, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Gua Musang Town")
                .position(new LatLng(4.8843, 101.9682))
                .snippet("Gua Musang, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Rantau Panjang Town")
                .position(new LatLng(6.0116, 101.9784))
                .snippet("Rantau Panjang, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Pengkalan Chepa Town")
                .position(new LatLng(6.1525, 102.3063))
                .snippet("Pengkalan Chepa, Kelantan")
        );

        markerOptions.add(marker = new MarkerOptions().title("Jerteh Town")
                .position(new LatLng(5.7376, 102.4949))
                .snippet("Jerteh, Terangganu")
        );

        markerOptions.add(marker = new MarkerOptions().title("Permaisuri Town")
                .position(new LatLng(5.5213, 102.7473))
                .snippet("Permaisuri, Terangganu")
        );

        markerOptions.add(marker = new MarkerOptions().title("Kampung Raja Town")
                .position(new LatLng(5.7953, 102.5642))
                .snippet("Kampung Raja, Terangganu")
        );

        markerOptions.add(marker = new MarkerOptions().title("Kuala Terengganu City")
                .position(new LatLng(5.3296, 103.1370))
                .snippet("Kuala Terengganu, Terangganu")
        );
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation, 8));

        enableMyLocation();
    }

    //Enables the My Location layer if the fine location permission has been granted.
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms, 200);
        }
    }
}