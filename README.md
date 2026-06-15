# Appium Android Test — SauceDemo

Framework otomasi Android menggunakan **Appium + Java + TestNG + Page Object Model**.

---

## 🛠️ Prerequisites

Pastikan sudah terinstall:

| Tool | Keterangan |
|---|---|
| Java 17+ | `java -version` |
| Android Studio | Untuk emulator |
| Node.js | Untuk Appium |
| Appium 2.x | `npm install -g appium` |
| UIAutomator2 | `appium driver install uiautomator2` |

---

## ⚙️ Setup

**1. Clone project**
```bash
git clone https://github.com/DevandraNabana20/MobileAutomationAppium.git
cd MobileAutomationAppium
```

**2. Sesuaikan path APK di `DriverManager.java`**
```java
.setApp("C:\\path\\kamu\\saucedemo.apk")
```

---

## 🚀 Cara Run

**1. Jalankan emulator**
```bash
# Android Studio → Device Manager → Start
# atau cek device aktif:
adb devices
```

**2. Jalankan Appium server**
```bash
appium --address 127.0.0.1 --port 4723
```

**3. Run test**
```bash
# Semua test
./gradlew clean test

# Test tertentu
./gradlew test --tests "dibimbing.tests.LoginTest"
./gradlew test --tests "dibimbing.tests.AddToCartTest"
```

---

## 🧪 Test Cases

| Class | Method | Deskripsi |
|---|---|---|
| `LoginTest` | `testLoginSuccess` | Login dengan kredensial valid |
| `LoginTest` | `testLoginLockedOut` | Login dengan akun locked out |
| `AddToCartTest` | `testAddYellowBackpackToCart` | Add produk ke cart & validasi |

**Akun test:**
```
Valid  : bod@example.com   / 10203040
Locked : alice@example.com / 10203040
```

---
