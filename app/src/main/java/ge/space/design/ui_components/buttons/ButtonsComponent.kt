package ge.space.design.ui_components.buttons

import com.example.spacedesignsystem.R
import com.example.spacedesignsystem.databinding.LayoutButtonShowcaseBinding
import ge.space.design.main.ComponentFactory
import ge.space.design.main.ShowCaseComponent
import ge.space.design.main.util.ShowCaseEnvironment


class ButtonsComponent : ShowCaseComponent {

    override fun getNameResId(): Int = R.string.buttons

    override fun getDescriptionResId(): Int = R.string.button_description

    override fun getComponentClass(): Class<*> = SPFactory::class.java

    class SPFactory : ComponentFactory {
        override fun create(environment: ShowCaseEnvironment): Any {
            val layoutBinding = LayoutButtonShowcaseBinding.inflate(
                environment.requireLayoutInflater()
            )


            return layoutBinding.root
        }
    }
}