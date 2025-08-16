package com.nui.switchview

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.widget.CompoundButton
import com.facebook.react.bridge.ReactContext
import com.facebook.react.module.annotations.ReactModule
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.google.android.material.materialswitch.MaterialSwitch
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.PixelUtil
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.viewmanagers.NUISwitchManagerDelegate
import com.facebook.react.viewmanagers.NUISwitchManagerInterface
import com.facebook.yoga.YogaMeasureMode
import com.facebook.yoga.YogaMeasureOutput

@ReactModule(name = NUISwitchManager.NAME)
class NUISwitchManager : SimpleViewManager<MaterialSwitch>(),
  NUISwitchManagerInterface<MaterialSwitch> {
  private val mDelegate: ViewManagerDelegate<MaterialSwitch> = NUISwitchManagerDelegate(this)

  override fun getDelegate(): ViewManagerDelegate<MaterialSwitch> {
    return mDelegate
  }

  override fun getName(): String {
    return NAME
  }

  public override fun createViewInstance(context: ThemedReactContext): MaterialSwitch {
    return MaterialSwitch(context).apply { showText = false }
  }

  override fun setValue(
    view: MaterialSwitch?,
    value: Boolean
  ) {
    if (view == null) return

    view.setOnCheckedChangeListener(null)
    view.isChecked = value
    view.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER)
  }

  override fun setIcon(
    view: MaterialSwitch?,
    value: String?
  ) {
    if (view == null) return

    if (value == null) {
      view.thumbIconDrawable = null
    } else {
      val iconFinder = IconFinder(view.context)
      val iconId = iconFinder.getId(value)

      if (iconId == null) {
        view.thumbIconDrawable = null
      } else {
        view.thumbIconDrawable = iconFinder.getDrawable(iconId)
      }
    }
  }

  override fun setIconSize(
    view: MaterialSwitch?,
    value: Int
  ) {
    if (view == null) return
    view.thumbIconSize = value
  }

  override fun setIconColorForChecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val uncheckedColor = view.thumbIconTintList?.getColorForState(
      intArrayOf(-android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorSurfaceContainerHighest
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        com.google.android.material.R.attr.colorSurfaceContainerHighest,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.WHITE // fallback fallback
    }
    view.thumbIconTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        value, // checked track
        uncheckedColor
      )
    )
  }

  override fun setIconColorForUnchecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val checkedColor = view.thumbIconTintList?.getColorForState(
      intArrayOf(android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorOnPrimaryContainer
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        com.google.android.material.R.attr.colorOnPrimaryContainer,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.BLACK // fallback fallback
    }
    view.thumbIconTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        checkedColor, // checked track
        value
      )
    )
  }

  override fun setOutlineColorForChecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val uncheckedColor = view.trackDecorationTintList?.getColorForState(
      intArrayOf(-android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorSurfaceContainerHighest
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        com.google.android.material.R.attr.colorSurfaceContainerHighest,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.GRAY // fallback fallback
    }
    view.trackDecorationTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        value, // checked track
        uncheckedColor
      )
    )
  }

  override fun setOutlineColorForUnchecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val checkedColor = view.trackDecorationTintList?.getColorForState(
      intArrayOf(android.R.attr.state_checked),
      -1
    ) ?: Color.TRANSPARENT

    view.trackDecorationTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        checkedColor, // checked track
        value
      )
    )
  }

  override fun setTrackColorForChecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val uncheckedColor = view.trackTintList?.getColorForState(
      intArrayOf(-android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorSurfaceContainerHighest
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        com.google.android.material.R.attr.colorSurfaceContainerHighest,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.WHITE // fallback fallback
    }

    view.trackTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        value, // checked track
        uncheckedColor
      )
    )
  }

  override fun setTrackColorForUnchecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val checkedColor = view.trackTintList?.getColorForState(
      intArrayOf(android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorPrimary
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        androidx.appcompat.R.attr.colorPrimary,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.WHITE // fallback fallback
    }

    view.trackTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        checkedColor, // checked track
        value
      )
    )
  }

  override fun setThumbColorForChecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val uncheckedColor = view.thumbTintList?.getColorForState(
      intArrayOf(-android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorOutline
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        com.google.android.material.R.attr.colorOutline,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.WHITE // fallback fallback
    }

    view.trackTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        value, // checked track
        uncheckedColor
      )
    )
  }

  override fun setThumbColorForUnchecked(
    view: MaterialSwitch?,
    value: Int?
  ) {
    if (view == null || value == null) return

    val checkedColor = view.thumbTintList?.getColorForState(
      intArrayOf(android.R.attr.state_checked),
      -1
    ) ?: run {
      // Fallback to theme attribute colorOnPrimary
      val typedValue = TypedValue()
      val theme = view.context.theme
      val got = theme.resolveAttribute(
        com.google.android.material.R.attr.colorOnPrimary,
        typedValue,
        true
      )

      if (got) typedValue.data else Color.WHITE // fallback fallback
    }

    view.thumbTintList = ColorStateList(
      arrayOf(
        intArrayOf(R.attr.state_checked),
        intArrayOf(-R.attr.state_checked)
      ),
      intArrayOf(
        checkedColor, // checked track
        value
      )
    )
  }

  override fun setDisabled(
    view: MaterialSwitch?,
    value: Boolean
  ) {
    if (view == null) return
    view.isEnabled = !value
  }

  override fun addEventEmitters(reactContext: ThemedReactContext, view: MaterialSwitch) {
    view.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER)
  }

  override fun measure(
    context: Context,
    localData: ReadableMap?,
    props: ReadableMap?,
    state: ReadableMap?,
    width: Float,
    widthMode: YogaMeasureMode,
    height: Float,
    heightMode: YogaMeasureMode,
    attachmentsPositions: FloatArray?
  ): Long {
    val view = MaterialSwitch(context).apply { showText = false }
    val measureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    view.measure(measureSpec, measureSpec)
    return YogaMeasureOutput.make(
      PixelUtil.toDIPFromPixel(view.measuredWidth.toFloat()),
      PixelUtil.toDIPFromPixel(view.measuredHeight.toFloat())
    )
  }

  companion object {
    const val NAME = "NUISwitch"

    private val ON_CHECKED_CHANGE_LISTENER =
      CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        val reactContext = buttonView.context as ReactContext
        val reactTag = buttonView.id
        UIManagerHelper.getEventDispatcherForReactTag(reactContext, reactTag)
          ?.dispatchEvent(
            NUISwitchEvent(UIManagerHelper.getSurfaceId(reactContext), reactTag, isChecked)
          )
      }
  }
}
