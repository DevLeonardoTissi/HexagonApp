package br.com.leonardo.webClient.utils.urlMap.impl

import android.content.Context
import br.com.leonardo.webClient.utils.urlMap.URLMap

class URLMapImpl(
    private val context: Context
) : URLMap {
    override fun map(
        pathId: Int,
        params: Map<String, String>
    ) = with(context.resources) {
        val baseUrl = getString(pathId)
        params.entries.fold(initial = baseUrl) { url, (key, value) ->
            url.replace(oldValue = "{$key}", newValue = value)
        }
    }
}