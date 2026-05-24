# 📱 Android Application Documentation: ServiceCollection

________________________________________
## 🧾 General Information
**Project Name:** ServiceCollection  
**Author(s):** Zeev  
**Date:** May 2024  
**Language:** Java  
**Development Environment:** Android Studio  
**Android Version:** minSdk 28 / targetSdk 35  
________________________________________

## 🎯 Project Goal
• **What task does the app solve:** Demonstration of various types of Services in the Android OS.  
• **Why is this task important:** Understanding the lifecycle and interaction methods with background tasks (Started Service, Bound Service, JobService) is critical for developing efficient Android applications.  
• **Target audience:** Android developers, students studying mobile development.  
________________________________________

## 📌 Application Requirements
### Functional Requirements
• Start and stop a music service in the background.  
• Implement a timer that runs independently of the Activity lifecycle.  
• Receive data from a service via Binding.  
• Step counting using device sensors.  
• Cache cleaning on app start/stop.  

### Non-Functional Requirements
• **Performance:** Minimal resource consumption in the background.  
• **Usability:** Simple interface with control buttons for each service.  
• **Reliability:** Correct handling of service stops and resource release (e.g., MediaPlayer).  
________________________________________

## 🧠 Overall Architecture
• **Chosen Approach:** Standard Android Component Architecture (Activity + Services).  
• **Why it was chosen:** This is the most direct way to demonstrate the mechanics of Android system components without adding extra layers like MVVM, which simplifies learning.  
• **Main system components:**
  - `MainActivity`: Management interface.
  - `MusicService`: Background playback.
  - `TimerService`: Bound service for time tracking.
  - `StepCounterService`: Service for working with sensors.
  - `CacheCleanerService`: Service for short-term background tasks.
________________________________________

## 🧩 UML Diagram
`[MainActivity] <--> [MusicService / TimerService / StepCounterService]`  
`[MainActivity] --(ServiceConnection)--> [TimerService.TimerBinder]`

**Explanation:**
- Packages are not separated due to the small size of the project; all classes are in the main package.
- Scaling is possible by moving services to a separate `.services` package.
________________________________________

## 🧩 Detailed Class Description
### 📌 Class: MainActivity
- **Role:** Main application screen.
- **Responsibility:** Managing the lifecycle of services via user input (buttons, switches). Displaying service status.
- **Main Methods:**
  - `onCreate()` — UI and listeners initialization.
  - `updateTimer()` — updates timer text in UI from a background thread.
  - `initComponents()` — configures ServiceConnection.
- **Interaction:** Starts/stops services via `Intent`, binds to `TimerService`.

### 📌 Class: MusicService
- **Role:** Background music playback.
- **Methods:** `onStartCommand` starts the player, `onDestroy` releases resources.

### 📌 Class: TimerService
- **Role:** Bound Service.
- **Why it is used:** Allows the Activity to get the current second count directly via a Binder.
________________________________________

## 🔄 App Workflow Diagram
1. User presses "Start TS".
2. `MainActivity` starts and binds to `TimerService`.
3. `TimerService` begins counting.
4. `MainActivity` via `updateTimer` requests data from the service every second.
________________________________________

## 🎨 UI/UX Analysis
• **Interface:** Standard Material Design components (Buttons, Chips, Switches) are used.  
• **Principles:**
  - **Simplicity:** Each group of elements is responsible for a specific service.
  - **Logic:** The state of the switches reflects the state of the service.
________________________________________

## ⚙️ Threading
• **Used:** `Thread` (in MainActivity for UI updates).  
• **Why:** To demonstrate the need to update the UI from a non-main thread when working with long-running tasks.  
• **Prevention of hangs:** Sensor and media player work is offloaded to services.  
________________________________________

## 💾 Data Management
• **Storage:** `SharedPreferences`.  
• **Why:** To save simple states (step count, last timer value) between app launches.  
________________________________________

## 🧪 Testing
• **Types:** Manual UI functional testing.  
• **Verification:** Starting/stopping services, correct data display on screen rotation (partially), background operation.  
________________________________________

## 📊 Self-Assessment
| Criterion | Rating (1–10) |
| :--- | :--- |
| Architecture | 8 |
| Code | 9 |
| UI/UX | 7 |
| Reliability | 9 |
| **Overall Level** | **8.5** |
________________________________________

## 🏁 Conclusion
The project successfully demonstrates the core concepts of Android Services. Skills in working with MediaPlayer, SensorManager, and the Binding mechanism were acquired. The main challenge was correctly synchronizing the UI with the bound service state.
