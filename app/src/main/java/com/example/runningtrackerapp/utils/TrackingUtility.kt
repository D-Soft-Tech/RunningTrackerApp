package com.example.runningtrackerapp.utils

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.fragment.app.Fragment
import com.example.runningtrackerapp.R
import pub.devrel.easypermissions.EasyPermissions

object TrackingUtility {

    fun hasLocationPermissions(context: Context) =
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        } else {
            EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }

    // Used for requesting permissions
    fun requestForPermissions(context: Context, host: Fragment) {
        if (hasLocationPermissions(context)) { // If the user has not accepted the permissions before
            return
        } else { // if the user has accepted the permissions before
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) { // If the user's phone is running on below Android Q
                EasyPermissions.requestPermissions(
                    host,
                    context.getString(R.string.permission_rationale),
                    AppConstants.REQUEST_PERMISSION_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            } else { // If the user's phone is running on Android Q and above
                EasyPermissions.requestPermissions(
                    host,
                    context.getString(R.string.permission_rationale),
                    AppConstants.REQUEST_PERMISSION_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                )
            }
        }
    }
}
