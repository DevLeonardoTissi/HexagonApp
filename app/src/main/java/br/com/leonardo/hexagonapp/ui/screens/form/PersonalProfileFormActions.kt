package br.com.leonardo.hexagonapp.ui.screens.form

import br.com.leonardo.ui.action.HexagonAction

sealed class PersonalProfileFormActions : HexagonAction() {

    class FieldNameChanged(val value: String): PersonalProfileFormActions()
    class FieldCPFChanged(val value: String): PersonalProfileFormActions()
    class FieldCityChanged(val value: String): PersonalProfileFormActions()
    class FieldDateOfBirthChangedChanged(val value: Long): PersonalProfileFormActions()
    class InsertPhoto(val value: String): PersonalProfileFormActions()
    class OnSwitchChange(val value: Boolean): PersonalProfileFormActions()
    object SaveButtonClick: PersonalProfileFormActions()
    object InputDateClick: PersonalProfileFormActions()
    object ModalConfirmClick: PersonalProfileFormActions()
    object ModalDismiss: PersonalProfileFormActions()
    object DismissDatePicker: PersonalProfileFormActions()


}