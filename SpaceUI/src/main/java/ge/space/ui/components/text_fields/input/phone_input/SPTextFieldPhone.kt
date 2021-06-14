package ge.space.ui.components.text_fields.input.phone_input

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.annotation.AttrRes
import ge.space.spaceui.R
import ge.space.ui.components.text_fields.input.base.SPTextFieldBaseView

/**
 * Field view extended from [SPTextFieldBaseView] that allows
 * to change EditorAction and sets the mask.
 *
 */
class SPTextFieldPhone @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : SPTextFieldBaseView(context, attrs, defStyleAttr) {

    init {
        binding.etInputField.mask = resources.getString(R.string.phone_mask)
    }

    /** @param listener - its onFocusChange() method will be called before performing MaskedEditText operations,
     * related to this event.
     */
    override fun setOnFocusChangeListener(listener: OnFocusChangeListener) {
        binding.etInputField.onFocusChangeListener = listener
    }

    fun setOnEditorActionListener(listener: TextView.OnEditorActionListener) {
        with(binding.etInputField) {
            setImeActionEnabled(true)
            onActionListener = listener
        }
    }


}