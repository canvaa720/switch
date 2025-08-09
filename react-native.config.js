module.exports = {
  dependency: {
    platforms: {
      android: {
        componentDescriptors: ['NUISwitchComponentDescriptor'],
        cmakeListsPath: '../android/src/main/jni/CMakeLists.txt',
      },
    },
  },
};
