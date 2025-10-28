TrainingTimer - Android Studio project (ready to build)

Contents:
- Android Studio project (app module)
- Short beep sound at: app/src/main/res/raw/beep.wav
- Launcher icons in res/mipmap-*/ic_launcher.png
- MainActivity with button "开始训练" and 30s/10s loop logic

This archive does NOT include a compiled APK. Build locally with Android Studio.

Windows build steps:
1. Install Android Studio and ensure SDK for API 34 is installed.
2. Open this folder in Android Studio (File -> Open -> settings.gradle)
3. Let Gradle sync. (If prompted to update Gradle plugin, accept)
4. Build -> Build Bundle(s) / APK(s) -> Build APK(s)
   APK is at: app/build/outputs/apk/debug/app-debug.apk
5. Transfer to phone and install, or run directly from Android Studio.

If you'd like, I can add a GitHub Actions workflow to auto-build APKs when you push to a repo.
