import type { ColorValue, ViewProps } from 'react-native';
import type {
  BubblingEventHandler,
  Int32,
} from 'react-native/Libraries/Types/CodegenTypes';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

interface NativeProps extends ViewProps {
  value?: boolean | undefined;
  icon?: string | undefined | null;
  iconSize?: Int32 | undefined | null;
  iconColorForChecked?: ColorValue | undefined | null;
  iconColorForUnchecked?: ColorValue | undefined | null;
  outlineColorForChecked?: ColorValue | undefined | null;
  outlineColorForUnchecked?: ColorValue | undefined | null;
  trackColorForChecked?: ColorValue | undefined | null;
  trackColorForUnchecked?: ColorValue | undefined | null;
  thumbColorForChecked?: ColorValue | undefined | null;
  thumbColorForUnchecked?: ColorValue | undefined | null;
  disabled?: boolean | undefined;
  onChange: BubblingEventHandler<{ value: boolean; target: Int32 }>;
}

export default codegenNativeComponent<NativeProps>('NUISwitch', {
  interfaceOnly: true,
});
