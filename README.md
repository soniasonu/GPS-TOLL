# GPS Based Toll Collection System

A multi-component toll management system with a Python (Flask) web admin panel, an Android mobile app, and a Java Swing server for device simulation.

## About This Project

This was my academic mini project, built with my team. Toll systems like FASTag rely on gantries with RFID readers, and those are expensive to set up and maintain. If a gantry breaks down, toll collection at that spot just stops working. This project uses a vehicle's GPS location instead of physical infrastructure on the road.

**How it works:** 

A microcontroller with GPS connectivity sits in the vehicle and continuously tracks its location. The system compares those coordinates with toll zone coordinates stored in the database, and when they match, the toll amount gets deducted automatically from the user's wallet. It also checks the vehicle's speed against the legal limit for that road and raises a fine if it's crossed. Since we didn't have access to real GPS hardware, we built a Java Swing simulator (SwingServer) to demo vehicles moving through toll zones and triggering tolls and fines.

**What I learned:** 

This project pushed me to think about how multiple parts of a system — a web app, a mobile app, and a simulation tool — work together through a shared database.

## Features

- GPS-based automatic toll detection and collection
- Android app with wallet, payment, and fine/toll deduction history
- Admin web panel to manage toll rates, locations, and violations
- Automated speed violation detection and fine management
- User registration, login, and feedback system
- Java Swing server for device simulation and data management

## Tech Stack

- **Web:** Python, Flask, MySQL
- **Mobile:** Android (Java)
- **Server:** Java Swing
- **Database:** MySQL

## How to Run

### Web Admin
```bash
pip install flask mysql-connector-python
python Home.py
```

### Android App
Open the Android project folder in Android Studio, build the project, and install it on a device or emulator to register, view toll zones, manage your wallet, and track tolls in real time.

