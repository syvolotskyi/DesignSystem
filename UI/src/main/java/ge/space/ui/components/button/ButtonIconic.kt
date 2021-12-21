package ge.space.ui.components.button

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import ge.space.ui.R
import ge.space.ui.components.button.base.ButtonBaseView
import ge.space.ui.databinding.ButtonIconLayoutBinding

class ButtonIconic @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : ButtonBaseView<ButtonIconLayoutBinding>(context, attrs, defStyleAttr) {

    override fun getViewBinding(): ButtonIconLayoutBinding =
        ButtonIconLayoutBinding.inflate(LayoutInflater.from(context), this)

    /**
     * Sets a style for the Button view.
     *
     * @param defStyleRes [Int] style resource id
     */
    override fun setButtonStyle(@StyleRes defStyleRes: Int) {
        val styleAttrs =
            context.theme.obtainStyledAttributes(defStyleRes, R.styleable.ButtonIconic)

        styleAttrs.run {
            TODO("Not yet implemented")
        }
    }

    override fun updateText(text: String) {
        TODO("Not yet implemented")
    }
}