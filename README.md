## GPS Based Toll Collection System

A multi-component toll management system with a Python web admin panel, Android mobile app, and Java Swing server.

### Features
- GPS-based automatic toll detection and collection
- Android app with wallet, payment, and real-time toll tracking
- Admin web panel to manage toll rates, locations, and violations
- Automated speed violation detection and fine management
- User registration, login, and feedback system
- Java Swing server for device simulation and data management

### Tech Stack
- Web: Python, Flask, MySQL
- Mobile: Android (Java)
- Server: Java Swing
- Database: MySQL

### How to Run
#### Web Admin
pip install flask mysql-connector-python
python Home.py

#### Android App
Open GPSTollCollect in Android Studio and run on device or emulator

### Security Note
Database credentials in this project are loaded from environment variables (`DB_HOST`, `DB_USER`, `DB_PASSWORD`, `DB_NAME`) rather than hardcoded. Earlier versions of this repository contained hardcoded credentials; these have since been removed and replaced with placeholders. Set your own environment variables or update the placeholder values before running.

