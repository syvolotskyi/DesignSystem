package ge.space.ui.util.view_factory

import android.content.Context
import android.view.View
import ge.space.ui.util.view_factory.component_type.image.ImageUrlImpl

interface ViewFactory {
    companion object {
        /**
         * Returns a view object.
         */
        fun ViewData.createView(context: Context): View {
            return when (this) {
                is ViewData.SPImageUrlData -> ImageUrlImpl(context).create(this)
            }
        }
    }
}

