package br.com.leonardo.hexagonapp.ui.screens.devProfile.sections.error

import br.com.leonardo.appcore.presentation.content.layout.section.HexagonSectionRender

data class ErrorSectionRender(
    val buttonText: String,
    val errorTexts: List<String>,
    val iconRefreshDescription: String
) : HexagonSectionRender
