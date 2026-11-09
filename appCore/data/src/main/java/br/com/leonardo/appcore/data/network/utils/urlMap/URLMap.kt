package br.com.leonardo.appcore.data.network.utils.urlMap

/**
 * Url map
 *
 */
interface URLMap {
    /**
     * Converts
     *
     * @param pathId the path id
     * @param params
     * @return the string
     */
    fun map(
        pathId: Int,
        params: Map<String, String> = mapOf(),
    ): String
}
