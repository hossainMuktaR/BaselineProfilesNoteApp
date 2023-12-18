package com.example.benchmark

import androidx.benchmark.macro.MacrobenchmarkScope
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BaselineProfileGenerator {


    @get:Rule
    val rule = BaselineProfileRule()

    @Test
    fun generateBaselineProfile() = rule.collect(
        packageName = "com.example.noteapp_architecture_sample"
    ) {
        pressHome()
        startActivityAndWait()

        goAddEditNoteAndWait()
    }

    private fun MacrobenchmarkScope.goAddEditNoteAndWait() {
        device.wait(Until.hasObject(By.text("Your Note")), 5_000)
        val faButton = device.findObject(By.res("Button:FA"))
        faButton.click()
        device.wait(Until.hasObject(By.res("button:FA")), 5_000)
    }
}