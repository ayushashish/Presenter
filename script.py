import os
import ctypes
import pyautogui
import random
import firebase_admin
user32=ctypes.WinDLL('user32')
print ("enter the number on app screen")
x=str(random.randint(1,100000))
print (x)

value_found=1000
prev_value=-1

from firebase_admin import credentials
from firebase_admin import db

cred=credentials.Certificate('presenter-b8540-firebase-adminsdk-imddy-8522b27328.json')
firebase_admin.initialize_app(cred, {
    'databaseURL':'https://presenter-b8540.firebaseio.com/'})
ref=db.reference('/')
ref.update({
    x:"1000"
    })

ref2=db.reference(x)
while(True):
    value_found=int(ref2.get())
    if (prev_value!=value_found):
        if (value_found==0):
            print ("starting slide show")
            pyautogui.press('f5')
        elif (value_found<=20)and(value_found>=1):
            print ("Next slide")
            pyautogui.press('right')
        elif (value_found<=40)and(value_found>=21):
            print ("Previous slide")
            pyautogui.press('left')
        elif (value_found==41):
            print ("Ending slide show")
            pyautogui.press('esc')
            #ref2.delete()
        elif (value_found==42):
            print ("logging out")
            user32.ExitWindowsEx(0)
            break
        elif (value_found==43):
            print ("shut down")
            os.system('shutdown /p /f')
            break
        elif (value_found==44):
            print ("restarting")
            os.system("shutdown -t 0 -r -f")
            break
    prev_value=value_found
