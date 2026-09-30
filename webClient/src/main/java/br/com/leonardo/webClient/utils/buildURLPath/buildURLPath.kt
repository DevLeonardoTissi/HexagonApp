package br.com.leonardo.webClient.utils.buildURLPath

import br.com.leonardo.webClient.source.remote.RemoteSource
import br.com.leonardo.webClient.utils.di.myInject
import br.com.leonardo.webClient.utils.urlMap.URLMap

fun RemoteSource.buildPath(
    urlID: Int,
    params: List<Pair<String, String>> = emptyList(),
    urlMap: URLMap = myInject<URLMap>()
): String {
    return urlMap.map(
        pathId = urlID,
        params = params.toMap()
    )
}
