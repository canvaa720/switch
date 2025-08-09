/*
 * Copyright (c) Meta Platforms, Inc. and affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.nui.switchview

import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.events.Event

internal class NUISwitchEvent(surfaceId: Int, viewId: Int, private val isChecked: Boolean) :
  Event<NUISwitchEvent>(surfaceId, viewId) {

  override fun getEventName(): String = EVENT_NAME

  override fun getEventData(): WritableMap =
    Arguments.createMap().apply {
      putInt("target", viewTag)
      putBoolean("value", isChecked)
    }

  private companion object {
    private const val EVENT_NAME = "topChange"
  }
}
