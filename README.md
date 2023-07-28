# MyDemoApp testing

In this project is being tested MyDemoApp functions.

## Software

You need to have on your system:   
- IntelliJ IDEA
- Appium server GUI
- Android Studio.
- MyDemoApp.apk

## Instructions
**MyDemoApp**
1. Download the [MyDemoApp](https://drive.google.com/file/d/1Qngi9VwrClzry8CVPP1RxBPnuU9lpfxw/view?usp=drive_link)

**Appium server GUI**
1. Run Appium server GUI
2. In Host field use **127.0.0.1** address.
3. in Port field use **4723** port.
4. Click ***startServer***.

**Android Studio**
1. Run Android Studio ***as administrator***.
2. Click ***More Action*** and select ***Virtual device manager***.
3. If you already have created device - run it(make sure it has 1080p resolution and at least Android 12.0 OS. If you don't click ***Create device***.
4. Select phone with **1080p resolution** and **Android 12.0** and click ***Next***.
5. Create device name and click ***Finish***.
6. In action field click ***Launch*** button. Wait until device bootup.
7. Run CMD
8. Type **adb devices** and click ***Enter***.
```
adb devices
```
You should see active devices
```
emulator-5554   device
```
**Intellij setup**

1. Download [project](https://github.com/Staniulionis/Demo) as zip.
2. Extract project and open it via Intellij IDEA.
3. Check pom.xml and make sure there are those dependencies: 
- **selenium-java**
- **junit-jupiter-api**
- **junit**
- **junit-jupiter-params**
- **java-client**   
All maven repositories are available ***[here](https://mvnrepository.com/)***
4. In pom.xml click ***maven refresh*** button. ![alt text](https://i.stack.imgur.com/bKPIz.png)
5. Change MyDemoApp location if needed. Find MyDemoApp on your system, copy path and and in **BaseTest** class **capabilities.setCapability("appium:app")** line.
  **Such as:**
  ```python
  capabilities.setCapability("appium:app"
  ```


## Usage

In Project Structure field **test->java** folder are those classes:
- DrawingTest
- LoginTest
- ProductTest

1. Open test class (e.g. DrawingTest).
2. Make sure Appium Server GUI and virtual device(emulator) is running.
3. Run test

#### Test launch methods
- click green ***Launch*** button near class name.
- keyboard combination CTRL+SHIFT+F10.
- In menu bar find **Run** -> click green button ***Run***.

## License

Copyright (c) 2023 Tautvydas Staniulionis

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
