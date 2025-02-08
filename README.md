# Student Management System 🎓

## Classes 🏫
For this project, I have implemented the following classes:
- Secretariat (core management class)
- Student (base class)
- StudentLicenta (extends Student)
- StudentMaster (extends Student)
- Curs (generic class with type parameter extending Student)
- StudentDuplicatExceptie (custom exception)

## Feature Description ⚙️

### Data Structures 🗃️
- ArrayList<> for managing students and courses
- TreeSet<> for managing enrolled students in courses (automatically sorted by name)
- Generics for type-safe course management

### Classes 📚
- The `Secretariat` class serves as the core management class, handling all operations related to students and courses
- `Student` is the base class containing common attributes (name, average grade, preferences)
- `StudentLicenta` and `StudentMaster` extend `Student` to represent undergraduate and master's students
- `Curs` is implemented as a generic class to ensure type safety when handling different student types
- Custom exception `StudentDuplicatExceptie` for handling duplicate student entries

### Reading Data 📖
- File operations are handled using BufferedReader and FileReader
- Input files follow a specific format with commands separated by " - "
- Multiple input files are supported for reading grades (note_1.txt, note_2.txt, note_3.txt)

### Method Implementation 🔄
The system supports the following operations:
- Adding students and courses
- Reading and updating grades
- Handling grade appeals
- Managing course preferences
- Implementing course allocation
- Generating reports for courses and students

### OOP Principles 🧩
- `Encapsulation`: Private fields with public getters/setters
- `Inheritance`: Student hierarchy (StudentLicenta, StudentMaster)
- `Generics`: Type-safe course management
- `Exception Handling`: Custom exception for duplicate students

### File Management 💾
- Input files are organized in resource folders
- Output is appended to specified output files
- Each output section is marked with "***" for clear separation

### Special Features 🌟
- Automatic sorting of students by grade (descending) and name
- Course allocation based on preferences and capacity
- Fallback allocation for students who couldn't get their preferred courses
- Support for both undergraduate and master's programs

### Comments 💬
- Clean code approach with descriptive method and variable names
- Consistent use of Romanian language for method and variable names
- Robust error handling with custom exceptions
- Type-safe implementation using generics

### Tips for Running the Project ⚡
To run this project, you need to have **Gradle** installed on your local machine.  
> [!NOTE] 
> If you do not have Gradle installed, you can download it from [Gradle's official website](https://gradle.org/install/).

This project includes a `settings.gradle` file, which is used to configure the Gradle build.  
> [!NOTE] 
> Once you have Gradle installed, navigate to the project directory in your terminal and run the following command to install the required dependencies:
  ```bash
  gradle build
```

> [!TIP]
> #### Gradle Integration with IntelliJ IDEA 📦
> 
> The project includes the `gradle/wrapper` directory, allowing IntelliJ IDEA to automatically recognize it as a Gradle project. No additional plugins are required—just open the project, and access Gradle tasks directly from the sidebar if you wish not to install Gradle.
