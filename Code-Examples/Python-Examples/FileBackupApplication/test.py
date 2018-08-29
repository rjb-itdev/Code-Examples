from mybackup import MyBackup
from createSignature import createFileSignature
import os
import os.path

backup = MyBackup()


def validateArchiveIndex():
    validPaths = {}
    validPaths['Erroneous Paths']=[]
    index = backup.getIndex()
    objectsList = os.listdir(backup.fileObjectPath)
    correctPaths = 0
    incorrectPaths = 0
    for filePath in index:
        #print(filePath)
        if index.get(filePath) in objectsList:
            correctPaths += 1
            validPaths['Correct Entries'] = correctPaths
        else:
            incorrectPaths += 1
            validPaths['Incorrect Entries'] = incorrectPaths
            validPaths['Erroneous Paths'].append(filePath)
            
    return validPaths            


def validateFiles():

    fileContentErrors = 0
    invalidFilePath = []
    invalidObjects = []
    index = backup.getIndex()
    archive = os.listdir(backup.fileObjectPath)
    for fileObject in archive:
        file = os.path.join(backup.fileObjectPath,fileObject)
        
        if os.path.isfile(file):
            x = createFileSignature(file)
            if fileObject != x[-1]:
                fileContentErrors += 1
                invalidObjects.append(fileObject)
    print("Archive has  %d file Content Errors" % fileContentErrors)

    if invalidObjects != []:
        for filePath in index:
            if index.get(filePath) in invalidObjects:
                invalidFilePath.append(filePath)
        for file in invalidFilePath:
            print("This file(s) %s contents have changed since backup" % file)
            
        
    


