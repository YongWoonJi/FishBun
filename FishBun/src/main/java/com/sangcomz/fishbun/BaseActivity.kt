package com.sangcomz.fishbun

import android.os.Build
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.sangcomz.fishbun.Fishton.Companion.getInstance
import com.sangcomz.fishbun.permission.PermissionCheck
import com.sangcomz.fishbun.util.CameraUtil

abstract class BaseActivity : AppCompatActivity() {

    protected val cameraUtil: CameraUtil by lazy { CameraUtil() }
    protected val permissionCheck: PermissionCheck by lazy { PermissionCheck(this) }
    protected val fishton: Fishton by lazy { getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)
        }
        super.onCreate(savedInstanceState)
    }

    companion object {
        const val PERMISSION_STORAGE = 28
        const val PERMISSION_CAMERA = 29
        const val TRANS_IMAGES_RESULT_CODE = 29
        const val TAKE_A_PICK_REQUEST_CODE = 128
        const val ENTER_ALBUM_REQUEST_CODE = 129
        const val ENTER_DETAIL_REQUEST_CODE = 130

        const val INTENT_ADD_PATH = "intent_add_path"
        const val INTENT_POSITION = "intent_position"

        const val SAVE_INSTANCE_NEW_IMAGES = "instance_new_images"
        const val SAVE_INSTANCE_SAVED_IMAGE = "instance_saved_image"
    }
}