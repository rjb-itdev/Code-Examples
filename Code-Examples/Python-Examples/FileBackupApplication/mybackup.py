import os
import os.path
import pickle





class MyBackup(object):

    def __init__(self):

        super(MyBackup, self).__init__()
        self.archiveName="myArchive"
        self.restDirName="myRestore"
        self.userpath=os.path.expanduser("~")
        self.archive=os.path.join(self.userpath,self.archiveName)
        self.restDir=os.path.join(self.archive,self.restDirName)
        self.fileObjectPath=os.path.join(self.archive,"Objects")
        self.indexFile=os.path.join(self.archive,"index.txt")
        self.logFile=os.path.join(self.archive,"log.txt")
        
    def archiveExists(self):

        if os.path.join(self.archive) and os.path.isdir(self.archive):
            return True
        else:
            return False

    def objectFolderExists(self):

        if os.path.join(self.fileObjectPath) and os.path.isdir(self.fileObjectPath):
            return True
        else:
            return False

    def restoreDirectoryExists(self):
        if os.path.exists(self.restDir) and os.path.isdir(self.restDir):
            return True
        else:
            return False
        
    def indexFileExists(self):

        if os.path.isfile(self.indexFile):
            return True
        else:
            return False
        
    def logFileExists(self):
        if os.path.isfile(self.logFile):
            return True
        else:
            return False

    def pathExists(self, pathname):
        if os.path.exists(pathname):
            return True
        else:
            return False
        
    def getIndex(self):
        index = {}
        try:
            if os.path.getsize(self.indexFile) > 0:
                try:
                    index = pickle.load(open(self.indexFile,"rb"))
                except IndexError:
                    print("Index corrupt?")
        except OSError:
            print("index file does not exist")
        return index
        
    def readyToBackup(self):

        if self.archiveExists() and self.objectFolderExists() and \
           self.indexFileExists() and self.logFileExists():
            return True
        else:
            return False

 


