package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

/**
 * 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
 * Created by link.js on 2022. 07. 12..
 */
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun `0_버튼을_누르면_화면에_0이_보여야_한다`() {
        // when : 0 버튼을 누르면
        onView(withId(R.id.button0)).perform(click())
        // then : 화면에 0이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("0")))
    }

    @Test
    fun `1_버튼을_누르면_화면에_1이_보여야_한다`() {
        // when : 1 버튼을 누르면
        onView(withId(R.id.button1)).perform(click())
        // then : 화면에 1이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun `2_버튼을_누르면_화면에_2이_보여야_한다`() {
        // when : 2 버튼을 누르면
        onView(withId(R.id.button2)).perform(click())
        // then : 화면에 2이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("2")))
    }

    @Test
    fun `3_버튼을_누르면_화면에_3이_보여야_한다`() {
        // when : 3 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        // then : 화면에 3이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }
    @Test
    fun `4_버튼을_누르면_화면에_4이_보여야_한다`() {
        // when : 4 버튼을 누르면
        onView(withId(R.id.button4)).perform(click())
        // then : 화면에 4이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("4")))
    }

    @Test
    fun `5_버튼을_누르면_화면에_5이_보여야_한다`() {
        // when : 5 버튼을 누르면
        onView(withId(R.id.button5)).perform(click())
        // then : 화면에 5이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    @Test
    fun `6_버튼을_누르면_화면에_6이_보여야_한다`() {
        // when : 6 버튼을 누르면
        onView(withId(R.id.button6)).perform(click())
        // then : 화면에 6이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("6")))
    }

    @Test
    fun `7_버튼을_누르면_화면에_7이_보여야_한다`() {
        // when : 7 버튼을 누르면
        onView(withId(R.id.button7)).perform(click())
        // then : 화면에 7이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("7")))
    }

    @Test
    fun `8_버튼을_누르면_화면에_8이_보여야_한다`() {
        // when : 8 버튼을 누르면
        onView(withId(R.id.button8)).perform(click())
        // then : 화면에 8이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("8")))
    }

    @Test
    fun `9_버튼을_누르면_화면에_9이_보여야_한다`() {
        // when : 9 버튼을 누르면
        onView(withId(R.id.button9)).perform(click())
        // then : 화면에 9이 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("9")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다`() {
        // given : 8이 적혀있는 상태에서
        onView(withId(R.id.button8)).perform(click())
        // when : 9버튼을 누르면
        onView(withId(R.id.button9)).perform(click())
        // then : 화면에 89가 보여야한다.
        onView(withId(R.id.textView)).check(matches(withText("89")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_사용자가_연산자_버튼을_누르면_해당_기호가_화면에_보여야_한다`() {
        // given : 피연산자 1이 입력된 상태에서
        onView(withId(R.id.button1)).perform(click())
        // when : 연산자 버튼 +를 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        // then : 화면에 해당 기호가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1 +")))
    }

    @Test
    fun `마지막_글자가_연산자인경우_사용자가_연산자_버튼을_누르면_기호가_바뀌어서_화면에_보여야_한다`() {
        // given : 마지막 글자가 연산자로 입력된 상태에서
        clicks(R.id.button1, R.id.buttonPlus)
        // when : 다른 연산자 버튼을 누르면
        onView(withId(R.id.buttonMinus)).perform(click())
        // then : 화면에 해당 기호가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("1 -")))
    }

    @Test
    fun `입력된_피연산자가_없을_때_사용자가_연산자_버튼을_누르면_화면에_아무런_변화가_없어야_한다`() {
        // when : 입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면
        onView(withId(R.id.buttonPlus)).perform(click())
        // then : 화면에 아무런 변화가 없어야 한다.
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `마지막_글자가_연산자인경우_사용자가_피연산자_버튼을_누르면_해당_숫자가_화면에_보여야_한다`() {
        // given : 마지막 글자가 연산자일때
        clicks(R.id.button1, R.id.buttonPlus)
        // when : 사용자가 피연산자 버튼을 누르면
        onView(withId(R.id.button3)).perform(click())
        // then : 해당 숫자가 화면에 보여야 한다
        onView(withId(R.id.textView)).check(matches(withText("1 + 3")))
    }

    @Test
    fun `입력된_수식이_없을_때_사용자가_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다`() {
        // when : 입력된 수식이 없을 때 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : 화면에 아무런 변화가 없어야 한다
        onView(withId(R.id.textView)).check(matches(withText("")))
    }

    @Test
    fun `마지막_글자가_연산자일때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자가_지워져야_한다`() {
        // given : "1 +" 가 입력 되어있을때
        clicks(R.id.button1, R.id.buttonPlus)
        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : 수식에 마지막으로 입력된 연산자가 지워져야 한다
        onView(withId(R.id.textView)).check(matches(withText("1")))
    }

    @Test
    fun `마지막_글자가_한자리_숫자일때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_숫자가_지워져야_한다`() {
        // given : "32 + 1" 이 입력 되어있을때
        clicks(R.id.button3, R.id.button2, R.id.buttonPlus, R.id.button1)
        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : "32 +"가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("32 +")))
    }

    @Test
    fun `마지막_글자가_두자리이상_숫자일때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_숫자만_지워져야_한다`() {
        // given : "32" 이 입력 되어있을때
        clicks(R.id.button3, R.id.button2)
        // when : 사용자가 지우기 버튼을 누르면
        onView(withId(R.id.buttonDelete)).perform(click())
        // then : "3"가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("3")))
    }

    @Test
    fun `입력된_수식이_완전할_때_사용자가_equals_버튼을_누르면_입력된_수식의_결과가_화면에_보여야_한다`() {
        // given : "3 + 2" 이 입력 되어있을때
        clicks(R.id.button3, R.id.buttonPlus, R.id.button2)
        // when : 사용자가 = 버튼을 누르면
        onView(withId(R.id.buttonEquals)).perform(click())
        // then : "5"가 보여야 한다.
        onView(withId(R.id.textView)).check(matches(withText("5")))
    }

    private fun clicks(vararg ids: Int) {
        ids.forEach {
            onView(withId(it)).perform(click())
        }
    }
}