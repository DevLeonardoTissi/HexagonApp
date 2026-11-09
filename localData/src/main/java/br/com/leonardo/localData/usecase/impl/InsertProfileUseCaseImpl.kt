package br.com.leonardo.localData.usecase.impl

import br.com.leonardo.localData.model.PersonalProfile
import br.com.leonardo.localData.repository.PersonalProfileRepository
import br.com.leonardo.localData.usecase.InsertProfileUseCase

/** Implementation of [InsertProfileUseCase] delegating to [PersonalProfileRepository]. */
class InsertProfileUseCaseImpl(
    private val repository: PersonalProfileRepository,
) : InsertProfileUseCase {
    override suspend fun invoke(personalProfile: PersonalProfile) =
        repository.insert(personalProfile.copy(cpf = formatCpf(personalProfile.cpf)))
}

/** Formats a 11-digit CPF string into standard `XXX.XXX.XXX-XX` format. */
fun formatCpf(cpf: String): String = cpf.replace(Regex("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"), "$1.$2.$3-$4")
