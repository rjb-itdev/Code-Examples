from init import init
from store import store
from mybackup import MyBackup
from lsfiles import listFiles
from test import validateArchiveIndex, validateFiles
import os
import os.path
import sys
from restore import restore
from get import get

from shutil import *

backup = MyBackup()



#Entry point
def main():

    cmds = sys.argv
    if len(cmds) > 1:
        ui = cmds[1].lower()
        if ui == 'init':
            init()

        if backup.readyToBackup():
            if ui == 'restore' and len(backup.getIndex()) > 0:
                if len(cmds) > 2:
                    restore(os.path.join(backup.restDir,cmds[2]))
                else:
                    print("Restoring to default location %s " %backup.restDir)
                    restore(backup.restDir)
                print ("All files restored.")
            elif ui == 'get':
                try:
                    get(cmds[2])
                except IndexError:
                    print ("Please give a pattern eg. 'file' ")




            elif ui == 'test':
                fileEntries = validateArchiveIndex()
                invalidFiles = validateFiles()
                #print(fileEntries)
                #print("Correct Entries: %s " % fileEntries['Correct Entries'])
                #print("Incorrect Entries: %s " % archiveList['Incorrect Entries'])

                if fileEntries['Erroneous Paths'] != []:
                    print("Erroneous Paths: %d" % len(fileEntries['Erroneous Paths']))
                    print('\n'.join(' {}: {}'.format(*x) \
                            for x in enumerate(fileEntries['Erroneous Paths'],1)))

            elif ui == 'list':
                if len(cmds) > 2:
                    print('\n'.join('{}: {}'.format(*x) \
                                    for x in enumerate(listFiles(cmds[2]),1)))
                else:
                    listFiles()
                    print('\n'.join('{}: {}'.format(*x) \
                                    for x in enumerate(listFiles(),1)))
            elif ui == 'store' and len(cmds) > 2:
                if os.path.isdir(cmds[2]):
                    store(cmds[2])
                else:
                    print("invalid directory")
        else:
            print("not ready... run 'cat' init")
    else:
        print("run 'init' to initialise the program")

if __name__=="__main__":
    main()

    
