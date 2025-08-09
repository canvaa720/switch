#pragma once

#include "NUISwitchMeasurementsManager.h"
#include "NUISwitchShadowNode.h"

#include <react/renderer/core/ConcreteComponentDescriptor.h>

namespace facebook::react {

/*
 * ComponentDescriptor for <NUISwitch /> component.
 * Connects the ShadowNode with the rendering system and measurement manager.
 */
class NUISwitchComponentDescriptor final
    : public ConcreteComponentDescriptor<NUISwitchShadowNode> {
 public:
  NUISwitchComponentDescriptor(
      const ComponentDescriptorParameters& parameters)
      : ConcreteComponentDescriptor(parameters),
        measurementsManager_(
            std::make_shared<NUISwitchMeasurementsManager>(contextContainer_)) {}

  void adopt(ShadowNode& shadowNode) const override {
    ConcreteComponentDescriptor::adopt(shadowNode);

    auto& nuiSwitchShadowNode =
        static_cast<NUISwitchShadowNode&>(shadowNode);

    nuiSwitchShadowNode.setNUISwitchMeasurementsManager(measurementsManager_);
  }

 private:
  const std::shared_ptr<NUISwitchMeasurementsManager> measurementsManager_;
};

} // namespace facebook::react
