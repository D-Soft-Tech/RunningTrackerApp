package com.example.runningtrackerapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.runningtrackerapp.R
import com.example.runningtrackerapp.databinding.FragmentSetupBinding
import com.example.runningtrackerapp.utils.AppConstants.REQUEST_PERMISSION_CODE
import com.example.runningtrackerapp.utils.TrackingUtility.hasLocationPermissions
import com.example.runningtrackerapp.utils.TrackingUtility.requestForPermissions
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

class SetupFragment : Fragment(), EasyPermissions.PermissionCallbacks {
    private var _binding: FragmentSetupBinding? = null
    private val binding get() = _binding!!
    private lateinit var continueTv: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        continueTv = binding.continueTv

        // Request for permissions
        requestForPermissions(requireContext(), this)

        // Navigate to other screen
        continueTv.setOnClickListener {
            if (hasLocationPermissions(requireContext())) {
                val action = SetupFragmentDirections.actionSetupFragmentToRunFragment()
                findNavController().navigate(action)
            } else {
                requestForPermissions(requireContext(), this)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {
            REQUEST_PERMISSION_CODE -> { // Permission granted is the one requested
                Toast.makeText(
                    requireContext(),
                    getString(R.string.permissions_granted),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        } else {
            Toast.makeText(
                requireContext(),
                getString(R.string.permission_denied),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    // The function below is not peculiar to easy permissions, it is the android framework that gets called 
    // whenever we request for permissions we only redirect 
    // the implementation to Easy permissions to handle it for us
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        EasyPermissions.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults,
            this
        )
    }
}
