# This is a library of functions for a remote controlled car made with the raspberry pi.

import RPi.GPIO as gpio
L0 = 14  #left motor: connection 0
L1 = 15  #left motor: connection 1
R0 = 23  #right motor: connection 0
R1 = 24  #right motor: connection 1

#initializes required gpio pins as outputs 
def init():
  global left0, left1, right0, right1
  gpio.setmode(gpio.BCM)  # using the official GPIO numbering
  gpio.setwarnings(False)  
  gpio.setup(L0, gpio.OUT)
  left0 = gpio.PWM(L0, 100)  
  gpio.setup(L1, gpio.OUT)
  left1 = gpio.PWM(L1, 100)
  gpio.setup(R0, gpio.OUT)
  right0 = gpio.PWM(R0, 100)
  gpio.setup(R1, gpio.OUT)
  right1 = gpio.PWM(R1, 100)
  #start all the outputs at 0% duty cycle
  left0.start(0)
  left1.start(0)
  right0.start(0)
  right1.start(0)
#creates a function which makes the car go forward
def forward():
  left0.ChangeDutyCycle(100)
  left1.ChangeDutyCycle(0)
  right0.ChangeDutyCycle(100)
  right1.ChangeDutyCycle(0)
  
#function that makes the car reverse
def reverse():
  left0.ChangeDutyCycle(0)
  left1.ChangeDutyCycle(100)
  right0.ChangeDutyCycle(0)
  right1.ChangeDutyCycle(100)

#makes the car spin and face left
def spinleft():
  left0.ChangeDutyCycle(0)
  left1.ChangeDutyCycle(100)
  right0.ChangeDutyCycle(100)
  right1.ChageDutyCycle(0)

#makes car spin right
def spinright():
  left0.ChangeDutyCycle(100)
  left1.ChangeDutyCycle(0)
  right0.CHangeDutyCycle(0)
  right1.ChangeDutyCycle(100)

#makes car diagonally to the front (and left)
def left():
  left0.ChangeDutyCycle(60)
  left1.ChangeDutyCycle(0)
  right0.ChangeDutyCycle(100)
  right1.ChangeDutyCycle(0)

#makes car go diagonally to the front (and right)
def right():
  left0.ChangeDutyCycle(100)
  left1.ChangeDutyCycle(0)
  right0.ChangeDutyCycle(60)
  right1.ChangeDutyCycle(0)

#stops the car by not supplying a current to the motors
def stop():
  left0.ChangeDutyCycle()
  left1.ChangeDutyCycle()
  right0.ChangeDutyCycle()
  right1.ChangeDutyCycle()

#uninitializes all the gpio pins and returns all states to default
def cleanup():
  left0.stop()
  left1.stop()
  right0.stop()
  right1.stop()
  gpio.cleanup()
