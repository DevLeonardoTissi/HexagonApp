package br.com.leonardo.hexagonapp.ui.screens.form

import br.com.leonardo.localData.usecase.GetProfileByIdUseCase
import br.com.leonardo.localData.usecase.InsertProfileUseCase
import br.com.leonardo.ui.viewmodel.HexagonViewModel

class PersonalProfileFormViewModel(
    private val insertProfileUseCase: InsertProfileUseCase,
    private val getProfileByIdUseCase: GetProfileByIdUseCase,
    id: String? = null
) : HexagonViewModel<
        PersonalProfileFormActions,
        PersonalProfileFormState,
        PersonalProfileFormData,
        PersonalProfileFormUIState,
        PersonalProfileFormUiData>() {

    override val data = PersonalProfileFormData(initialState = PersonalProfileFormState())
    override val uiData = PersonalProfileFormUiData(initialState = PersonalProfileFormUIState())

    override fun handleAction(action: PersonalProfileFormActions) {
        when (action) {
            is PersonalProfileFormActions.FieldNameChanged -> handleFieldNameChangedAction(action)
            is PersonalProfileFormActions.FieldCPFChanged -> handleFieldCPFChangedAction(action)
            is PersonalProfileFormActions.FieldCityChanged -> handleFieldCityChangedAction(action)
            is PersonalProfileFormActions.FieldDateOfBirthChangedChanged -> handleFieldDateOfBirthChangedAction(
                action
            )

            is PersonalProfileFormActions.InsertPhoto -> handleInsertPhotoAction(action)
            is PersonalProfileFormActions.OnSwitchChange -> handleOnSwitchChangeAction(action)
            is PersonalProfileFormActions.SaveButtonClick -> handleSaveButtonClickAction(action)
            is PersonalProfileFormActions.InputDateClick -> handleInputDateClickAction(action)
            is PersonalProfileFormActions.ModalConfirmClick -> handleModalConfirmClickAction()
            is PersonalProfileFormActions.ModalDismiss -> handleModalDismissAction()
            is PersonalProfileFormActions.DismissDatePicker -> handleDismissDatePickerAction(action)
        }
    }

    private fun handleFieldNameChangedAction(action: PersonalProfileFormActions.FieldNameChanged) {
        data.updateName(action.value)
    }

    private fun handleFieldCPFChangedAction(action: PersonalProfileFormActions.FieldCPFChanged) {
        data.updateCpf(action.value)
    }

    private fun handleFieldCityChangedAction(action: PersonalProfileFormActions.FieldCityChanged) {
        data.updateCity(action.value)
    }

    private fun handleFieldDateOfBirthChangedAction(action: PersonalProfileFormActions.FieldDateOfBirthChangedChanged) {
        data.updateDateOfBirth(action.value)
    }

    private fun handleInsertPhotoAction(action: PersonalProfileFormActions.InsertPhoto) {
        data.updatePhoto(action.value)
    }

    private fun handleOnSwitchChangeAction(action: PersonalProfileFormActions.OnSwitchChange) {
        data.updateActive(action.value)
    }

    private fun handleSaveButtonClickAction(action: PersonalProfileFormActions.SaveButtonClick) {
        if (checkFields()) {
            uiData.updateConfirmDialogVisibility(true)
        }

    }

    private fun handleInputDateClickAction(action: PersonalProfileFormActions.InputDateClick) {
        uiData.updateDatePickerVisibility(true)
    }

    private fun handleModalConfirmClickAction() {
        uiData.updateConfirmDialogVisibility(false)
        insert()
        navigator.goBack()
    }

    private fun handleModalDismissAction() {
        uiData.updateConfirmDialogVisibility(false)
    }


    private fun handleDismissDatePickerAction(action: PersonalProfileFormActions.DismissDatePicker) {
        uiData.updateDatePickerVisibility(false)
    }


    init {
        id?.let {
            searchById(it)
        }
    }

    private fun searchById(id: String) {
        executeBlock(
            block = {
                with(getProfileByIdUseCase(id = id)) {
                    this?.let {
                        data.updateUserProfile(this)
                    } ?: navigator.goBack()
                }
            }
        )
    }

    private fun invalidCpf(cpf: String): Boolean = cpf.isBlank() || cpf.length != 11

    private fun checkFields(): Boolean {
        val fieldsToCheck = listOf(
            Pair(data.getUserName().isBlank()) { isError: Boolean ->
                uiData.setFieldNameError(isError)
            },
            Pair(invalidCpf(data.getUserCpf())) { isError: Boolean ->
                uiData.setFieldCPFError(isError)
            },
            Pair(data.getUserCity().isBlank()) { isError: Boolean ->
                uiData.setFieldCityError(isError)
            },
            Pair(data.getUserDateOfBirth() == 0L) { isError: Boolean ->
                uiData.setFieldDateOfBirthError(isError)
            }
        )

        var allOk = true

        fieldsToCheck.forEach { (isBlank, setError) ->
            if (isBlank) {
                setError(true)
                allOk = false
            } else {
                setError(false)
            }
        }
        return allOk
    }

    private fun insert() {
        executeBlock(
            block = {
                insertProfileUseCase(data.getUserInfo())
            }
        )
    }
}