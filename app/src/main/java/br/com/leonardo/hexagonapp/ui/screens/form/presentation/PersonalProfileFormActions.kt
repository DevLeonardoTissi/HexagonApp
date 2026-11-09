package br.com.leonardo.hexagonapp.ui.screens.form.presentation

import br.com.leonardo.appcore.presentation.action.HexagonAction

/** Actions emitted from Personal Profile Form screen UI. */
sealed class PersonalProfileFormActions : HexagonAction() {
    /** Action triggered when name text field changes. */
    class FieldNameChanged(
        val value: String,
    ) : PersonalProfileFormActions()

    /** Action triggered when CPF text field changes. */
    class FieldCPFChanged(
        val value: String,
    ) : PersonalProfileFormActions()

    /** Action triggered when city text field changes. */
    class FieldCityChanged(
        val value: String,
    ) : PersonalProfileFormActions()

    /** Action triggered when birth date picker selection changes. */
    class FieldDateOfBirthChangedChanged(
        val value: Long,
    ) : PersonalProfileFormActions()

    /** Action triggered when profile photo URL is provided. */
    class InsertPhoto(
        val value: String,
    ) : PersonalProfileFormActions()

    /** Action triggered when active switch status toggles. */
    class OnSwitchChange(
        val value: Boolean,
    ) : PersonalProfileFormActions()

    /** Action triggered when save button is clicked. */
    object SaveButtonClick : PersonalProfileFormActions()

    /** Action triggered when birth date input is clicked. */
    object InputDateClick : PersonalProfileFormActions()

    /** Action triggered when modal confirmation is clicked. */
    object ModalConfirmClick : PersonalProfileFormActions()

    /** Action triggered when modal confirmation is dismissed. */
    object ModalDismiss : PersonalProfileFormActions()

    /** Action triggered when date picker dialog is dismissed. */
    object DismissDatePicker : PersonalProfileFormActions()
}
