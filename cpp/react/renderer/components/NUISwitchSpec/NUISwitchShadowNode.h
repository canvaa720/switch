#pragma once

#include "NUISwitchMeasurementsManager.h"

#include <react/renderer/components/NUISwitchSpec/EventEmitters.h>
#include <react/renderer/components/NUISwitchSpec/Props.h>
#include <react/renderer/components/view/ConcreteViewShadowNode.h>

namespace facebook::react {

extern const char NUISwitchComponentName[];

class NUISwitchShadowNode final : public ConcreteViewShadowNode<
    NUISwitchComponentName,
    NUISwitchProps,
    NUISwitchEventEmitter> {
 public:
  using ConcreteViewShadowNode::ConcreteViewShadowNode;

  static ShadowNodeTraits BaseTraits() {
    auto traits = ConcreteViewShadowNode::BaseTraits();
    traits.set(ShadowNodeTraits::Trait::LeafYogaNode);
    traits.set(ShadowNodeTraits::Trait::MeasurableYogaNode);
    return traits;
  }

  void setNUISwitchMeasurementsManager(
      const std::shared_ptr<NUISwitchMeasurementsManager>& manager);

  Size measureContent(
      const LayoutContext& layoutContext,
      const LayoutConstraints& layoutConstraints) const override;

 private:
  std::shared_ptr<NUISwitchMeasurementsManager> measurementsManager_;
};

} // namespace facebook::react
