package br.com.leonardo.webClient.utils.urlMap

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
    fun map (pathId: Int, params: Map<String, String> = mapOf()): String

}
