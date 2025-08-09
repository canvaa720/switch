import type { SwitchProps } from './Switch';
import { Switch as RNSwitch, type ColorValue } from 'react-native';

export default function Switch({
  thumbColor,
  value,
  ...props
}: IosSwitchProps) {
  return (
    <RNSwitch
      value={value}
      thumbColor={
        (value ? thumbColor?.true : thumbColor?.false) as ColorValue | undefined
      }
      {...props}
    />
  );
}

type IosSwitchProps = Omit<
  SwitchProps,
  'icon' | 'iconSize' | 'iconColor' | 'outlineColor'
>;
