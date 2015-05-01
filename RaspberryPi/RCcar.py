import pygame, RCcarFunctions

#keyboard reading stuff-stll don't understand it 
import sys
import tty
import termios

UP = 0
DOWN = 1
RIGHT = 2
LEFT = 3

def readchar():
    fd = sys.stdin.fileno()
    old_settings = termios.tcgetattr(fd)
    try:
        tty.setraw(sys.stdin.fileno())
        ch = sys.stdin.read(1)
    finally:
        termios.tcsetattr(fd, termios.TCSADRAIN, old_settings)
    if ch == '0x03':
        raise KeyboardInterrupt
    return ch

def readkey(getchar_fn=None):
    getchar = getchar_fn or readchar
    c1 = getchar()
    if ord(c1) != 0x1b:
        return c1
    c2 = getchar()
    if ord(c2) != 0x5b:
        return c1
    c3 = getchar()
    return ord(c3) - 65  # 0=Up, 1=Down, 2=Right, 3=Left arrows
# end of keyboard reading stuff

#pygame.init()
RCcarFunctions.init()
keypressed = readkey()
try:
  while True:
   #RCcarFunctions.forward()
    #keypressed = pygame.key.get_pressed()
    #for event in pygame.event.get():
     # if event.type == pygame.KEYDOWN:
    if keypressed == 'w':
      RCcarFunctions.forward()
    elif keypressed == 'a':
      RCcarFunctions.spinleft()
    elif keypressed == 's':
      RCcarFunctions.reverse()
    elif keypressed == 'd':
      RCcarFunctions.spinright()
    elif keypressed == ' ': 
      RCcarFunctions.stop()
    #pygame.event.pump()
except KeyboardInterrupt:
  print ("\ncleaning up")
  RCcarFunctions.cleanup()
