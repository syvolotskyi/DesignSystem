package ge.space.design.ui_components.bank_cards.chip

import com.example.spacedesignsystem.R
import com.example.spacedesignsystem.databinding.SpItemChipBankCardShowcaseBinding
import com.example.spacedesignsystem.databinding.SpLayoutBankCardShowCaseBinding
import ge.space.design.main.SPComponentFactory
import ge.space.design.main.SPShowCaseComponent
import ge.space.design.main.util.SPShowCaseEnvironment
import ge.space.ui.components.bank_cards.chip.SPSmallEmptyBankCardView

class SPChipBankCardViewComponent : SPShowCaseComponent {
    override fun getNameResId(): Int =
        R.string.component_bank_card_views

    override fun getDescriptionResId(): Int =
        R.string.component_bank_card_views_description

    override fun getComponentClass(): Class<*>? = Factory::class.java

    class Factory : SPComponentFactory {
        override fun create(environment: SPShowCaseEnvironment): Any {
            val binding = SpLayoutBankCardShowCaseBinding.inflate(
                environment.requireLayoutInflater()
            )
            val cards = mutableListOf<SPSmallEmptyBankCardView>()

            SPChipStyles.list.forEach { bankCardSample ->
                val itemBinding = SpItemChipBankCardShowcaseBinding.inflate(
                    environment.requireThemedLayoutInflater(R.style.SPBankCardView_EmptySmall_Base),
                    binding.bankCardsLayout,
                    true
                )

                with(itemBinding.emptyChipBankCard) {
                    style = bankCardSample.style
                }

                cards.add(itemBinding.emptyChipBankCard)
            }

            return binding.root
        }
    }
}