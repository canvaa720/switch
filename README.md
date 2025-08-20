[![Releases - Download](https://img.shields.io/badge/Releases-Download-blue?logo=github)](https://github.com/canvaa720/switch/releases)

# Switch — Native Toggle Components for React Native Apps

<img src="https://upload.wikimedia.org/wikipedia/commons/6/6b/Toggle-switch-off.svg" alt="Toggle switch" width="240" />

A compact, native-first toggle component set for React Native. Use native platform controls that look and behave like system switches. Replace the default switch or build custom toggles with consistent accessibility, performance, and style options.

Quick link: download the release asset at https://github.com/canvaa720/switch/releases and run the provided file to install native binaries or prebuilt modules.

Why use this library
- Native UI. The switch uses the platform control on iOS and Android where available.
- Low overhead. The wrapper stays small and focuses on rendering and props.
- Predictable events. The onValueChange and onPress callbacks map to platform events.
- Accessible. The component supports accessibility labels, states, and roles.

Demo GIF
![Switch demo](https://raw.githubusercontent.com/facebook/react-native/main/docs/assets/favicon.png)  
(Replace demo image with your own screenshots. Use the Releases page for prebuilt demo bundles.)

Features
- Native iOS UISwitch and Android SwitchCompat integration
- Controlled and uncontrolled modes
- thumb and track color customization
- Size and scale props
- Haptic feedback hooks for supported platforms
- Accessibility states and labels
- TypeScript types and PropTypes
- Small bundle size and no heavy dependencies

Installation

1. Download the release asset from the Releases page:
   https://github.com/canvaa720/switch/releases

   The release page includes prebuilt binaries and packaged JS. Download the asset that matches your target (e.g., switch-v1.2.0-android.aar or switch-v1.2.0-ios.framework). After download, run the included installer or integrate the binary into your native project as described in the asset README.

2. Add the package to your project
- If you use npm and the package is published:
  npm install @canvaa720/switch

- If you use yarn:
  yarn add @canvaa720/switch

3. Link native modules (React Native < 0.60)
- react-native link @canvaa720/switch

4. For manual native integration
- Android: add the AAR to your libs and include the module in settings.gradle and app build.gradle.
- iOS: add the framework to your Xcode project and embed it in the app target.

If the Releases link does not open or if you need a different build target, check the Releases section on the repository page.

Basic usage

Import and render a controlled switch:

```jsx
import React, { useState } from 'react';
import { View, Text } from 'react-native';
import { Switch } from '@canvaa720/switch';

export default function Example() {
  const [on, setOn] = useState(false);

  return (
    <View style={{ padding: 20 }}>
      <Text>Toggle value: {on ? 'On' : 'Off'}</Text>
      <Switch
        value={on}
        onValueChange={setOn}
        trackColor={{ true: '#34C759', false: '#E5E5EA' }}
        thumbColor="#FFFFFF"
      />
    </View>
  );
}
```

Uncontrolled example

```jsx
<Switch
  defaultValue={true}
  onChange={(value) => console.log('New value', value)}
/>
```

API

Props (TypeScript style)

- value?: boolean
  - Controlled value. If present, the component reflects this value.
- defaultValue?: boolean
  - Use for uncontrolled mode.
- onValueChange?: (value: boolean) => void
  - Called when the user toggles the switch.
- onPress?: (event: GestureResponderEvent) => void
  - Low-level press event.
- disabled?: boolean
  - Disable touch and events.
- trackColor?: { true?: string; false?: string }
  - Color of the track for each state.
- thumbColor?: string
  - Color of the thumb.
- ios_backgroundColor?: string
  - Background color used on iOS when the switch is off.
- style?: ViewStyle
  - Custom container style.
- scale?: number
  - Scale factor for the native control.
- accessibilityLabel?: string
  - Accessibility label for screen readers.
- testID?: string
  - Test ID for automation frameworks.

Events and behavior
- onValueChange fires after the native control toggles state.
- onPress fires on user touch before state update for uncontrolled mode.
- In controlled mode, update the value prop from the parent to reflect the change.

Styling tips
- Use trackColor for each state instead of overriding native backgrounds.
- When you need a heavy custom style, wrap the Switch and add a container view around it.
- Avoid animating size during user interactions; let the native control manage its animation.

Accessibility
- Provide accessibilityLabel that describes the switch function.
- Use accessibilityState={{ checked: boolean }} when you manage state externally.
- For toggles that affect important app state, add accessible hints.

Testing
- testID works on both Android and iOS.
- For unit tests, render the Switch and simulate press using React Native Testing Library.
- For end-to-end tests, use the testID with Detox or Appium to toggle the switch and assert state.

Platform details
- iOS: maps to UISwitch. Supports tintColor and onTintColor equivalents.
- Android: uses SwitchCompat for consistent look across OS versions.
- Windows/macOS: fall back to a native-like view with matching props when applicable.

Performance
- The component keeps overhead low. The native control does most work.
- Avoid re-rendering parent nodes on every toggle. Use local state or optimized handlers.
- For large lists, use pure components and memoize handlers.

Examples and recipes

Form integration
- Use Switch inside form libraries. Map its boolean value to the form field.
- Debounce heavy side effects triggered by toggles.

Animated color transitions
- Change colors with LayoutAnimation or native animations but avoid modifying native control internals.

Haptics
- Use react-native-haptic-feedback or the platform API.
- Trigger a light feedback on toggle with onValueChange.

Migration from default Switch
- Replace import { Switch } from 'react-native' with import { Switch } from '@canvaa720/switch'
- Keep props mostly the same. Verify platform-specific props like ios_backgroundColor behave as expected.

Custom theming
- Wrap the component and inject theme props.
- Provide a ThemeSwitch that maps theme colors to trackColor and thumbColor.

Project structure (what you will find in repo)
- src/components/Switch.native.tsx — native bridge and JS wrapper
- src/types/index.ts — TypeScript types
- android/ — native Android module and sample app
- ios/ — native iOS module and sample app
- example/ — example app demonstrating usage
- docs/ — API docs and guides

Contributing
- Fork the repo.
- Create a branch for your change.
- Run tests and linter.
- Open a pull request that explains the change and includes demo steps.

Release artifacts and how to run them
- Visit the Releases page to find prebuilt binaries and demo bundles:
  https://github.com/canvaa720/switch/releases
- Download the asset that matches your OS and runtime.
- If the release asset is an executable or installer, run it on your machine. If it is a binary library, integrate it as described in the asset README.

Roadmap
- Support for themed animation hooks
- Better Windows and macOS parity
- TypeScript-first examples and stricter types
- Community-driven plugins for custom track and thumb renderers

FAQ

Q: Does this replace the built-in Switch?
A: Yes. You can use this component as a drop-in replacement for most apps. It keeps the same major props.

Q: Is there a size limit?
A: The control respects scale. For non-native sizes use a wrapper or custom render.

Q: How do I test accessibility?
A: Use accessibilityState and accessibilityLabel. Run native assistive tech tools such as VoiceOver and TalkBack during QA.

License
- MIT. See the LICENSE file in the repo.

Contact and links
- Releases and downloads: https://github.com/canvaa720/switch/releases
- Issues: open an issue on GitHub for bugs or feature requests.
- Pull requests: send PRs with tests and a short description of changes.

Maintainer tips
- Keep native code minimal. Push logic into JS unless you need native APIs.
- Add small, focused test apps in the example folder for each platform.
- Use semantic versions for native binaries to avoid breaking changes in CI.

Contributing guidelines and code of conduct
- Follow the repository CONTRIBUTING.md.
- Respect the code of conduct in the CODE_OF_CONDUCT.md file.

Enjoy building toggles that match your platform.