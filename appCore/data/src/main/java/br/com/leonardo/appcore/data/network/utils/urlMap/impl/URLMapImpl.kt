package br.com.leonardo.appcore.data.network.utils.urlMap.impl

import android.content.Context
import br.com.leonardo.appcore.data.network.utils.urlMap.URLMap

/**
 * Implementation of [URLMap] that reads URL templates from Android resources
 * and replaces template placeholders (e.g., `{id}`) with map values.
 *
 * @property context The Android [Context] used to access resources.
 */
class URLMapImpl(
    private val context: Context,
) : URLMap {
    /**
     * Maps a resource string ID to a formatted URL string by substituting parameters.
     *
     * @param pathId The string resource ID of the URL template.
     * @param params Map of keys and values to replace in the URL template.
     * @return The resulting formatted URL string.
     */
    override fun map(
        pathId: Int,
        params: Map<String, String>,
    ) = with(context.resources) {
        val baseUrl = getString(pathId)
        params.entries.fold(initial = baseUrl) { url, (key, value) ->
            url.replace(oldValue = "{$key}", newValue = value)
        }
    }
}
