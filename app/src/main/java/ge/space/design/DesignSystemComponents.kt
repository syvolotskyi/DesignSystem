package ge.space.design

import com.example.spacedesignsystem.R
import ge.space.design.main.ShowCaseComponent
import ge.space.design.ui_components.buttons.ButtonsComponent

object DesignSystemComponents : ShowCaseComponent {

    override fun getNameResId(): Int = R.string.all_component

    override fun getDescriptionResId(): Int = R.string.all_component_description

    override fun getDescriptionFormatArgs(): Array<Any> = arrayOf(1)

    override fun getSubComponents(): List<ShowCaseComponent> {
        return listOf(
            new { ButtonsComponent() }
        )
    }
}

/**
 * If you want component with "new" badge use [new].
 */
inline fun <reified T : ShowCaseComponent> new(block: () -> T): T =
    block().also { NEW_COMPONENTS.add(T::class.java) }

val NEW_COMPONENTS = mutableSetOf<Class<out ShowCaseComponent>>()