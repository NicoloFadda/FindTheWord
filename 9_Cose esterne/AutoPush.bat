@echo off
:start
ECHO Enter commit statement:
SET /p input=""
GOTO check
  

:check
IF "%input%" == "" (
	ECHO Input is empty
	GOTO start
) ELSE (
	GOTO commit
)

:commit
CD /D "E:\I3BB - 23-24\!PROGETTI\Git\FindTheWord"
start H:\v0.4.0\px.exe
git.exe add .
git.exe commit -m "%input%"
git.exe push

IF %errorlevel% == 0 (
cls
echo [92mSuccessfully Committed And Pushed.[0m
)

:exit
EXIT /B