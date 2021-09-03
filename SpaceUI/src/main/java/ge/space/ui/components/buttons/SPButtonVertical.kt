package ge.space.ui.components.buttons

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.AttrRes
import androidx.annotation.IdRes
import androidx.annotation.StyleRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.children
import androidx.core.widget.TextViewCompat
import ge.space.extensions.setTextStyle
import ge.space.spaceui.R
import ge.space.spaceui.databinding.SpButtonVerticalBubbleLayoutBinding
import ge.space.spaceui.databinding.SpButtonVerticalLayoutBinding
import ge.space.ui.components.buttons.base.SPButtonBaseView
import ge.space.ui.components.buttons.SPButtonVertical.IconPadding
import ge.space.ui.components.buttons.SPButtonVertical.IconPadding.Large
import ge.space.ui.components.buttons.SPButtonVertical.IconPadding.Normal

/**
 * Button view extended from [LinearLayout] that allows to change its configuration.
 *
 * @property src [Int] value which applies a button image using a resource ID.
 * @property iconPadding [IconPadding] value which applies a drawable padding.
 *  This property can have a value from [IconPadding.Normal], [IconPadding.Large].
 */
class SPButtonVertical @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : SPButtonBaseView<SpButtonVerticalLayoutBinding>(context, attrs, defStyleAttr) {

    private val bubbleLayoutBinding by lazy {
        SpButtonVerticalBubbleLayoutBinding.bind(binding.root)
    }

    /**
     * Sets a image resource
     */
    @IdRes
    var src = 0
        set(value) {
            field = value

            bubbleLayoutBinding.image.setImageResource(src)
        }

    /**
     * Sets a drawable padding.
     */
    private var iconPadding = Normal
        set(value) {
            field = value

            handleDirectionArrow()
        }

    init {
        getContext().withStyledAttributes(
            attrs,
            R.styleable.sp_base_view,
            defStyleAttr
        ) {
            setButtonStyle(
                getResourceId(R.styleable.sp_base_view_style, R.style.SPButton_VerticalBase)
            )
        }

        getContext().withStyledAttributes(
            attrs,
            R.styleable.sp_button_vertical,
            defStyleAttr
        ) {
            src = getResourceId(R.styleable.sp_button_vertical_android_src, 0)
            text = getString(R.styleable.sp_button_vertical_android_text).orEmpty()
            isEnabled = getBoolean(R.styleable.sp_button_vertical_android_enabled, true)
        }
    }

    /**
     * Inflates and returns [SpButtonVerticalLayoutBinding] value
     */
    override fun getViewBinding(): SpButtonVerticalLayoutBinding =
        SpButtonVerticalLayoutBinding.inflate(LayoutInflater.from(context), this)

    /**
     * Sets a style for the SPButton view.
     *
     * <p>
     * Default style theme is SPBaseView.SPBaseButton style.
     * <p>
     *
     * @param defStyleRes [Int] style resource id
     */
    override fun setButtonStyle(@StyleRes defStyleRes: Int) {
        val styleAttrs =
            context.theme.obtainStyledAttributes(defStyleRes, R.styleable.sp_button_view_style)

        styleAttrs.run {
            val textAppearance = getResourceId(
                R.styleable.sp_button_view_style_android_textAppearance,
                DEFAULT_OBTAIN_VAL
            )
            val iconPaddingInd = getInt(
                R.styleable.sp_button_view_style_btnIconPadding, DEFAULT_ICON_PADDING
            )
            iconPadding = IconPadding.values()[iconPaddingInd]
            updateTextAppearance(textAppearance)
            recycle()
        }

    }

    override fun updateText(text: String) {
        binding.buttonLabel.text = text
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        bubbleLayoutBinding.btnContainer.children.forEach { it.isEnabled = enabled }
    }

    override fun updateTextAppearance(textAppearance: Int) =
        binding.buttonLabel.setTextStyle(textAppearance)


    private fun handleDirectionArrow() {
        val padding = when (iconPadding) {
            Normal -> resources.getDimension(R.dimen.dimen_p_8).toInt()
            Large -> resources.getDimension(R.dimen.dimen_p_16).toInt()
        }

        bubbleLayoutBinding.btnContainer.setPadding(
            padding,
            padding,
            padding,
            padding
        )
    }

    /**
     * Enum class which is for icon padding.
     *
     * @property Normal set 8dp padding.
     * @property Large set 18dp padding.
     */
    enum class IconPadding {
        Normal,
        Large
    }

    companion object {
        private const val FLOAT_ZERO = 0f
        private const val DEFAULT_ICON_PADDING = 0
    }
}