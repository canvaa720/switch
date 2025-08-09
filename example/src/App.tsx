import { Switch } from '@rn-nui/switch';
import { useState } from 'react';
import { StyleSheet, View } from 'react-native';

export default function App() {
  const [value, setValue] = useState(false);
  return (
    <View style={styles.container}>
      <Switch
        value={value}
        iconSize={50}
        onChange={(event) => {
          console.log('Switch changed:', event);
        }}
        onValueChange={(newValue) => {
          console.log('Switch value changed:', newValue);
          setValue(newValue);
        }}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
});
