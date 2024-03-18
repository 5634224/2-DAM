package com.example.adaptersv

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.preference.PreferenceManager


import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.adaptersv.R
import com.example.adaptersv.mapa.MarkerWindow

import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

import java.util.ArrayList

class OSMActivity : AppCompatActivity()
{
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1

    private lateinit var map : MapView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)


        //load/initialize the osmdroid configuration, this can be done
        // This won't work unless you have imported this: org.osmdroid.config.Configuration.*
        getInstance().load(this, androidx.preference.
        PreferenceManager.getDefaultSharedPreferences(this))
        //setting this before the layout is inflated is a good idea
        //it 'should' ensure that the map has a writable location for the map cache, even without permissions
        //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
        //see also StorageUtils
        //note, the load method also sets the HTTP User Agent to your application's package name, if you abuse osm's
        //tile servers will get you banned based on this string.

        //inflate and create the map
        setContentView(R.layout.activity_osmactivity)

        map = findViewById<MapView>(R.id.map)

        map.setTileSource(TileSourceFactory.MAPNIK)

        /* Para situar el visor del mapa en un punto (Latitud,Longitud)*/
        val mapController = map.controller

        //Cuanto mayor sea, más grande se verá el punto elegido
        mapController.setZoom(18.0)

        //Servigroup Marina Playa
        val startPoint = GeoPoint(37.156035, -1.826449);
        mapController.setCenter(startPoint);

        /* MARCADORES */
        val firstMarker = Marker(map)

        var geoPoint = GeoPoint(37.15628, -1.825713)

        firstMarker.position = geoPoint
        firstMarker.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_pool_24)
        firstMarker.setAnchor(Marker.ANCHOR_BOTTOM, Marker.ANCHOR_CENTER)
        firstMarker.title = "Piscina"

        var infoWindow = MarkerWindow(map, "Piscina")
        firstMarker.infoWindow = infoWindow

        //Añade el marcador al mapa
        map.overlays.add(firstMarker)
        //Actualiza el mapa
        map.invalidate()


        val secondMarker = Marker(map)

        geoPoint = GeoPoint(37.15644086790343, -1.8265386272558004)

        secondMarker.position = geoPoint
        secondMarker.icon = ContextCompat.getDrawable(this, R.drawable.ic_baseline_wine_bar_24)
        secondMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
        secondMarker.title = "Bar"

        infoWindow = MarkerWindow(map, "Bar")
        secondMarker.infoWindow = infoWindow

        //Añade el marcador al mapa
        map.overlays.add(secondMarker)
        //Actualiza el mapa
        map.invalidate()


        /** Solicitamos los permisos **/
        //handle permissions first, before map is created. not depicted here
        requestPermissionsIfNecessary(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION))

    }

    override fun onResume() {
        super.onResume()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        map.onResume() //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onPause() {
        super.onPause()
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        map.onPause()  //needed for compass, my location overlays, v6.0.0 and up
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        val permissionsToRequest = ArrayList<String>()
        var i = 0
        while (i < grantResults.size) {
            permissionsToRequest.add(permissions[i])
            i++
        }
        if (permissionsToRequest.size > 0) {
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                REQUEST_PERMISSIONS_REQUEST_CODE)
        }
    }

    private fun requestPermissionsIfNecessary(permissions: Array<out String>)
    {
        val permissionsToRequest = ArrayList<String>();

        permissions.forEach { permission ->
        if (ContextCompat.checkSelfPermission(this, permission)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            permissionsToRequest.add(permission);
            }
        }

        if (permissionsToRequest.size > 0)
        {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsToRequest.toArray(permissions),
                    REQUEST_PERMISSIONS_REQUEST_CODE);
        }
        else
        {
            /* El permiso de localización ya está concedido */

            //MyLocation
            val overlay: MyLocationNewOverlay = MyLocationNewOverlay(map)
            overlay.enableFollowLocation();
            overlay.enableMyLocation();
            map.overlays.add(overlay);
        }
    }
}