package br.com.leonardo.appcore.data.network.utils.buildURLPath

import br.com.leonardo.appcore.data.network.source.RemoteSource
import br.com.leonardo.appcore.data.network.utils.urlMap.URLMap
import br.com.leonardo.appcore.di.module.utils.myInject

/**
 * Creates a new path on the receiver [RemoteSource]
 *
 * @param urlID the url id
 * @param params
 * @param urlMap the url map
 * @return the string
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
