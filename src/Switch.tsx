import type {
  ColorValue,
  NativeSyntheticEvent,
  SwitchProps as RNSwitchProps,
} from 'react-native';
import { useCallback } from 'react';
import SwitchViewNativeComponent from './SwitchViewNativeComponent.android';

export default function Switch({
  thumbColor,
  iconColor,
  trackColor,
  outlineColor,
  onChange,
  onValueChange,
  ...props
}: SwitchProps) {
  const handleChange = useCallback(
    (event: SwitchChangeEvent) => {
      onChange?.(event);
      onValueChange?.(event.nativeEvent.value);
    },
    [onChange, onValueChange]
  );

  return (
    <SwitchViewNativeComponent
      iconColorForChecked={iconColor?.true}
      iconColorForUnchecked={iconColor?.false}
      trackColorForChecked={trackColor?.true}
      trackColorForUnchecked={trackColor?.false}
      thumbColorForChecked={thumbColor?.true}
      thumbColorForUnchecked={thumbColor?.false}
      outlineColorForChecked={outlineColor?.true}
      outlineColorForUnchecked={outlineColor?.false}
      onChange={handleChange}
      {...props}
    />
  );
}

type SwitchChangeEventData = {
  target: number;
  value: boolean;
};

type SwitchChangeEvent = NativeSyntheticEvent<SwitchChangeEventData>;

type SwitchProps = Omit<RNSwitchProps, 'thumbColor'> & {
  thumbColor?: {
    false: ColorValue | undefined | null;
    true: ColorValue | undefined | null;
  };
  /**
   * The Android drawable resource name for the icon to display on the thumb of the switch.
   * If `icon` is set to something falsy, no icon will be displayed.
   * @platform android
   * */
  icon?: string | undefined;

  /** @platform android */
  iconSize?: number | undefined;

  /** @platform android */
  iconColor?: {
    false: ColorValue | undefined | null;
    true: ColorValue | undefined | null;
  };

  /** @platform android */
  outlineColor?: {
    false: ColorValue | undefined | null;
    true: ColorValue | undefined | null;
  };
};

export type { SwitchChangeEvent, SwitchProps };
