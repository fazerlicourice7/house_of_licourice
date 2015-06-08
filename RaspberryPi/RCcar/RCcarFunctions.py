# This is a library of functions for a remote controlled car made with the raspberry pi.
#import time
import RPi.GPIO as gpio

L1 = 9  #left motor: connection 0
L0 = 10  #left motor: connection 1
R1 = 6  #right motor: connection 0
R0 = 5  #right motor: connection 1
SERVO = 18 #servo motor for steering

#initializes required gpio pins as outputs 
def init():
  global left0, left1, right0, right1, servo
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
  gpio.setup(SERVO, gpio.OUT)
  servo = gpio.PWM(SERVO, 50)
  #start all the drive motor outputs at 0% duty cycle
  left0.start(0)
  left1.start(0)
  right0.start(0)
  right1.start(0)
  #starts the servo motor output at 10.75%
  servo.start(11)

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
#def spinleft():
  #left0.ChangeDutyCycle(0)
  #left1.ChangeDutyCycle(100)
  #right0.ChangeDutyCycle(100)
  #right1.ChangeDutyCycle(0)

#makes car spin right
#def spinright():
  #left0.ChangeDutyCycle(100)
  #left1.ChangeDutyCycle(0)
  #right0.ChangeDutyCycle(0)
  #right1.ChangeDutyCycle(100)

#makes car diagonally to the front (and left)
def left():
  #left0.ChangeDutyCycle(10)
  #left1.ChangeDutyCycle(0)
  #right0.ChangeDutyCycle(100)
  #right1.ChangeDutyCycle(0)
  #time.sleep(1)
  #left0.ChangeDutyCycle(100)
  servo.ChangeDutyCycle(15)

#makes car go diagonally to the front (and right)
def right():
  #left0.ChangeDutyCycle(100)
  #left1.ChangeDutyCycle(0)
  #right0.ChangeDutyCycle(10)
  #right1.ChangeDutyCycle(0)
  #time.sleep(1)
  #right0.ChangeDutyCycle(100)
  servo.ChangeDutyCycle(9)

#resets the servo's position to face straight
def straight():
  servo.ChangeDutyCycle(11)

#reduces the current supplied to the motors to 0
def brake():
  left0.ChangeDutyCycle(0)
  left1.ChangeDutyCycle(0)
  right0.ChangeDutyCycle(0)
  right1.ChangeDutyCycle(0)

#stops all the pwm outputs going to the motors
def stop():
  left0.stop()
  left1.stop()
  right0.stop()
  right1.stop()
  servo.ChangeDutyCycle(11)
  servo.stop()

#uninitializes all the gpio pins and returns all states to default
def cleanup():
  stop()
  gpio.cleanup()
