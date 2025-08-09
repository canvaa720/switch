#include "NUISwitchShadowNode.h"

namespace facebook::react {

extern const char NUISwitchComponentName[] = "NUISwitch";

void NUISwitchShadowNode::setNUISwitchMeasurementsManager(
    const std::shared_ptr<NUISwitchMeasurementsManager>& manager) {
  ensureUnsealed();
  measurementsManager_ = manager;
}

Size NUISwitchShadowNode::measureContent(
    const LayoutContext& /*layoutContext*/,
    const LayoutConstraints& layoutConstraints) const {
  return measurementsManager_->measure(getSurfaceId(), layoutConstraints);
}

} // namespace facebook::react
