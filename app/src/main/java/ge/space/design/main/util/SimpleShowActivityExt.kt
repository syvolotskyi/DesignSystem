package ge.space.design.main.util

import ge.space.design.main.ui.BaseActivity

fun BaseActivity.showThemeCustomDialog() {
    fun updateTheme(theme: AppTheme) {
        preferencesManager.edit().apply {
            putInt(BaseActivity.PREFERENCES_THEME, theme.ordinal)
            apply()
        }
        recreate()
    }
}