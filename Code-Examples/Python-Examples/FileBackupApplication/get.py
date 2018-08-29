from mybackup import MyBackup
import os, os.path
import sys
from shutil import *
backup = MyBackup()

myPath = backup.archive
myNewPath = backup.restDir

def getFiles(index, pattern):
    '''Create a list of filepaths dependant on input from pattern (sys.argv[2])
        if 'pattern' is None then return nothing'''
    files = []
    lineNumber = 1
    if pattern == None:
        return

    else:
        for filepath in index.keys():
            if pattern in filepath:
                files.append(filepath)
                lineNumber+=1
    return files

def get(pattern):
    INDEX = backup.getIndex()
    files = getFiles(backup.getIndex(),pattern)
    # def get(files,INDEX):

    try:
        linenum = 1
        # if we have more than one match with the pattern given then:
        if len(files) > 1:
            #print the first 50
            if len(files)>=50:
                for i in range(0,49):
                    print ("(" + str(linenum) +")" + "-----" + (files[i]))
                    linenum+=1
            #print all of them
            else:
                for i in files:
                    print ("(" + str(linenum) +")" + "-----" + (i))
                    linenum+=1
            lineSelected = int(input("Number of file to recover:"))-1
            path = files[lineSelected].split(os.sep)# we get the file path
            name = path[-1] # we want to get the file name only
            srcFile = os.path.join(os.path.join(myPath,"Objects"),INDEX[files[lineSelected]])
            destFile = os.path.join(os.path.join(myPath,"myRestore"),name)
            copy2(srcFile,destFile)
        else:
            if files[0] in INDEX.keys():
                path = files[0].split(os.sep)
                name = path[-1]
                srcFile = os.path.join(os.path.join(myPath,"Objects"),files[0])
                destFile = os.path.join(myPath,name)
                copy2(srcFile,destFile)
        print ("File recovered.")
    except IndexError:
        print("no match found")