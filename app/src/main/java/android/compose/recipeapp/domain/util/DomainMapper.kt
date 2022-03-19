package android.compose.recipeapp.domain.util

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel

    fun mapFromDomainModel(domain: DomainModel): T
}