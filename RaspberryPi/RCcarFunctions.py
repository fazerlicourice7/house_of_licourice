# This is a library of functions for a remote controlled car made with the raspberry pi.

import RPi.GPIO as gpio

L0 = 14  #left motor: connection 0
L1 = 15  #left motor: connection 1
R0 = 23  #right motor: connection 0
R1 = 24  #right motor: connection 1

#initializes required gpio pins as outputs 
def init():
  global L01, L10, R01, R10
  gpio.setmode(gpio.BCM)  # using the official GPIO numbering
  gpio.setwarnings(False)  
  gpio.setup(L0, gpio.OUT)
  L01 = gpio.PWM(L0, 100)  
  gpio.setup(L1, gpio.OUT)
  L10 = gpio.PWM(L1, 100)
  gpio.setup(R0, gpio.OUT)
  R01 = gpio.PWM(R0, 100)
  gpio.setup(R1, gpio.OUT)
  R10 = gpio.PWM(R1, 100)
  #start all the outputs at 0% duty cycle
  L01.start(0)
  L10.start(0)
  R01.start(0)
  R10.start(0)
#creates a function which makes the car go forward
def forward():
  L01.ChangeDutyCycle(100)
  L10.ChangeDutyCycle(0)
  R01.ChangeDutyCycle(100)
  R10.ChangeDutyCycle(0)
  
#function that makes the car reverse
def reverse():
  L01.ChangeDutyCycle(0)
  L10.ChangeDutyCycle(100)
  R01.ChangeDutyCycle(0)
  R10.ChangeDutyCycle(100)

#makes the car spin and face left
def spinleft():
  L01.ChangeDutyCycle(0)
  L10.ChangeDutyCycle(100)
  R01.ChangeDutyCycle(100)
  R10.ChageDutyCycle(0)

#makes car spin right
def spinright():
  L01.ChangeDutyCycle(100)
  L10.ChangeDutyCycle(0)
  R01.CHangeDutyCycle(0)
  R10.ChangeDutyCycle(100)

#makes car diagonally to the front (and left)
def left():
  L01.ChangeDutyCycle(60)
  L10.ChangedutyCycle(0)
  R01.ChangeDutyCycle(100)
  R10.ChangeDutyCycle(0)

#makes car go diagonally to the front (and right)
def right():
  L01.ChangeDutyCycle(100)
  L10.ChangeDutyCycle(0)
  R01.ChageDutyCycle(60)
  R10.ChangeDutyCycle(0)

#stops the car by not supplying a current to the motors
def stop():
  L01.stop()
  L10.stop()
  R01.stop()
  R10.stop()

#uninitializes all the gpio pins and returns all states to default
def cleanup():
  stop()
  gpio.cleanup()
