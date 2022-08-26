package com.example.testeandroidsicredi.UnitTest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.testeandroidsicredi.model.Event
import com.example.testeandroidsicredi.repository.EventRepository
import com.example.testeandroidsicredi.viewModel.EventViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class EventsViewModelTest {
    @get:Rule
    var instantExecutingRule = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    var mainCoroutineRule = TestCoroutineDispatcher()

    lateinit var viewModel: EventViewModel

    @Mock
    lateinit var repository: EventRepository

    @Mock
    lateinit var eventList: List<Event>

    @Mock
    lateinit var event: Event

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(mainCoroutineRule)
        viewModel = EventViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `return the list of event from api`() =
        mainCoroutineRule.runBlockingTest {
            Mockito.`when`(repository.getEvents()).thenReturn(eventList)
            viewModel.getEventList()
            Assert.assertEquals(viewModel.event.value, eventList)
        }

    @Test
    fun `return event by id from api`() =
        mainCoroutineRule.runBlockingTest {
            Mockito.`when`(repository.getEventDetail("1")).thenReturn(event)
            viewModel.getEventDetail("1")
            Assert.assertEquals(viewModel.event.value, event)
        }
}