@echo off 
set filePath=E:/IntelliJ Projects/Thyroid/
set file=%1
set file=%file:"=%
set filePath=%filePath%%file%
python "%filePath%" %2 %3