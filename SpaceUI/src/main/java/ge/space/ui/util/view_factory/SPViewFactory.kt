package ge.space.ui.util.view_factory

import android.content.Context
import android.view.View
import android.widget.ImageView
import ge.space.ui.util.view_factory.component_type.chip.SPDigitalChipIconImpl
import ge.space.ui.util.view_factory.component_type.chip.SPEmptyChipIconImpl
import ge.space.ui.util.view_factory.component_type.chip.SPPrimaryChipIconImpl
import ge.space.ui.util.view_factory.component_type.chip.SPSecondaryChipIconImpl
import ge.space.ui.util.extension.fromResource
import ge.space.ui.util.view_factory.component_type.image.SPImageResImpl
import ge.space.ui.util.view_factory.component_type.image.SPImageUrlImpl
import ge.space.ui.util.view_factory.component_type.card.SPNewCreditCardImpl

interface SPViewFactory {
    companion object {
        /**
         * Returns a view object.
         */
        fun SPViewData.createView(context: Context): View {
            return when (this) {
                is SPViewData.SPImageResourcesData -> SPImageResImpl(context).create(this)
                //TODO() Should Delete SPImageDefaultResourcesData
                is SPViewData.SPImageDefaultResourcesData -> ImageView(context).fromResource(res)
                is SPViewData.SPImageUrlData -> SPImageUrlImpl(context).create(this)
                is SPViewData.SPrimaryChip -> SPPrimaryChipIconImpl(context).create(this)
                is SPViewData.SPSecondaryChip -> SPSecondaryChipIconImpl(context).create(this)
                is SPViewData.SPDigitalChip -> SPDigitalChipIconImpl(context).create(this)
                is SPViewData.SPEmptyChip -> SPEmptyChipIconImpl(context).create(this)
                is SPViewData.SPNewCreditCards -> SPNewCreditCardImpl(context).create(this)
            }
        }
    }
}
