package com.example.testproject2_06_09_2026.viewmodel

import app.cash.turbine.test
import com.example.testproject2_06_09_2026.data.errormapper.ErrorMapper
import com.example.testproject2_06_09_2026.domain.model.Address
import com.example.testproject2_06_09_2026.domain.model.Company
import com.example.testproject2_06_09_2026.domain.model.Users
import com.example.testproject2_06_09_2026.domain.usecase.UserUseCase
import com.example.testproject2_06_09_2026.presentation.ui.screens.UserUiState
import com.example.testproject2_06_09_2026.presentation.ui.screens.toAppErrorMessage
import com.example.testproject2_06_09_2026.presentation.viewmodel.UserViewmodel
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserViewmodelTest {

    val testDispatcher = StandardTestDispatcher()

    lateinit var classToTest: UserViewmodel

    private val useCase: UserUseCase = mockk()
    private val error: ErrorMapper = mockk()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        classToTest = UserViewmodel(useCase,error)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    /*@Test
    fun `test when api returns success response`() = runTest {
        val mockUser: Result<List<Users>> = Result<List<Users>>(
            Users(
                id = 1,
                name = "Meera",
                address = Address("Pune"),
                company = Company("CG"),
                email = "meera@gmail.com"
            )
        )


        coEvery { useCase() } returns mockUser

        classToTest.uiState.test {
            Assert.assertTrue(awaitItem() is UserUiState.Loading)
            val success = awaitItem()
            Assert.assertTrue(success is UserUiState.Success)
            success as UserUiState.Success
            Assert.assertEquals(mockUser, success.data)
            Assert.assertEquals(1, success.data.size)
            cancelAndIgnoreRemainingEvents()
            coVerify(exactly = 1) { useCase() }
        }
    }
*/
    @Test
    fun `test when api fails and returns exception`() = runTest {
        val exception = RuntimeException("Network Error")
        coEvery { useCase() } throws exception //returns flow { throw exception }

        classToTest.uiState.test {
            Assert.assertTrue(awaitItem() is UserUiState.Loading)
            val failure = awaitItem()
            Assert.assertTrue(failure is UserUiState.Error)
            failure as UserUiState.Error
            Assert.assertEquals(exception.message,failure.error.toAppErrorMessage() /*failure.throwable.message*/)

            coVerify(exactly = 1) { useCase() }
        }
    }
}