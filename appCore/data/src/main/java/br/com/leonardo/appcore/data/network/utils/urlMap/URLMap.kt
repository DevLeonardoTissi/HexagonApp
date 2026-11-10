package br.com.leonardo.appcore.data.network.utils.urlMap

/**
 * Interface for mapping resource-based URL paths with parameter substitution.
 */
interface URLMap {
    /**
     * Retrieves a string URL template from resources and replaces placeholders with provided parameters.
     *
     * @param pathId The string resource ID representing the URL path.
     * @param params Map of placeholder keys to substitution values.
     * @return The formatted URL string.
     */
    fun map(
        pathId: Int,
        params: Map<String, String> = mapOf(),
    ): String
}
