# This is a library of functions for a remote controlled car made with the raspberry pi.

import RPi.GPIO as gpio

L0 = 14  #left motor: connection 0
L1 = 15  #left motor: connection 1
R0 = 23  #right motor: connection 0
R1 = 24  #right motor: connection 1

#initializes required gpio pins as outputs 
def init():
  gpio.setmode(gpio.BCM)  # using the official GPIO numbering
  gpio.setwarnings(False)  
  gpio.setup(L0, gpio.OUT)
  l0 = gpio.PWM(L0, 100)  
  gpio.setup(L1, gpio.OUT)
  l1 = gpio.PWM(L1, 100)
  gpio.setup(R0, gpio.OUT)
  r0 = gpio.PWM(R0, 100)
  gpio.setup(R1, gpio.OUT)
  r1 = gpio.PWM(R1, 100)

#creates a function which makes the car go forward
def forward():
  l0.start(100)
  l1.start(0)
  r0.start(100)
  r1.start(0)
  
#function that makes the car reverse
def reverse():
  l0.ChangeDutyCycle(0)
  l1.ChangeDutyCycle(100)
  r0.ChangeDutyCycle(0)
  r1.ChangeDutyCycle(100)

#makes the car spin and face left
def spinleft():
  l0.ChangeDutyCycle(0)
  l1.ChangeDutyCycle(100)
  r0.ChangeDutyCycle(100)
  r1.ChageDutyCycle(0)

#makes car spin right
def spinright():
  l0.ChangeDutyCycle(100)
  l1.ChangeDutyCycle(0)
  r0.CHangeDutyCycle(0)
  r1.ChangeDutyCycle(100)

#makes car diagonally to the front (and left)
def left():
  l0.ChangeDutyCycle(60)
  l1.ChangedutyCycle(0)
  r0.ChangeDutyCycle(100)
  r1.ChangeDutyCycle(0)

#makes car go diagonally to the front (and right)
def right():
  l0.ChangeDutyCycle(100)
  l1.ChangeDutyCycle(0)
  r0.ChageDutyCycle(60)
  r1.ChangeDutyCycle(0)

#stops the car by not supplying a current to the motors
def stop():
  l0.stop()
  l1.stop()
  r0.stop()
  r1.stop()

# uninitializes all the gpio pins and returns all states to default
def cleanup():
  stop()
  gpio.cleanup()
