package ge.space.ui.util.view_factory.component_type

import android.content.Context
import android.view.View
import ge.space.ui.util.view_factory.ViewData

abstract class ViewComponentType<T : ViewData>(val context: Context) {
    abstract fun create(type: T): View
}