cmake_minimum_required(VERSION 3.22)
project(Sqlite3Interop C)

set(CMAKE_C_STANDARD 99)

add_library(Sqlite3Interop lib/library.c)

find_package(SQLite3 REQUIRED)
target_link_libraries(${PROJECT_NAME} SQLite::SQLite3)