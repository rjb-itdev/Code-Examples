from mybackup import MyBackup
import os, os.path
import sys
import shutil
backup = MyBackup()

myPath = backup.archive
myNewPath = backup.restDir


def restore(path):

    index = backup.getIndex()
    destination = path
    if not os.path.isdir(destination):
        os.makedirs(path)
    if os.path.exists(destination) and os.path.isdir(destination):
        objects = os.listdir(backup.fileObjectPath)
        for k in index:
            if index[k] in objects:
                srcfile=os.path.join(backup.fileObjectPath,index[k])
                filepath = os.path.split(k)
                destfile = destination + os.path.join(os.path.join(destination,filepath[0]),filepath[-1])
                destdir = destination + os.path.join(destination,filepath[0])

                if os.path.exists(destfile) and os.path.isdir(destdir):
                    print("copying.... %s" %filepath[-1])
                    shutil.copy2(srcfile,destfile)

                elif os.path.exists(destdir):
                    print("copying.... %s" %filepath[-1])
                    shutil.copy2(srcfile,destfile)
                else:
                    print("making directory.... %s" %destdir)
                    print("copying.... %s" %filepath[-1])
                    os.makedirs(destdir)
                    shutil.copy2(srcfile,destfile)