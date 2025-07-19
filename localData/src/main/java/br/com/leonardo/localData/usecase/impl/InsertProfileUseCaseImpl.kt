package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.InsertProfileUseCase

class InsertProfileUseCaseImpl(private val repository: PersonalProfileRepository) :
    InsertProfileUseCase {
    override suspend fun invoke(personalProfile: PersonalProfile) =
        repository.insert(personalProfile.copy(cpf = formatCpf(personalProfile.cpf)))
}

fun formatCpf(cpf: String): String =
    cpf.replace(Regex("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"), "$1.$2.$3-$4")