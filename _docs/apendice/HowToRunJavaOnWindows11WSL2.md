# How to Create and Run a Java File on Windows 11 (WSL2 Ubuntu 20)

This guide will help you set up, create, and execute a basic Java file using Windows 11 with WSL2 (Ubuntu 20).

---

## 1. Prerequisites
- **Windows 11** with **WSL2** installed
- **Ubuntu 20** running in WSL2
- **Java JDK 21** installed

### Install Java JDK 21
Open your Ubuntu terminal and run:
```bash
sudo apt update
sudo apt install openjdk-21-jdk
```
Verify installation:
```bash
java -version
```

---

## 2. Create a Java File
Navigate to your project folder:
```bash
cd ~/apps/learn/java/SE/untitled/src
```
Create a file named `HelloWorld.java`:
```bash
nano HelloWorld.java
```
Paste the following code:
```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```
Save and exit (Ctrl+O, Enter, Ctrl+X).

---

## 3. Compile the Java File
In the terminal, run:
```bash
javac HelloWorld.java
```
This creates a `HelloWorld.class` file in the same directory.

---

## 4. Run the Java Program
Execute the compiled class:
```bash
java HelloWorld
```
You should see:
```
Hello, World!
```

---

## 5. Tips
- You can use any text editor (nano, vim, code, etc.)
- For multiple files, compile all with `javac *.java`
- Use `ls` to list files and check for `.class` output

---

## 6. Troubleshooting
- If you get a command not found error, check your JDK installation
- Ensure your class name matches the file name
- Use `pwd` to confirm your current directory

---

**You are now ready to create and run Java files in your Windows 11 + WSL2 Ubuntu 20 environment!**

