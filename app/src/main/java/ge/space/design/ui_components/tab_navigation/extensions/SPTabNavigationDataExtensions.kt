package ge.space.design.ui_components.tab_navigation.extensions

import com.example.spacedesignsystem.R
import ge.space.ui.components.tab_navigation.data.SPTabNavigationModel

fun createNavigationWithTwoTabs(): MutableList<SPTabNavigationModel> {
    return mutableListOf<SPTabNavigationModel>().apply {
        add(
            SPTabNavigationModel(
                title = R.string.component_tab_navigation_by_card,
                image = R.drawable.ic_bank_24_regular
            )
        )
        add(
            SPTabNavigationModel(
                title = R.string.component_tab_navigation_by_number,
                image = R.drawable.ic_share_android_24_regular
            )
        )

    }
}

fun createNavigationWithThreeTabs(): MutableList<SPTabNavigationModel> {
    return mutableListOf<SPTabNavigationModel>().apply {
        add(
            SPTabNavigationModel(
                title = R.string.component_tab_navigation_by_card,
                image = R.drawable.ic_bank_24_regular
            )
        )
        add(
            SPTabNavigationModel(
                title = R.string.component_tab_navigation_by_number,
                image = R.drawable.ic_share_android_24_regular
            )
        )
        add(
            SPTabNavigationModel(
                title = R.string.component_tab_navigation_by_link,
                image = R.drawable.ic_share_android_24_regular
            )
        )
    }
}
