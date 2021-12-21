package ge.space.ui.util.view_factory.component_type.image

import android.content.Context
import android.widget.ImageView
import ge.space.ui.util.extension.loadRoundImageUrl
import ge.space.ui.util.view_factory.ViewData
import ge.space.ui.util.view_factory.view.ViewImpl

class ImageUrlImpl(context: Context) : ViewImpl<ViewData.SPImageUrlData>(context) {
    override fun create(type: ViewData.SPImageUrlData): ImageView {
        return ImageView(context).apply {
            context.loadRoundImageUrl(type.url, this, type.roundedCorners.toInt())
        }
    }
}