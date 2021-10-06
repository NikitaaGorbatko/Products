package nikitagorbatko.example.products.ui

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

private const val REQUEST_PERMISSION_PHONE_STATE = 1

object PermissionManager {
    private lateinit var context: Context
    private lateinit var activity: Activity

    fun showPhoneStatePermission(context_param: Context, activity_param: Activity) {
        context = context_param
        activity = activity_param
        val permissionCheck = ContextCompat.checkSelfPermission(
            context, Manifest.permission.READ_CONTACTS
        )
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    activity,
                    Manifest.permission.READ_CONTACTS
                )
            ) {
                showExplanation("Permission Needed", "Rationale", Manifest.permission.READ_CONTACTS, REQUEST_PERMISSION_PHONE_STATE, context
                )
            } else {
                requestPermission(Manifest.permission.READ_CONTACTS, REQUEST_PERMISSION_PHONE_STATE)
            }
        } else {
            Toast.makeText(activity, "Permission (already) Granted!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showExplanation(
        title: String,
        message: String,
        permission: String,
        permissionRequestCode: Int,
        context: Context
    ) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(
                android.R.string.ok
            ) { dialog, id -> requestPermission(permission, permissionRequestCode) }
        builder.create().show()
    }

    private fun requestPermission(permissionName: String, permissionRequestCode: Int) {
        ActivityCompat.requestPermissions(activity, arrayOf(permissionName), permissionRequestCode)
    }


    //    fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String?>?,
//        grantResults: IntArray
//    ) {
//        when (requestCode) {
//            REQUEST_PERMISSION_PHONE_STATE -> if (grantResults.size > 0
//                && grantResults[0] == PackageManager.PERMISSION_GRANTED
//            ) {
//                Toast.makeText(this@MainActivity, "Permission Granted!", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(this@MainActivity, "Permission Denied!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

}