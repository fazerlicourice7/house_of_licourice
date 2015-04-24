# This is a library of functions for a remote controlled car made with the raspberry pi.

import RPi.GPIO as gpio

L0 = 14
L1 = 15
R0 = 23 
R1 = 24

#initializes required gpio pins as outputs 
def init():
  gpio.setmode(gpio.BCM)  # using the official GPIO numbering
  gpio.setwarnings(False)  
  gpio.setup(L0, gpio.OUT)  
  gpio.setup(L1, gpio.OUT)
  gpio.setup(R0, gpio.OUT)
  gpio.setup(R1, gpio.OUT)

#creates a function which makes the car go forward
def forward():
  gpio.ouput(L0, True)
  gpio.output(L1, False)
  gpio.output(R0, True)
  gpio.output(R1, False)
  
#function that makes the car reverse
def reverse():
  gpio.output(L0, False)
  gpio.output(L1, True)
  gpio.output(R0, False)
  gpio.output(R1, True)

#makes the car spin and face left
def spinleft():
  gpio.output(L0, False)
  gpio.output(L1, True)
  gpio.output(R0, True)
  gpio.output(R1, False)

#makes car spin right
def spinright():
  gpio.output(L0, True)
  gpio.output(L1, False)
  gpio.output(R0, False)
  gpio.output(R1, True)

#makes car diagonally to the front (and left)
#def left():
  
#makes car go diagonally to the front (and right)
#def right():

#stops the car by not supplying a current to the motors
def stop():
  gpio.output(L0, False)
  gpio.output(L1, False)
  gpio.output(R0, False)
  gpio.output(R1, False)

# uninitializes all the gpio pins and returns all states to default
def cleanup():
  gpio.cleanup()
  stop()
