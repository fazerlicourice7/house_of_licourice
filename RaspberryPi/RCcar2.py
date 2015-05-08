import RCcarFunctions, termios, os, sys
import tty

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
# End of the functions that read your keyboard
RCcarFunctions.init()

try:
  while True:
    keyp = readkey()
    if keyp == 'w':
      print("accelerating")
      RCcarFunctions.forward()
    elif keyp == 's':
      print("reversing")
      RCcarFunctions.reverse()
    elif keyp == 'a':
      print("turning left")
      RCcarFunctions.spinleft()
    elif keyp == 'd':
      print("turning right")
      RCcarFunctions.spinright()
    elif keyp == ' ':
      print("braking")
      RCcarFunctions.brake()
    else:
      print("stoppping")
      RCcarFunctions.stop()
      break
finally:
  print("cleaning up")
  RCcarFunctions.cleanup()
