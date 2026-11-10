package br.com.leonardo.appcore.data.network.utils.buildURLPath

import br.com.leonardo.appcore.data.network.source.RemoteSource
import br.com.leonardo.appcore.data.network.utils.urlMap.URLMap
import br.com.leonardo.appcore.di.module.utils.myInject

/**
 * Extension function on [RemoteSource] to build a parameterized URL path string
 * from string resource IDs and parameter maps.
 *
 * @param urlID Resource ID of the string URL template.
 * @param params List of key-value pairs to substitute into the URL template placeholders.
 * @param urlMap [URLMap] service used to map and format the path.
 * @return The formatted URL string.
 */
fun RemoteSource.buildPath(
    urlID: Int,
    params: List<Pair<String, String>> = emptyList(),
    urlMap: URLMap = myInject<URLMap>(),
): String =
    urlMap.map(
        pathId = urlID,
        params = params.toMap(),
    )
