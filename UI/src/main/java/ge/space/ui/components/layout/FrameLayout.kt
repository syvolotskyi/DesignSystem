package ge.space.ui.components.layout

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import ge.space.ui.base.BaseView

/**
 * Simple extended view from [BaseView] which has no any additional properties.
 */
class FrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : BaseView(context, attrs, defStyleAttr)