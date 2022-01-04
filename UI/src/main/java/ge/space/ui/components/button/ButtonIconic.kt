package ge.space.ui.components.button

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import ge.space.ui.R
import ge.space.ui.components.button.base.ButtonBaseView
import ge.space.ui.databinding.ButtonIconLayoutBinding
import ge.space.ui.util.extension.getColorFromAttribute
import ge.space.ui.util.extension.handleAttributeAction

class ButtonIconic @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
    @StyleRes defStyleRes: Int = R.style.ButtonIconic
) : ButtonBaseView<ButtonIconLayoutBinding>(context, attrs, defStyleAttr) {

    private var borderColor: Int = 0
        set(value) {
            field = value
            changeBorder(borderColor, borderWidth.toFloat())
        }

    private var borderWidth: Int = context.resources.getDimensionPixelSize(R.dimen.dimen_p_1)
    private var iconColor: Int = Color.WHITE


    init {
        getContext().withStyledAttributes(
            attrs,
            R.styleable.SPBaseView,
            defStyleAttr
        ) {
            setButtonStyle(
                getResourceId(
                    R.styleable.SPBaseView_style,
                    defStyleRes
                )
            )

            isCircle = true
        }
    }

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
            withParams()
        }
    }

    private fun TypedArray.withParams() {
        getColor(
            R.styleable.ButtonIconic_iconBackgroundColor,
            Color.WHITE
        ).handleAttributeAction( Color.WHITE) {
            color = it
        }

        getColor(
            R.styleable.ButtonIconic_borderColor,
            Color.WHITE
        ).handleAttributeAction( Color.WHITE) {
            borderColor = it
        }

        getColor(
            R.styleable.ButtonIconic_iconColor,
            Color.WHITE
        ).handleAttributeAction( Color.WHITE) {
            iconColor = it
            binding.image.setColorFilter(iconColor)
        }

        getResourceId(
            R.styleable.ButtonIconic_icon,
            Color.WHITE
        ).handleAttributeAction( Color.WHITE) {
            binding.image.setImageResource(it)
        }
    }

}