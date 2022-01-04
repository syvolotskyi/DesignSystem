package ge.space.ui.util.view_factory

import android.os.Parcelable
import android.view.Gravity
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import kotlinx.parcelize.Parcelize

sealed class ViewData : Parcelable {

    @Parcelize
    data class SPImageUrlData(
        val url: String,
        var roundedCorners: Float = 0f
    ) : ViewData()

    @Parcelize
    data class SPViewDataParams(
        var height: Int? = null,
        var width: Int? = null,
        var gravity: Int = Gravity.CENTER,
        var paddingStart: Int = 0,
        var paddingEnd: Int = 0,
        var paddingTop: Int = 0,
        var paddingBottom: Int = 0,
    ) :
        Parcelable
}