import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.touchandtest.presentation.viewmodel.ScreenTestViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class ScreenTestViewModelTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    @Inject
    lateinit var viewModel: ScreenTestViewModel

    @Mock
    private lateinit var timeOutMessageObserver: Observer<String?>

    @Mock
    private lateinit var enabledButtonObserver: Observer<Boolean>

    @Before
    fun setUp() {
        hiltRule.inject()
        MockitoAnnotations.initMocks(this)
        viewModel.timeOutMessage.observeForever(timeOutMessageObserver)
        viewModel.enabledButton.observeForever(enabledButtonObserver)
    }

    @After
    fun tearDown() {
        viewModel.timeOutMessage.removeObserver(timeOutMessageObserver)
        viewModel.enabledButton.removeObserver(enabledButtonObserver)
    }

    @Test
    fun `GIVEN all squares clicked WHEN checking squares clicked THEN button should be enabled`() =
        runBlockingTest(testDispatcher) {
            repeat(viewModel.totalSquares) {
                viewModel.incrementSquareCount()
            }

            val result = viewModel.isAllSquaresClicked()

            assertEquals(true, result)
            Mockito.verify(enabledButtonObserver).onChanged(true)
        }

    @Test
    fun `GIVEN not all squares clicked WHEN checking squares clicked THEN button should remain disabled`() =
        runBlockingTest(testDispatcher) {
            repeat(viewModel.totalSquares - 1) {
                viewModel.incrementSquareCount()
            }

            val result = viewModel.isAllSquaresClicked()

            assertEquals(false, result)
            Mockito.verify(enabledButtonObserver, Mockito.never()).onChanged(true)
        }

    @Test
    fun `GIVEN test completed WHEN handling test result and squares clicked THEN show success message`() =
        runBlockingTest(testDispatcher) {

            repeat(viewModel.totalSquares) {
                viewModel.incrementSquareCount()
            }

            viewModel.handleTestResult()

            Mockito.verify(timeOutMessageObserver).onChanged("O Teste Passou")
        }

    @Test
    fun `GIVEN test completed WHEN handling test result and squares not clicked THEN show failure message`() =
        runBlockingTest(testDispatcher) {
            repeat(viewModel.totalSquares - 1) {
                viewModel.incrementSquareCount()
            }

            viewModel.handleTestResult()

            Mockito.verify(timeOutMessageObserver).onChanged("O Teste Falhou")
        }
}
