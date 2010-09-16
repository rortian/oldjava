# Microsoft Developer Studio Generated NMAKE File, Format Version 4.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Console Application" 0x0103

!IF "$(CFG)" == ""
CFG=String - Win32 Debug
!MESSAGE No configuration specified.  Defaulting to String - Win32 Debug.
!ENDIF 

!IF "$(CFG)" != "String - Win32 Release" && "$(CFG)" != "String - Win32 Debug"
!MESSAGE Invalid configuration "$(CFG)" specified.
!MESSAGE You can specify a configuration when running NMAKE on this makefile
!MESSAGE by defining the macro CFG on the command line.  For example:
!MESSAGE 
!MESSAGE NMAKE /f "String.mak" CFG="String - Win32 Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "String - Win32 Release" (based on "Win32 (x86) Console Application")
!MESSAGE "String - Win32 Debug" (based on "Win32 (x86) Console Application")
!MESSAGE 
!ERROR An invalid configuration is specified.
!ENDIF 

!IF "$(OS)" == "Windows_NT"
NULL=
!ELSE 
NULL=nul
!ENDIF 
################################################################################
# Begin Project
CPP=cl.exe
RSC=rc.exe

!IF  "$(CFG)" == "String - Win32 Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
OUTDIR=.
INTDIR=.

ALL : "$(OUTDIR)\String.exe"

CLEAN : 
	-@erase ".\String.exe"
	-@erase ".\String.obj"
	-@erase ".\PetsBird.obj"
	-@erase ".\PetsDog.obj"
	-@erase ".\ZoologyBird.obj"

# ADD BASE CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_CONSOLE" /YX /c
# ADD CPP /nologo /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_CONSOLE" /YX /c
CPP_PROJ=/nologo /ML /W3 /GX /O2 /D "WIN32" /D "NDEBUG" /D "_CONSOLE"\
 /Fp"String.pch" /YX /c 
# ADD BASE RSC /l 0x409 /d "NDEBUG"
# ADD RSC /l 0x409 /d "NDEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
BSC32_FLAGS=/nologo /o"$(OUTDIR)/String.bsc" 
BSC32_SBRS=
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /machine:I386
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /machine:I386
LINK32_FLAGS=kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib\
 advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib\
 odbccp32.lib /nologo /subsystem:console /incremental:no\
 /pdb:"$(OUTDIR)/String.pdb" /machine:I386 /out:"$(OUTDIR)/String.exe" 
LINK32_OBJS= \
	"$(INTDIR)/String.obj" \
	"$(INTDIR)/PetsBird.obj" \
	"$(INTDIR)/PetsDog.obj" \
	"$(INTDIR)/ZoologyBird.obj"

"$(OUTDIR)\String.exe" : "$(OUTDIR)" $(DEF_FILE) $(LINK32_OBJS)
    $(LINK32) @<<
  $(LINK32_FLAGS) $(LINK32_OBJS)
<<

!ELSEIF  "$(CFG)" == "String - Win32 Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
OUTDIR=.
INTDIR=.

ALL : "$(OUTDIR)\String.exe"

CLEAN : 
	-@erase ".\String.exe"
	-@erase ".\String.obj"
	-@erase ".\PetsBird.obj"
	-@erase ".\PetsDog.obj"
	-@erase ".\ZoologyBird.obj"
	-@erase ".\String.ilk"
	-@erase ".\String.pdb"
	-@erase ".\vc40.pdb"
	-@erase ".\vc40.idb"

# ADD BASE CPP /nologo /W3 /Gm /GX /Zi /Od /D "WIN32" /D "_DEBUG" /D "_CONSOLE" /YX /c
# ADD CPP /nologo /W3 /Gm /GX /Zi /Od /D "WIN32" /D "_DEBUG" /D "_CONSOLE" /YX /c
CPP_PROJ=/nologo /MLd /W3 /Gm /GX /Zi /Od /D "WIN32" /D "_DEBUG" /D "_CONSOLE"\
 /Fp"String.pch" /YX /c 
# ADD BASE RSC /l 0x409 /d "_DEBUG"
# ADD RSC /l 0x409 /d "_DEBUG"
BSC32=bscmake.exe
# ADD BASE BSC32 /nologo
# ADD BSC32 /nologo
BSC32_FLAGS=/nologo /o"$(OUTDIR)/String.bsc" 
BSC32_SBRS=
LINK32=link.exe
# ADD BASE LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /debug /machine:I386
# ADD LINK32 kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib odbccp32.lib /nologo /subsystem:console /debug /machine:I386
LINK32_FLAGS=kernel32.lib user32.lib gdi32.lib winspool.lib comdlg32.lib\
 advapi32.lib shell32.lib ole32.lib oleaut32.lib uuid.lib odbc32.lib\
 odbccp32.lib /nologo /subsystem:console /incremental:yes\
 /pdb:"$(OUTDIR)/String.pdb" /debug /machine:I386 /out:"$(OUTDIR)/String.exe" 
LINK32_OBJS= \
	"$(INTDIR)/String.obj" \
	"$(INTDIR)/PetsBird.obj" \
	"$(INTDIR)/PetsDog.obj" \
	"$(INTDIR)/ZoologyBird.obj"

"$(OUTDIR)\String.exe" : "$(OUTDIR)" $(DEF_FILE) $(LINK32_OBJS)
    $(LINK32) @<<
  $(LINK32_FLAGS) $(LINK32_OBJS)
<<

!ENDIF 

.c.obj:
   $(CPP) $(CPP_PROJ) $<  

.cpp.obj:
   $(CPP) $(CPP_PROJ) $<  

.cxx.obj:
   $(CPP) $(CPP_PROJ) $<  

.c.sbr:
   $(CPP) $(CPP_PROJ) $<  

.cpp.sbr:
   $(CPP) $(CPP_PROJ) $<  

.cxx.sbr:
   $(CPP) $(CPP_PROJ) $<  

################################################################################
# Begin Target

# Name "String - Win32 Release"
# Name "String - Win32 Debug"

!IF  "$(CFG)" == "String - Win32 Release"

!ELSEIF  "$(CFG)" == "String - Win32 Debug"

!ENDIF 

################################################################################
# Begin Source File

SOURCE=.\String.cpp
DEP_CPP_STRIN=\
	".\String.hh"\
	

"$(INTDIR)\String.obj" : $(SOURCE) $(DEP_CPP_STRIN) "$(INTDIR)"


# End Source File
################################################################################
# Begin Source File

SOURCE=.\PetsBird.cpp
DEP_CPP_PETSB=\
	".\String.hh"\
	".\PetsBird.hh"\
	

"$(INTDIR)\PetsBird.obj" : $(SOURCE) $(DEP_CPP_PETSB) "$(INTDIR)"


# End Source File
################################################################################
# Begin Source File

SOURCE=.\PetsDog.cpp
DEP_CPP_PETSD=\
	".\String.hh"\
	".\PetsDog.hh"\
	

"$(INTDIR)\PetsDog.obj" : $(SOURCE) $(DEP_CPP_PETSD) "$(INTDIR)"


# End Source File
################################################################################
# Begin Source File

SOURCE=.\ZoologyBird.cpp
DEP_CPP_ZOOLO=\
	".\String.hh"\
	".\ZoologyBird.hh"\
	

"$(INTDIR)\ZoologyBird.obj" : $(SOURCE) $(DEP_CPP_ZOOLO) "$(INTDIR)"


# End Source File
# End Target
# End Project
################################################################################
