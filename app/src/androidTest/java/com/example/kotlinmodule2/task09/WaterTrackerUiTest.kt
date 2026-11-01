package com.example.kotlinmodule2.task09

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.kotlinmodule2.task08.WaterTracker
import com.example.kotlinmodule2.ui.theme.KotlinModule2Theme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WaterTrackerUiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            KotlinModule2Theme {
                WaterTracker()
            }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) {
            composeTestRule.onNodeWithText("+250 мл").performClick()
        }
    }

    @Test
    fun addWaterButton_existsAndAdds250() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()

        addWater(1)
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()

        addWater(1)
        composeTestRule.onNodeWithText("500 мл").assertIsDisplayed()
    }

    @Test
    fun finishDayButton_existsAndResetsWater() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()

        addWater(3)
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()

        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
    }

    @Test
    fun daysText_isDisplayedAndCountsCorrectly() {
        composeTestRule.onNodeWithText("Дней подряд с нормой 1500 мл: 0").assertIsDisplayed()

        addWater(6)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с нормой 1500 мл: 1").assertIsDisplayed()

        addWater(7)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с нормой 1500 мл: 2").assertIsDisplayed()

        addWater(2)
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("Дней подряд с нормой 1500 мл: 0").assertIsDisplayed()
    }
}
