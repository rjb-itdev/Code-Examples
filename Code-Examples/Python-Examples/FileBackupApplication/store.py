from mybackup import MyBackup
from createSignature import createFileSignature
import os
import os.path
from shutil import copy2
import pickle

numberOfFilesNotAdded = 0
numberOfFilesAdded = 0
backup = MyBackup()


def store(file):

    filePath = file
    index = backup.getIndex()
    if os.path.exists(filePath) and os.path.isdir(filePath):
        index.update(storeDir(filePath))
        try:
            pickle.dump(index,open(backup.indexFile,"wb"))
            print("Index Updated")
        except:
            print("Update Failed")
    else:
        print("Directory % Does not exist" % filePath)


def storeDir(pathName):
    files = os.listdir(pathName)

    fileIndex = {}
    for fileName in files:
        filePath = os.path.join(pathName, fileName)
        #print(filePath)
        if os.path.isfile(filePath):
            x = createFileSignature(filePath)
            fileSignature = x[2]
            #print(fileSignature)
            fileIndex[filePath] = fileSignature
            signaturePath = os.path.join(backup.fileObjectPath, fileSignature)
            if os.path.exists(signaturePath):
                print("%s File Backup Exists" % filePath)
            else:
                print("%s File Backup Created" % fileName)
                try:
                    copy2(filePath,signaturePath)
                except IOError:
                    print("% File Copy Failed" % fullPath)
        elif os.path.isdir(filePath):
            fileIndex.update(storeDir(filePath))
    return fileIndex
