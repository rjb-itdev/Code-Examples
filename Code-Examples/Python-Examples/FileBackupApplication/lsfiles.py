from mybackup import MyBackup
import os

backup=MyBackup()

def listFiles(pattern=None):
    index = backup.getIndex()
    if len(backup.getIndex()) > 0:

        searchResults = []

        if pattern != None:
            print("Files containing '%s'%s" % (pattern, os.linesep))
        for file in index:
            if pattern == None or pattern in file:
                searchResults.append(file)

        return searchResults
    else:
        return []

def validCommands(cmd=None):

    vc = {}

    vc['init']="Initialise the program with folders and files: Folders[ %s, %s ] Files  [ %s %s]" \
                        % (backup.archiveName,backup.archive,\
                           backup.indexFile, backup.logFile)
    vc['store']="Stores files as objects and updates index file accordingly"
    vc['list']="Displays files by search pattern, or all files if no search pattern eg. list hello"
    if cmd in vc:
        return vc[cmd]
    else:
        return vc

