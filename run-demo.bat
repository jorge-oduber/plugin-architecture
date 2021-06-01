REM
REM This script creates and run the pf4j demo project.
REM

REM create plugins folder
rmdir build /s /q

REM create artifacts using gradle
call gradle build

REM run demo
call gradle apps:java-application:run