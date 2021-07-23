package ge.space.ui.util.view_factory.component_type.chip

import android.content.Context
import ge.space.ui.components.bank_cards.chip.icon.SPChipIcon
import ge.space.ui.util.view_factory.SPViewData
import ge.space.ui.util.view_factory.component_type.SPViewComponentType

class SPChipIconImpl(context: Context) :
    SPViewComponentType<SPViewData.SPChipData>(context) {

    override fun create(type: SPViewData.SPChipData): SPChipIcon {
        return SPChipIcon(context).apply {
            size = type.chipSize
            icon = type.drawableRes
        }
    }
}