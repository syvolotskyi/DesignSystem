package ge.space.ui.util.view_factory.view

import android.content.Context
import android.view.View
import ge.space.ui.util.view_factory.ViewData

abstract class ViewImpl<T : ViewData>(val context: Context) {
    abstract fun create(type: T): View
}
