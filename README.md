# MyDemoApp testing

In this project is being tested MyDemoApp functions.

## Software
You need to have on your system:   
- IntelliJ IDEA.
- Appium server GUI.
- Android Studio.
- MyDemoApp.apk.

## Instructions
**MyDemoApp**
1. Download the [MyDemoApp](https://drive.google.com/file/d/1Qngi9VwrClzry8CVPP1RxBPnuU9lpfxw/view?usp=drive_link)

**Appium server GUI**
1. Run Appium server GUI.
2. In Host field use **127.0.0.1** address.
3. In Port field use **4723** or **default** port. If you're going to use other port, make sure both port matches in **BaseTest** class **AppiumDriver URL** lane. 

   **Such as:**
```java
driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
```
4. Click ***startServer***.

**Android Studio**
1. Run Android Studio. For Windows users ***run as administrator***.
2. Click ***More Action*** and select ***Virtual device manager***.
3. If you already have created device - run it(make sure it has 1080p resolution and at least Android 12.0 OS. If you don't, click ***Create device***.
4. Select phone with **1080p resolution** and **Android 12.0** and click ***Next***.
5. Create device name and click ***Finish***.
6. In action field click ***Launch*** button. Wait until device bootup.
7. Run CMD.
8. Type **adb devices** and click ***Enter***.
```
adb devices
```
You should see active devices.
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
All maven repositories are available ***[here](https://mvnrepository.com/)***.
4. Change MyDemoApp location if needed. Find MyDemoApp on your system, copy path and paste in **BaseTest** class **capabilities.setCapability("appium:app")** lane.     
  **Such as:**
  ```java
  capabilities.setCapability("appium:app", "C:/Users/User/Downloads/Android-MyDemoAppRN.1.3.0.build-244.apk");
  ```
## Usage
In Project Structure field **test->java** folder are those classes:
- DrawingTest
- LoginTest
- ProductTest

1. Open test class (e.g. DrawingTest).
2. Make sure Appium Server GUI and virtual device(emulator) is running.
3. Run test.

#### Test launch methods
- Click green ***Launch*** button near class name.
- Keyboard combination CTRL+SHIFT+F10.
- In menu bar find **Run** -> click green button ***Run***.
