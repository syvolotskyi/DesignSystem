package ge.space.ui.util.view_factory
/**
 * Interface for implementing in view which can be created from ViewFactory
 */
interface ViewFactoryData {
    /**
     * Returns a view data object.
     */
    fun getViewData(): ViewData
}