package ge.space.ui.base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.annotation.AttrRes
import ge.space.spaceui.R
import ge.space.spaceui.databinding.SpAddBankButtonLayoutBinding
import ge.space.ui.components.bank_cards.data.SPChipBankCardSize
import ge.space.ui.util.extension.heightByIsBig
import ge.space.ui.util.extension.widthByIsBig

/**
 * Comment
 */
abstract class SPBaseChipIcon @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0
) : SPBaseView(context, attrs, defStyleAttr) {

    /**
     * Comment
     */
    var cardSize : SPChipBankCardSize = SPChipBankCardSize.Big
        set(value) {
            field = value

            handleCardAppearance()
        }

    /**
     * Comment
     */
    protected val isBig
        get() = cardSize == SPChipBankCardSize.Big

    /**
     * Comment
     */
    protected val binding by lazy {
        getAddBankButtonLayoutBinding()
    }

    private fun handleCardAppearance() {
        setImageSize()
        val style = getStyle()
        setStyle(style)
        setSize()
    }

    private fun getAddBankButtonLayoutBinding() =
        SpAddBankButtonLayoutBinding.inflate(LayoutInflater.from(context), this)

    private fun getStyle() = if (isBig) R.style.SPBankCardView_Chip
        else R.style.SPBankCardView_Chip_Small

    protected open fun setImageSize() { }

    private fun setSize() {
        widthByIsBig(isBig, R.dimen.sp_bank_chip_width, R.dimen.sp_bank_chip_width_small)
        heightByIsBig(isBig, R.dimen.sp_bank_chip_height, R.dimen.sp_bank_chip_height_small)
    }
}