package net.subroh0508.data.infra

import net.subroh0508.data.model.Idol

interface IdolsRepository {
    suspend fun search(query: String?): List<Idol>
}
