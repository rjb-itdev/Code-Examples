
import os
import os.path

from mybackup import MyBackup



def init():
    backup = MyBackup()
    
    if backup.archiveExists():
        print("Archive Exists %s" % backup.archive)
    else:
        os.makedirs(backup.archive)

    if backup.objectFolderExists():
        print("Objects folder exists %s " % backup.fileObjectPath)
    else:
        os.makedirs(backup.fileObjectPath)
    if backup.restoreDirectoryExists():
        print("Restore Directory Exists")
    else:
        os.makedirs(backup.restDir)
        
    if backup.indexFileExists():
        print("Index file exists")
    else:
        print("Created Index file")
        open(backup.indexFile,'w').close()
    if backup.logFileExists():
        print("Log File exists")
    else:
        print("Created Log File")
        open(backup.logFile,'w').close()
    
