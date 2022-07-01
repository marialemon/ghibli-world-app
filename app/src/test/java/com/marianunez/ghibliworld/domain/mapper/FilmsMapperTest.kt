package com.marianunez.ghibliworld.domain.mapper

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.marianunez.ghibliworld.domain.model.mapper.toModel
import com.marianunez.ghibliworld.fakedata.fakeFilmsModel1
import com.marianunez.ghibliworld.fakedata.fakeFilmsResponse1
import org.junit.Test

class FilmsMapperTest {

    @Test
    fun should_return_Model_from_Response() {
        val actual = fakeFilmsResponse1.toModel()
        assertThat(actual).isEqualTo(fakeFilmsModel1)
    }
}