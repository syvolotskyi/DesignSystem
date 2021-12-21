package ge.space.design.main

import ge.space.design.main.util.ShowCaseEnvironment

interface ComponentFactory {
    /**
     * Returns a component object.
     *
     * The following types are supported:
     * Intent,
     * Fragment (DialogFragment),
     * Dialog,
     * View,
     * LaunchAction
     */
    fun create(environment: ShowCaseEnvironment): Any
}