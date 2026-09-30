package br.com.leonardo.webClient.utils.urlMap

interface URLMap {

    fun map (pathId: Int, params: Map<String, String> = mapOf()): String

}