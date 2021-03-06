package ge.space.ui.components.button.base

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.viewbinding.ViewBinding
import ge.space.ui.base.BaseView

abstract class ButtonBaseView <VB : ViewBinding> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : BaseView(context, attrs, defStyleAttr) {

    /**
     * Reference to [VB] instance which is related to ViewBinding
     */
    protected val binding: VB

    /**
     * Lazy property for initialize ViewBinding in constructor
     */
    private val _binding by lazy {
        getViewBinding()
    }

    init {
        binding = _binding
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        alpha = if (enabled) {
            DEFAULT_ALPHA
        } else {
            DISABLED_ALPHA
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (!isEnabled)
            return false
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                alpha = CLICKED_ALPHA
                return true
            }
            MotionEvent.ACTION_UP -> {
                alpha = DEFAULT_ALPHA
                callOnClick()
                return false
            }
            MotionEvent.ACTION_CANCEL -> alpha = DEFAULT_ALPHA
        }
        return false
    }
    /**
     * Allows to init ViewBinding
     */
    protected abstract fun getViewBinding(): VB

    /**
     * Allows to update button style using ViewBinding
     */
    abstract fun setButtonStyle(@StyleRes defStyleRes: Int)

    companion object {
        private const val DEFAULT_ALPHA = 1f
        private const val CLICKED_ALPHA = 0.8f
        private const val DISABLED_ALPHA = 0.25f
    }
}