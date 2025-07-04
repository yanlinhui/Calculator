Project1Calculator 项目说明

一、项目概述
`Project1Calculator` 是一款专为 Android 平台开发的计算器应用程序。它采用 Kotlin 语言编写，充分利用 AndroidX 库的强大功能，并遵循 Material Design 设计风格，为用户提供简洁、美观且实用的基本四则运算功能。

二、项目结构
项目的主要文件和目录结构如下：
```plaintext
Calculator/
├── .gitignore
├── .idea/
│   ├── .gitignore
│   ├── compiler.xml
│   ├── gradle.xml
│   ├── kotlin.xml
│   ├── misc.xml
│   ├── migrations.xml
│   └── ...
├── app/
│   ├── .gitignore
│   ├── build.gradle.kts
│   ├── src/
│       ├── androidTest/
│       │   └── java/
│       │       └── com/
│       │           └── example/
│       │               └── project1calculator/
│       │                   └── ExampleInstrumentedTest.kt
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/
│       │   │   └── com/
│       │   │       └── example/
│       │   │           └── project1calculator/
│       │   │               ├── MainActivity.kt
│       │   │               ├── UnicodeTextView.kt
│       │   │               └── Utils.kt
│       │   └── res/
│       │       ├── drawable/
│       │       │   ├── ic_launcher_background.xml
│       │       │   ├── ic_launcher_foreground.xml
│       │       │   ├── operation_normal_style.xml
│       │       │   └── ...
│       │       ├── layout/
│       │       │   └── activity_main.xml
│       │       ├── mipmap-anydpi-v26/
│       │       │   └── ic_launcher.xml
│       │       ├── values/
│       │       │   ├── colors.xml
│       │       │   ├── dimens.xml
│       │       │   ├── strings.xml
│       │       │   └── themes.xml
│       │       └── xml/
│       │           ├── backup_rules.xml
│       │           └── data_extraction_rules.xml
│       └── test/
│           └── java/
│               └── com/
│                   └── example/
│                       └── project1calculator/
│                           └── ExampleUnitTest.kt
├── build.gradle.kts
├── gradle/
│   └── wrapper/
│       └── gradle-wrapper.properties
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

关键文件说明
- `app/src/main/java/com/example/project1calculator/MainActivity.kt`：应用的主活动类，负责处理用户交互和计算逻辑。
- `app/src/main/res/layout/activity_main.xml`：主界面的布局文件，定义了计算器的 UI 元素。
- `app/build.gradle.kts`：应用模块的构建配置文件，指定了依赖库和编译选项。

三、技术栈
- 编程语言：Kotlin
- 构建工具：Gradle
- Android 开发框架：AndroidX
- 设计风格：Material Design

四、依赖库
项目使用了以下依赖库：
```kotlin
implementation(libs.androidx.core.ktx)
implementation(libs.androidx.appcompat)
implementation(libs.material)
implementation(libs.androidx.activity)
implementation(libs.androidx.constraintlayout)
testImplementation(libs.junit)
androidTestImplementation(libs.androidx.junit)
androidTestImplementation(libs.androidx.espresso.core)
```
这些依赖库提供了 Android 开发所需的核心功能、兼容性支持、UI 组件以及测试框架。

五、功能特性
1. 基本四则运算：支持加、减、乘、除四则运算，满足用户日常计算需求。
2. 清空和删除功能：提供清空输入和删除最后一位数字的功能，方便用户纠正输入错误。
3. 实时计算：在输入数字和运算符时，实时计算结果，让用户及时了解计算情况。

六、运行步骤
1. 克隆项目
```bash
git clone https://github.com/your-repo/Calculator.git
cd Calculator
```

2. 打开项目
使用 Android Studio 打开项目。

3. 配置环境
确保 Android Studio 已经正确配置了 Android SDK 和 JDK。可以在 Android Studio 的 `File -> Project Structure` 中进行检查和配置。

4. 运行项目
连接 Android 设备或启动模拟器，点击 Android Studio 中的运行按钮。

七、测试
项目包含了单元测试和仪器化测试：
- 单元测试：在 `app/src/test` 目录下，使用 JUnit 进行测试。例如 `ExampleUnitTest.kt` 中的简单加法测试。
```kotlin
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
```
- 仪器化测试：在 `app/src/androidTest` 目录下，使用 AndroidX Test 和 Espresso 进行测试。例如 `ExampleInstrumentedTest.kt` 用于测试应用的上下文。
```kotlin
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.project1calculator", appContext.packageName)
    }
}
```

运行测试的方法：在 Android Studio 中，右键点击测试类或测试方法，选择 "Run"。

八、注意事项
- 项目使用了 Android Gradle Plugin 8.5.0 和 Kotlin 1.9.0，请确保你的 Android Studio 版本支持这些版本。
- 项目中的图标字体文件 `iconfont.ttf` 需要放置在 `app/src/main/assets` 目录下。

九、贡献
如果你想为该项目做出贡献，请遵循以下步骤：
1. Fork 项目。
2. 创建新的分支：`git checkout -b feature/your-feature`。
3. 提交更改：`git commit -m "Add your feature"`。
4. 推送分支：`git push origin feature/your-feature`。
5. 创建 Pull Request。

十、许可证
该项目遵循 [Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0) 许可证。
